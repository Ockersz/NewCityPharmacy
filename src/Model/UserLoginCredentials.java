package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class UserLoginCredentials {

    private int userId;
    private String username;
    private String password;
    private String role;

    //setters
    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setRole(String role) {
        this.role = role;
    }

    //getters
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public int getUserId() {
        return userId;
    }

    public String getRole() {
        return role;
    }

    public String login(String username, String password) {
        try {
            ResultSet rst;
            Statement st = DatabaseConnection.getConnection().createStatement();
            rst = st.executeQuery("SELECT user_id,role FROM user_login_credentials where username = '" + username + "' AND password = '" + password + "'");

            while (rst.next()) {
                setUserId(rst.getInt(1));
                setRole(rst.getString(2));
                setUsername(username);
                setPassword(password);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Database connection error " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        return getRole();
    }

    public int getCustomerId(String username, String password) {
        try (Connection con = DatabaseConnection.getConnection(); PreparedStatement st1 = con.prepareStatement("Select customer.customer_id from customer INNER JOIN user_login_credentials ON customer.uid = user_login_credentials.user_id where user_login_credentials.username = ? AND user_login_credentials.password = ? ");) {

            st1.setString(1, username);
            st1.setString(2, password);

            ResultSet rst = st1.executeQuery();

            while (rst.next()) {
                return rst.getInt(1);
            }

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "Could not recieve customer details. Database Error", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return 0;
    }

}
