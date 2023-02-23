package Model;

import java.sql.*;
import javax.swing.JOptionPane;

public class Pharmacist {

    private int pharmacistId;
    private String firstName;
    private String lastName;
    private String streetAddress;
    private String city;
    private String email;
    private int telephone;
    private int uid;

    public void setPharmacistId(int customerId) {
        this.pharmacistId = customerId;
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
    public int getPharmacistId() {
        return pharmacistId;
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
            try (PreparedStatement st = conn.prepareStatement(
                    "INSERT INTO pharmacist (fname, lname, street_address, city, email, telephone) VALUES (?, ?, ?, ?, ?, ?);" +
                            "INSERT INTO user_login_credentials (username, password, role) VALUES (?, ?, 'pharmacist');" +
                            "UPDATE pharmacist SET uid = (SELECT user_id FROM user_login_credentials WHERE username = ? AND password = ?) WHERE pharmacist_id = (SELECT MAX(pharmacist_id) FROM pharmacist);")) {
                st.setString(1, firstName);
                st.setString(2, lastName);
                st.setString(3, streetAddress);
                st.setString(4, city);
                st.setString(5, email);
                st.setInt(6, telephone);
                st.setString(7, username);
                st.setString(8, password);
                st.setString(9, username);
                st.setString(10, password);
                if (st.executeUpdate() == 3) {
                    conn.commit();
                    return true;
                } else {
                    conn.rollback();
                    return false;
                }
            } catch (SQLException ex) {
                conn.rollback();
                JOptionPane.showMessageDialog(null, "Pharmacist registration failed.", "Error" , JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Database Failure", "Error" , JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }


}
