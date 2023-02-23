package Model;

import java.sql.*;
import javax.swing.JOptionPane;

public class Customer {

    private int customerId;
    private String firstName;
    private String lastName;
    private String streetAddress;
    private String city;
    private String email;
    private int telephone;
    private int uid;

    public Customer() {

    }

    public Customer(String firstName, String lastName, String streetAddress, String city, String email, int telephone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.streetAddress = streetAddress;
        this.city = city;
        this.email = email;
        this.telephone = telephone;
    }

    //Setters
    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    //Getters
    public int getCustomerId() {
        return customerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public String getCity() {
        return city;
    }

    public String getEmail() {
        return email;
    }

    public int getTelephone() {
        return telephone;
    }

    public int getUid() {
        return uid;
    }

    public boolean register(String firstName, String lastName, String streetAddress, String city, String email, int telephone, String username, String password) {
        try (Connection conn = DatabaseConnection.getConnection()) {
            conn.setAutoCommit(false);
            try (PreparedStatement st = conn.prepareStatement("INSERT INTO customer (fname, lname, street_address, city, email, telephone) VALUES (?, ?, ?, ?, ?, ?);"); PreparedStatement st2 = conn.prepareStatement("INSERT INTO `user_login_credentials`( `username`, `password`, `role`) VALUES (? , ? , ?);"); PreparedStatement st3 = conn.prepareStatement("UPDATE customer SET uid = (SELECT user_id FROM user_login_credentials WHERE username = ? AND password = ?) WHERE customer_id = ?"); PreparedStatement st4 = conn.prepareStatement("SELECT MAX(customer_id) FROM customer")) {

                st.setString(1, firstName);
                st.setString(2, lastName);
                st.setString(3, streetAddress);
                st.setString(4, city);
                st.setString(5, email);
                st.setInt(6, telephone);
                st2.setString(1, username);
                st2.setString(2, password);
                st2.setString(3, "customer");

                int i = st.executeUpdate() + st2.executeUpdate();

                ResultSet rst = st4.executeQuery();

                while (rst.next()) {
                    setCustomerId(rst.getInt(1));
                }

                st3.setString(1, username);
                st3.setString(2, password);
                st3.setInt(3, getCustomerId());

                i = i + st3.executeUpdate();

                if (i == 3) {
                    conn.commit();
                    return true;
                } else {
                    conn.rollback();
                    return false;
                }
            } catch (SQLException ex) {
                conn.rollback();
                JOptionPane.showMessageDialog(null, "Customer registration failed.", "Error" , JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Failed to establish database connection.", "Error" , JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }
    Customer cus;

    public Customer getCustomerDetails(int customerId) {

        String sql = "SELECT `fname`, `lname`, `street_address`, `city`, `email`, `telephone` FROM `customer` WHERE customer_id = ?";
        try (Connection con = DatabaseConnection.getConnection(); PreparedStatement st1 = con.prepareStatement(sql)) {

            st1.setInt(1, customerId);
            ResultSet rst = st1.executeQuery();
            while (rst.next()) {
                cus = new Customer(rst.getString(1), rst.getString(2), rst.getString(3), rst.getString(4), rst.getString(5), rst.getInt(6));
            }

            return cus;

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Failed to establish database connection.", "Error" , JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }

    public boolean updateCustomerInformation(int customerId, String firstName, String lastName, String streetAddress, String city, String email, int telephone) {
        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement st1 = conn.prepareStatement("UPDATE `customer` SET `fname`= ?,`lname`= ?,`street_address`= ?,`city`= ?,`email`= ?,`telephone`= ? WHERE `customer_id`= ?");) {

            st1.setString(1, firstName);
            st1.setString(2, lastName);
            st1.setString(3, streetAddress);
            st1.setString(4, city);
            st1.setString(5, email);
            st1.setInt(6, telephone);
            st1.setInt(7, customerId);

            return st1.executeUpdate() == 1;

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Customer update failed.", "Error" , JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }

}
