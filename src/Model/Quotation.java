package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;

public class Quotation {

    private int quotationId;
    private int finalAmount;
    private Date date;
    private String status;
    private int orderId;

    //Setters
    public void setQuotationId(int quotationId) {
        this.quotationId = quotationId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public void setFinalAmount(int finalAmount) {
        this.finalAmount = finalAmount;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    //Getters
    public int getQuotationId() {
        return quotationId;
    }

    public int getOrderId() {
        return orderId;
    }

    public int getfinalAmount() {
        return finalAmount;
    }

    public Date getDate() {
        return date;
    }

    public String getStatus() {
        return status;
    }

    public Quotation() {

    }

    public Quotation(int quotationId, Date issuedDate, String status, int finalAmount) {

        this.quotationId = quotationId;
        this.date = issuedDate;
        this.status = status;
        this.finalAmount = finalAmount;

    }

    public boolean createQuotation(int finalAmount, int prescriptionId, int customerId, int pharmacistId, List<ProductPriceDetails> productDetails) {
        try (Connection con = DatabaseConnection.getConnection(); PreparedStatement st = con.prepareStatement("INSERT INTO qoutation (final_amount, pre_id, cid, phar_id) VALUES (?,?,?,?)", Statement.RETURN_GENERATED_KEYS); PreparedStatement st2 = con.prepareStatement("INSERT INTO qoutation_has_products(qid, pid, quantity, amount) VALUES (?,?,?,?)")) {

            st.setFloat(1, finalAmount);
            st.setInt(2, prescriptionId);
            st.setInt(3, customerId);
            st.setInt(4, pharmacistId);
            int i = st.executeUpdate();

            if (i == 1) {
                ResultSet rst = st.getGeneratedKeys();
                if (rst.next()) {
                    setQuotationId(rst.getInt(1));
                }

                for (ProductPriceDetails product : productDetails) {
                    st2.setInt(1, getQuotationId());
                    st2.setString(2, product.getProductId());
                    st2.setInt(3, product.getQuantity());
                    st2.setFloat(4, product.getAmount());
                    st2.executeUpdate();
                    st2.clearParameters();
                }
                return true;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Database Error"+ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }
    

    public List <Quotation> getQuotationDetails(int customerId) {
        try (Connection con = DatabaseConnection.getConnection(); PreparedStatement st = con.prepareStatement("SELECT quotation_id, date, status, final_amount FROM qoutation where cid = ? AND status = 'pending' ")) {
            List <Quotation> quotation = new ArrayList<>();
            st.setInt(1, customerId);
            try (ResultSet rst = st.executeQuery()) {
                while (rst.next()) {
                    quotation.add( new Quotation(rst.getInt(1), rst.getDate(2), rst.getString(3), rst.getInt(4)));
                }
                return quotation;
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Database Error", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }

    public List<ProductPriceDetails> getQuotationProductDetails(int quotationId) {
        List<ProductPriceDetails> productList = new ArrayList<>();
        try (Connection con = DatabaseConnection.getConnection(); PreparedStatement st = con.prepareStatement("SELECT product.product_id, product.generic, product.dosage, qoutation_has_products.quantity, qoutation_has_products.amount FROM qoutation_has_products INNER JOIN product ON qoutation_has_products.pid = product.product_id where qoutation_has_products.qid = ? ")) {

            st.setInt(1, quotationId);
            try (ResultSet rst = st.executeQuery()) {
                while (rst.next()) {
                    
                    productList.add(new ProductPriceDetails(rst.getString(1),rst.getString(2), rst.getString(3), rst.getInt(4), rst.getInt(5)));

                }
                
                return productList;

            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Database Error", "Error", JOptionPane.ERROR_MESSAGE);
        }

        return null;
    }

    public boolean cancelQuotation(int quotationId) {
        try (Connection con = DatabaseConnection.getConnection(); PreparedStatement st = con.prepareStatement("UPDATE `qoutation` SET `status`= 'canceled' WHERE quotation_id = ?")) {

            st.setInt(1, quotationId);
            return st.executeUpdate() == 1;

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Database Error", "Error", JOptionPane.ERROR_MESSAGE);
        }

        return false;
    }
    
    public int getPrescriptionId(int quotationId){
         try (Connection con = DatabaseConnection.getConnection(); PreparedStatement st = con.prepareStatement("SELECT pre_id FROM qoutation where quotation_id = ?")) {
            int preId = 0;
            st.setInt(1, quotationId);
            try (ResultSet rst = st.executeQuery()) {
                while (rst.next()) {
                    preId = rst.getInt(1);
                }
                return preId;
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Database Error", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return 0;
    }
    
   
    

}
