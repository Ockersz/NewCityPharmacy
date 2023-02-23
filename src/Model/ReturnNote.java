package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import javax.swing.JOptionPane;

public class ReturnNote {

    private int returnId;
    private Date date;
    private String reason;

    //Setters
    public void setReturnId(int returnId) {
        this.returnId = returnId;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    //Getters
    public int getReturnId() {
        return returnId;
    }

    public Date getDate() {
        return date;
    }

    public String getReason() {
        return reason;
    }

    public void returnOrder(int orderId, String reason, int customerId) {

        try (Connection con = DatabaseConnection.getConnection(); PreparedStatement st1 = con.prepareStatement("insert into return_note (reason, cid, oid) values (?,?,?)")) {

            st1.setString(1, reason);
            st1.setInt(2, customerId);
            st1.setInt(3, orderId);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Database Error", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }
}
