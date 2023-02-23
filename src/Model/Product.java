package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Product {

    private String productId;
    private String generic;
    private String brand;
    private String company;
    private String dosage;
    private String category;
    private Date expiryDate;
    private int availableQuantity;
    private int unitPrice;

    public String getProductId() {
        return productId;
    }

    public String getGeneric() {
        return generic;
    }

    public String getBrand() {
        return brand;
    }

    public String getCompany() {
        return company;
    }

    public String getDosage() {
        return dosage;
    }

    public String getCategory() {
        return category;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public int getAvailableQuantity() {
        return availableQuantity;
    }

    public int getUnitPrice() {
        return unitPrice;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public void setGeneric(String generic) {
        this.generic = generic;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    public void setAvailableQuantity(int availableQuantity) {
        this.availableQuantity = availableQuantity;
    }

    public void setUnitPrice(int unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Product(String productId, String generic, String dosage, int availableQuantity) {

        this.productId = productId;
        this.generic = generic;
        this.dosage = dosage;
        this.availableQuantity = availableQuantity;

    }
    
    public Product(String productId, String generic, String dosage,int availableQuantity, Date expiryDate) {

        this.productId = productId;
        this.generic = generic;
        this.dosage = dosage;
        this.availableQuantity = availableQuantity;
        this.expiryDate = expiryDate;

    }

    public Product(String generic, String brand, String company, String dosage, String category, Date expiryDate, int availableQuantity, int unitPrice) {

        this.generic = generic;
        this.brand = brand;
        this.company = company;
        this.dosage = dosage;
        this.category = category;
        this.expiryDate = expiryDate;
        this.availableQuantity = availableQuantity;
        this.unitPrice = unitPrice;
    }

    public Product() {

    }

    public String getMaxProductId() {

        String sql = "Select MAX(product_id) from product";
        try (Connection con = DatabaseConnection.getConnection(); PreparedStatement st1 = con.prepareStatement(sql)) {

            ResultSet rst = st1.executeQuery();
            while (rst.next()) {
                return rst.getString(1);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Could not recieve product id. Database Error", "Error" , JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }

    public boolean addProduct(String productId, String generic, String brand, String company, String dosage, String category, Date expiryDate, int availableQuantity, int unitPrice) {

        String strExpiryDate;

        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        strExpiryDate = format.format(expiryDate);

        String sql = "INSERT INTO `product`(`product_id`, `generic`, `brand`, `company`, `dosage`, `category`, `exp_date`, `avail_quantity`, `unit_price`) VALUES ( ? , ? , ? , ? , ? , ? , ? , ? , ?)";
        try (Connection con = DatabaseConnection.getConnection(); PreparedStatement st1 = con.prepareStatement(sql)) {

            st1.setString(1, productId);
            st1.setString(2, generic);
            st1.setString(3, brand);
            st1.setString(4, company);
            st1.setString(5, dosage);
            st1.setString(6, category);
            st1.setString(7, strExpiryDate);
            st1.setInt(8, availableQuantity);
            st1.setInt(9, unitPrice);

            return st1.executeUpdate() == 1;

        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null, "Could not add product. Database Error", "Error" , JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }

    public List<Product> getProductShortDetail() {

        List<Product> products = new ArrayList<>();
        String sql = "SELECT `product_id`, `generic`,`dosage`,`avail_quantity` FROM `product` WHERE avail_quantity > 0";
        try (Connection con = DatabaseConnection.getConnection(); PreparedStatement st1 = con.prepareStatement(sql)) {

            try (ResultSet rst = st1.executeQuery()) {
                while (rst.next()) {
                    String productId = rst.getString(1);
                    String generic = rst.getString(2);
                    String dosage = rst.getString(3);
                    int available_quantity = rst.getInt(4);

                    products.add(new Product(productId, generic, dosage, available_quantity));
                }
            }

            return products;

        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null, "Could not recieve product details. Database Error", "Error" , JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }

    public Product getProductAllDetails(String productId) {

        Product product = null;
        String sql = "SELECT  `generic`, `brand`, `company`, `dosage`, `category`, `exp_date`, `avail_quantity`, `unit_price` FROM `product` WHERE product_id = ? ";
        try (Connection con = DatabaseConnection.getConnection(); PreparedStatement st1 = con.prepareStatement(sql)) {

            st1.setString(1, productId);
            try (ResultSet rst = st1.executeQuery()) {
                while (rst.next()) {

                    String generic = rst.getString(1);
                    String brand = rst.getString(2);
                    String company = rst.getString(3);
                    String dosage = rst.getString(4);
                    String category = rst.getString(5);
                    Date exp_date = rst.getDate(6);
                    int avail_quantity = rst.getInt(7);
                    int unit_price = rst.getInt(8);

                    product = new Product(generic, brand, company, dosage, category, exp_date, avail_quantity, unit_price);
                }
                return product;
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Could not recieve product details. Database Error", "Error" , JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }

    public boolean updateProduct(String productId, String generic, String brand, String company, String dosage, String category, Date expiryDate, int availableQuantity, int unitPrice) {

        String strExpiryDate;

        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        strExpiryDate = format.format(expiryDate);

        String sql = "UPDATE `product` SET `generic`= ? ,`brand`= ? ,`company`= ? ,`dosage`= ? ,`category`=  ? ,`exp_date`= ? ,`avail_quantity`= ? ,`unit_price`= ? WHERE product_id = ? ";
        try (Connection con = DatabaseConnection.getConnection(); PreparedStatement st1 = con.prepareStatement(sql)) {

            st1.setString(1, generic);
            st1.setString(2, brand);
            st1.setString(3, company);
            st1.setString(4, dosage);
            st1.setString(5, category);
            st1.setString(6, strExpiryDate);
            st1.setInt(7, availableQuantity);
            st1.setInt(8, unitPrice);
            st1.setString(9, productId);

            return st1.executeUpdate() == 1;

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Could not update product details. Database Error", "Error" , JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }

    public boolean deleteProduct(String productId) {

        String sql = "Update product set avail_quantity = 0 where product_id = ?";
        try (Connection con = DatabaseConnection.getConnection(); PreparedStatement st1 = con.prepareStatement(sql)) {

            st1.setString(1, productId);
            return st1.executeUpdate() == 1;

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Could not delete product details. Database Error", "Error" , JOptionPane.ERROR_MESSAGE);
        }
        return false;

    }

    public DefaultTableModel getProductDetails() {

        String sql = "SELECT `product_id`, `generic`, `brand`, `company`, `dosage`, `category`, `exp_date`, `avail_quantity`, `unit_price` FROM `product` ";
        DefaultTableModel dtm = new DefaultTableModel();
        dtm.addColumn("Product ID");
        dtm.addColumn("Generic Name");
        dtm.addColumn("Brand Name");
        dtm.addColumn("Company");
        dtm.addColumn("Dosage");
        dtm.addColumn("Category");
        dtm.addColumn("Expiry Date");
        dtm.addColumn("Quantity Available");
        dtm.addColumn("Unit Price");

        try (Connection con = DatabaseConnection.getConnection(); PreparedStatement st1 = con.prepareStatement(sql)) {
            SimpleDateFormat simple = new SimpleDateFormat("dd-MM-yyyy");
            String strdate;
            try (ResultSet rst = st1.executeQuery()) {
                while (rst.next()) {

                    strdate = simple.format(rst.getDate(7));
                    String[] values = new String[9];
                    values[0] = rst.getString(1);
                    values[1] = rst.getString(2);
                    values[2] = rst.getString(3);
                    values[3] = rst.getString(4);
                    values[4] = rst.getString(5);
                    values[5] = rst.getString(6);
                    values[6] = strdate;
                    values[7] = Integer.toString(rst.getInt(8));
                    values[8] = Integer.toString(rst.getInt(9));

                    dtm.addRow(values);
                }
                return dtm;
            }

        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null, "Could not recieve product details. Database Error", "Error" , JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }

    public String getGenericName(String productId) {
        String generic = null;
        String sql = "Select generic from product where product_id = ?";
        try (Connection con = DatabaseConnection.getConnection(); PreparedStatement st1 = con.prepareStatement(sql)) {

            st1.setString(1, productId);

            try (ResultSet rst = st1.executeQuery()) {
                while (rst.next()) {
                    generic = rst.getString(1);
                }
                return generic;
            }

        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null, "Could not recieve product details. Database Error", "Error" , JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }

    public int getUnitPrice(String productId) {
        int unitPrice = 0;
        String sql = "Select unit_price from product where product_id = ?";
        try (Connection con = DatabaseConnection.getConnection(); PreparedStatement st1 = con.prepareStatement(sql)) {

            st1.setString(1, productId);

            try (ResultSet rst = st1.executeQuery()) {
                while (rst.next()) {
                    unitPrice = rst.getInt(1);
                }
                return unitPrice;
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Could not recieve product details. Database Error", "Error" , JOptionPane.ERROR_MESSAGE);
        }
        return 0;
    }

    public int getAvailableQuantity(String productId) {
        int quantity = 0;
        String sql = "Select avail_quantity from product where product_id = ?";
        try (Connection con = DatabaseConnection.getConnection(); PreparedStatement st1 = con.prepareStatement(sql)) {

            st1.setString(1, productId);

            try (ResultSet rst = st1.executeQuery()) {
                while (rst.next()) {
                    quantity = rst.getInt(1);
                }
                return quantity;
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Could not recieve product details. Database Error", "Error" , JOptionPane.ERROR_MESSAGE);
        }
        return 0;
    }

    public String getDosage(String productId) {
        String dosage = null;
        String sql = "Select dosage from product where product_id = ?";
        try (Connection con = DatabaseConnection.getConnection(); PreparedStatement st1 = con.prepareStatement(sql)) {

            st1.setString(1, productId);

            try (ResultSet rst = st1.executeQuery()) {
                while (rst.next()) {
                    dosage = rst.getString(1);
                }
                return dosage;
            }

        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null, "Could not recieve product details. Database Error", "Error" , JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }

    public List<Product> getLowStockProducts() {

        String sql = "Select product_id, generic, dosage, avail_quantity from Product where avail_quantity <= 20";
        List<Product> list = new ArrayList<>();
        try (Connection con = DatabaseConnection.getConnection(); PreparedStatement st1 = con.prepareStatement(sql)) {

            try (ResultSet rst = st1.executeQuery()) {
                while (rst.next()) {
                    String productId = rst.getString(1);
                    String generic = rst.getString(2);
                    String dosage = rst.getString(3);
                    int availableQuantity = rst.getInt(4);
                    list.add(new Product(productId, generic, dosage, availableQuantity));
                }
            }
            return list;
        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null, "Could not recieve product details. Database Error", "Error" , JOptionPane.ERROR_MESSAGE);
        }
        return null;

    }
    
    public List<Product> getExpiryProducts(){
        String sql = "SELECT product_id, generic, dosage, avail_quantity, exp_date FROM product WHERE exp_date BETWEEN (CURDATE() + INTERVAL 0 DAY) AND (CURDATE() + INTERVAL 30 DAY)";
        List<Product> list = new ArrayList<>();
        try (Connection con = DatabaseConnection.getConnection(); PreparedStatement st1 = con.prepareStatement(sql)) {

            try (ResultSet rst = st1.executeQuery()) {
                while (rst.next()) {
                    String productId = rst.getString(1);
                    String generic = rst.getString(2);
                    String dosage = rst.getString(3);
                    int quantity = rst.getInt(4);
                    Date expiryDate = rst.getDate(5);
                    list.add(new Product(productId, generic, dosage,quantity, expiryDate));
                }
            }
            return list;
        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null, "Could not recieve product details. Database Error", "Error" , JOptionPane.ERROR_MESSAGE);
        }
        
        return null;

    }

}
