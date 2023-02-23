package Model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

public class Order {
    
    private int orderId;
    private int orderAmount;
    private Date date;
    private String status;

    //Setters
    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }
    
    public void setOrderAmount(int orderAmount) {
        this.orderAmount = orderAmount;
    }
    
    public void setDate(Date date) {
        this.date = date;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }

    //Getters
    public int getOrderId() {
        return orderId;
    }
    
    public int getOrderAmount() {
        return orderAmount;
    }
    
    public Date getDate() {
        return date;
    }
    
    public String getStatus() {
        return status;
    }
    
    public Order() {
        
    }
    
    public Order(int orderId, int orderAmount, Date date, String status) {
        
        this.orderAmount = orderAmount;
        this.orderId = orderId;
        this.date = date;
        this.status = status;
        
    }
    
    public boolean confirmOrder(int orderAmount, int quotationId, int customerId, List<ProductPriceDetails> productDetails) {
        int invoiceId = 0;
        try (Connection con = DatabaseConnection.getConnection()) {
            con.setAutoCommit(false); // start transaction
            try (PreparedStatement st = con.prepareStatement("INSERT INTO `orders`( `order_amount`, `qid`, `cid`) VALUES  (?,?,?)", Statement.RETURN_GENERATED_KEYS); PreparedStatement st2 = con.prepareStatement("INSERT INTO order_has_products(oid, pid, quantity, amount) VALUES (?,?,?,?)"); PreparedStatement st3 = con.prepareStatement("UPDATE product JOIN order_has_products ON product.product_id = order_has_products.pid SET product.avail_quantity = product.avail_quantity - order_has_products.quantity WHERE order_has_products.oid = ?"); PreparedStatement st4 = con.prepareStatement("INSERT INTO `invoice`( `amount`, `payment_method`) VALUES (?, ?)", Statement.RETURN_GENERATED_KEYS); PreparedStatement st5 = con.prepareStatement("INSERT INTO `invoice_has_products`(`inv_id`, `pid`) VALUES (?,?)"); 
                    PreparedStatement st6 = con.prepareStatement("Select email from customer where customer_id = ?")) {
                
                st.setInt(1, orderAmount);
                st.setInt(2, quotationId);
                st.setInt(3, customerId);
                
                int i = st.executeUpdate();
                
                if (i == 1) {
                    ResultSet rst = st.getGeneratedKeys();
                    if (rst.next()) {
                        setOrderId(rst.getInt(1));
                    }
                    
                    for (ProductPriceDetails product : productDetails) {
                        st2.setInt(1, getOrderId());
                        st2.setString(2, product.getProductId());
                        st2.setInt(3, product.getQuantity());
                        st2.setFloat(4, product.getAmount());
                        st2.addBatch();
                    }
                    st2.executeBatch(); // execute all queries together
                    st2.clearBatch();
                    st2.clearParameters();
                    st2.addBatch("UPDATE `qoutation` SET `status`= 'confirmed' WHERE quotation_id = " + quotationId);
                    int[] updateCounts = st2.executeBatch();
                    if (updateCounts[updateCounts.length - 1] == 1) {
                        st3.setInt(1, getOrderId());
                        st3.executeUpdate();
                        st4.setInt(1, orderAmount);
                        st4.setString(2, "online");
                        st4.executeUpdate();
                        
                        ResultSet rst2 = st4.getGeneratedKeys();
                        while (rst2.next()) {
                            invoiceId = rst2.getInt(1);
                        }
                        for (ProductPriceDetails product : productDetails) {
                            st5.setInt(1, invoiceId);
                            st5.setString(2, product.getProductId());
                            st5.addBatch();
                        }
                        st5.executeBatch();
                        st5.clearBatch();
                        st5.clearParameters();
                        st5.addBatch("INSERT INTO `sales_invoice`(`oid`, `s_inv_id`) VALUES ('" + getOrderId() + "', '" + invoiceId + "')");
                        st5.executeBatch();
                        
                        st6.setInt(1, customerId);
                        con.commit(); // commit all changes if success
                        ResultSet rst3 = st6.executeQuery();
                        if (rst3.next()) {
                            sendInvoice(rst3.getString(1), orderId);
                        }
                        return true;
                        

                    }
                }
            } catch (SQLException ex) {
                con.rollback(); // rollback all changes if any exception occurs
                JOptionPane.showMessageDialog(null, "Database Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            } finally {
                con.setAutoCommit(true); // set back to default auto-commit mode
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Database Connection Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }
    
    public List<Order> getOrders(int customerId) {
        
        List<Order> orders = new ArrayList<>();
        String sql = "Select order_id, order_amount, date, status from orders where cid = ?";
        try (Connection con = DatabaseConnection.getConnection(); PreparedStatement st1 = con.prepareStatement(sql)) {
            
            st1.setInt(1, customerId);
            try (ResultSet rst = st1.executeQuery()) {
                while (rst.next()) {
                    int orderId = rst.getInt(1);
                    int orderAmount = rst.getInt(2);
                    Date date = rst.getDate(3);
                    String status = rst.getString(4);
                    orders.add(new Order(orderId, orderAmount, date, status));
                    
                }
                return orders;
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Database Connection Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }
    
    public List<Order> getOrders() {
        
        List<Order> orders = new ArrayList<>();
        String sql = "Select order_id, order_amount, date, status from orders ";
        try (Connection con = DatabaseConnection.getConnection(); PreparedStatement st1 = con.prepareStatement(sql)) {
            
            try (ResultSet rst = st1.executeQuery()) {
                while (rst.next()) {
                    int orderId = rst.getInt(1);
                    int orderAmount = rst.getInt(2);
                    Date date = rst.getDate(3);
                    String status = rst.getString(4);
                    orders.add(new Order(orderId, orderAmount, date, status));
                    
                }
                return orders;
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Database Connection Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }
    
    public List<ProductPriceDetails> getOrderProducts(int orderId) {
        List<ProductPriceDetails> productList = new ArrayList<>();
        try (Connection con = DatabaseConnection.getConnection(); PreparedStatement st = con.prepareStatement("SELECT product.product_id, product.generic, product.dosage, order_has_products.quantity, order_has_products.amount FROM order_has_products INNER JOIN product ON order_has_products.pid = product.product_id where order_has_products.oid = ? ")) {
            
            st.setInt(1, orderId);
            try (ResultSet rst = st.executeQuery()) {
                while (rst.next()) {
                    
                    productList.add(new ProductPriceDetails(rst.getString(1), rst.getString(2), rst.getString(3), rst.getInt(4), rst.getInt(5)));
                    
                }
                
                return productList;
                
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Database Error", "Error", JOptionPane.ERROR_MESSAGE);
        }
        
        return null;
    }
    
    public String getStatus(int orderId) {
        String sql = "Select status from Orders where order_id = ? ";
        String status = null;
        try (Connection con = DatabaseConnection.getConnection(); PreparedStatement st1 = con.prepareStatement(sql)) {
            
            st1.setInt(1, orderId);
            try (ResultSet rst = st1.executeQuery()) {
                while (rst.next()) {
                    status = rst.getString(1);
                }
                return status;
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Database Error", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }
    
    public Date getDate(int orderId) {
        String sql = "SELECT  `date` FROM `orders` WHERE order_id = ?";
        Date date = null;
        try (Connection con = DatabaseConnection.getConnection(); PreparedStatement st1 = con.prepareStatement(sql)) {
            
            st1.setInt(1, orderId);
            
            try (ResultSet rst = st1.executeQuery()) {
                
                while (rst.next()) {
                    date = rst.getDate(1);
                }
                return date;
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Database Error", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }
    
    public String getCustomerName(int orderId) {
        String sql = "SELECT customer.fname, customer.lname FROM customer INNER JOIN orders ON customer.customer_id = orders.cid WHERE orders.order_id = ?";
        String name = new String();
        try (Connection con = DatabaseConnection.getConnection(); PreparedStatement st1 = con.prepareStatement(sql)) {
            
            st1.setInt(1, orderId);
            try (ResultSet rst = st1.executeQuery()) {
                while (rst.next()) {
                    name += rst.getString(1);
                    name += " ";
                    name += rst.getString(2);
                    
                }
                return name;
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Database Error", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }
    
    public String getCustomerAddress(int orderId) {
        String sql = " SELECT customer.street_address, customer.city FROM customer INNER JOIN orders ON customer.customer_id = orders.cid WHERE orders.order_id = ?";
        String address = new String();
        try (Connection con = DatabaseConnection.getConnection(); PreparedStatement st1 = con.prepareStatement(sql)) {
            
            st1.setInt(1, orderId);
            try (ResultSet rst = st1.executeQuery()) {
                while (rst.next()) {
                    address += rst.getString(1);
                    address += " ";
                    address += rst.getString(2);
                    
                }
                return address;
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Database Error", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }
    
    public int getCustomerTelephone(int orderId) {
        String sql = " SELECT customer.telephone FROM customer INNER JOIN orders ON customer.customer_id = orders.cid WHERE orders.order_id = ?";
        int tp = 0;
        try (Connection con = DatabaseConnection.getConnection(); PreparedStatement st1 = con.prepareStatement(sql)) {
            
            st1.setInt(1, orderId);
            try (ResultSet rst = st1.executeQuery()) {
                while (rst.next()) {
                    tp = rst.getInt(1);
                    
                }
                return tp;
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Database Error", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return 0;
    }
    
    public int getQuotationId(int orderId) {
        String sql = "Select qid from orders where order_id = ?";
        int qid = 0;
        try (Connection con = DatabaseConnection.getConnection(); PreparedStatement st1 = con.prepareStatement(sql)) {
            
            st1.setInt(1, orderId);
            try (ResultSet rst = st1.executeQuery()) {
                while (rst.next()) {
                    qid = rst.getInt(1);
                }
                return qid;
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Database Error", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return 0;
    }
    
    public int getAmount(int orderId) {
        String sql = "Select order_amount from orders where order_id = ?";
        int orderAmount = 0;
        try (Connection con = DatabaseConnection.getConnection(); PreparedStatement st1 = con.prepareStatement(sql)) {
            
            st1.setInt(1, orderId);
            try (ResultSet rst = st1.executeQuery()) {
                while (rst.next()) {
                    orderAmount = rst.getInt(1);
                }
                return orderAmount;
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Database Error" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return 0;
    }
    
    public boolean shipOrder(int orderId) {
        String sql = "Update orders SET status = 'shipped' where order_id = ?";
        
        try (Connection con = DatabaseConnection.getConnection(); PreparedStatement st1 = con.prepareStatement(sql)) {
            
            st1.setInt(1, orderId);
            return st1.executeUpdate() == 1;
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Database Error" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return false;
        
    }
    
    public boolean cancelOrder(int orderId) {
        String sql = "Update orders SET status = 'canceled' where order_id = ?";
        
        try (Connection con = DatabaseConnection.getConnection(); PreparedStatement st1 = con.prepareStatement(sql)) {
            
            st1.setInt(1, orderId);
            return st1.executeUpdate() == 1;
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Database Error" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return false;
        
    }
    
    public boolean sendInvoice(String email, int orderId) {
        
        String to = email;
        String from = "daredevildare600@gmail.com";
        final String username = "daredevildare600@gmail.com";
        final String password = "bgxckfngnothstbo";
        String host = "smtp.gmail.com";
        
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", "587");
        
        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });
        
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
            message.setSubject("Order Invoice");
            
            Multipart multipart = new MimeMultipart();
            BodyPart textBodyPart = new MimeBodyPart();
            String htmlText = "<H2>Your order has been placed and will be delivered within 3 business days.</H2>";
            textBodyPart.setContent(htmlText, "text/html");
            multipart.addBodyPart(textBodyPart);
            
            String path = "jdbc:mysql://localhost/newcitypharmacy";
            Connection connetion = DriverManager.getConnection(path, "root", "root");
            JasperReport jasperReport = JasperCompileManager.compileReport("D:\\NIBM\\EAD\\Projects\\BetaTesting\\src\\View\\invoice.jrxml");
            Map<String, Object> parameters = new HashMap<>();
            parameters.put("orderId", orderId);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, connetion);
            
            File pdfFile = new File("invoiceOrder.pdf");
            FileOutputStream fos = new FileOutputStream(pdfFile);
            JasperExportManager.exportReportToPdfStream(jasperPrint, fos);
            DataSource source = new FileDataSource(pdfFile);
            
            BodyPart messageBodyPart = new MimeBodyPart();
            messageBodyPart.setDataHandler(new DataHandler(source));
            messageBodyPart.setFileName("invoiceOrder.pdf");
            multipart.addBodyPart(messageBodyPart);
            
            message.setContent(multipart);
            Transport.send(message);
            System.out.println("Sent message successfully....");
            return true;
        } catch (JRException | SQLException | FileNotFoundException | MessagingException e) {
           JOptionPane.showMessageDialog(null, "Unknnown error occured " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }
    
}
