package Model;

import java.awt.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.*;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Prescription {

    private int prescriptionId;
    private String status;
    private Date date;

    private Image image;

    public Prescription() {

    }

    public Prescription(int prescriptionId, String status, Date date) {
        this.prescriptionId = prescriptionId;
        this.status = status;
        this.date = date;
    }

    //Setters
    public void setPrescriptionId(int prescriptionId) {
        this.prescriptionId = prescriptionId;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    //Getters
    public int getPrescriptionId() {
        return prescriptionId;
    }

    public String getStatus() {
        return status;
    }

    public Date getDate() {
        return date;
    }

    public Image getImage() {
        return image;
    }

    public boolean uploadPrescription(int customerId, List<Path> imageFile) {
        try (Connection con = DatabaseConnection.getConnection(); PreparedStatement st = con.prepareStatement("INSERT INTO prescription (cid) VALUES (?)", Statement.RETURN_GENERATED_KEYS); PreparedStatement st2 = con.prepareStatement("INSERT INTO prescription_images VALUES (?,?)")) {
            con.setAutoCommit(false);

            st.setInt(1, customerId);
            int i = st.executeUpdate();

            if (i == 1) {

                ResultSet rst = st.getGeneratedKeys();
                if (rst.next()) {
                    setPrescriptionId(rst.getInt(1));
                }

                for (Path path : imageFile) {

                    if (path != null && Files.exists(path)) {
                        byte[] fileContent = Files.readAllBytes(path);
                        st2.setInt(1, getPrescriptionId());
                        st2.setBytes(2, fileContent);
                        st2.executeUpdate();
                        st2.clearParameters();
                    } else {

                    }

                }

                con.commit();
                return true;
            }
            con.rollback();
            return false;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Failed to upload prescription. ", "Error" , JOptionPane.ERROR_MESSAGE);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Failed to read file. " + e.getMessage(), "Error" , JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }

    public List<Prescription> getPrescriptionDetails(int customerId) {

        List<Prescription> prescriptions = new ArrayList<>();
        String sql = "SELECT `prescription_id`, `status`, `date` FROM `prescription` WHERE cid = ?";

        try (Connection con = DatabaseConnection.getConnection(); PreparedStatement st = con.prepareStatement(sql)) {

            st.setInt(1, customerId);
            st.setFetchSize(50);
            try (ResultSet rst = st.executeQuery()) {
                while (rst.next()) {
                    int id = rst.getInt("prescription_id");
                    String status = rst.getString("status");
                    Date date = rst.getDate("date");
                    prescriptions.add(new Prescription(id, status, date));
                }
            }
            return prescriptions;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error while fetching prescription details: " + ex.getMessage(), "Error" , JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }

    public List<Prescription> getPrescriptionDetails() {

        List<Prescription> prescriptions = new ArrayList<>();
        String sql = "SELECT `prescription_id`, `status`, `date` FROM `prescription`";

        try (Connection con = DatabaseConnection.getConnection(); PreparedStatement st = con.prepareStatement(sql)) {

            st.setFetchSize(50);
            try (ResultSet rst = st.executeQuery()) {
                while (rst.next()) {
                    int id = rst.getInt("prescription_id");
                    String status = rst.getString("status");
                    Date date = rst.getDate("date");
                    prescriptions.add(new Prescription(id, status, date));
                }
            }
            return prescriptions;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error while fetching prescription details: " + ex.getMessage(), "Error" , JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }

    public List<Prescription> getPendingPrescriptionDetails() {

        List<Prescription> prescriptions = new ArrayList<>();
        String sql = "SELECT `prescription_id`, `status`, `date` FROM `prescription` WHERE status = 'pending'";

        try (Connection con = DatabaseConnection.getConnection(); PreparedStatement st = con.prepareStatement(sql)) {

            st.setFetchSize(50);
            try (ResultSet rst = st.executeQuery()) {
                while (rst.next()) {
                    int id = rst.getInt("prescription_id");
                    String status = rst.getString("status");
                    Date date = rst.getDate("date");
                    prescriptions.add(new Prescription(id, status, date));
                }
            }
            return prescriptions;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error while fetching prescription details: " + ex.getMessage(), "Error" , JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }

    public List<Prescription> getRejectedPrescriptionDetails() {

        List<Prescription> prescriptions = new ArrayList<>();
        String sql = "SELECT `prescription_id`, `status`, `date` FROM `prescription` WHERE status = 'rejected'";

        try (Connection con = DatabaseConnection.getConnection(); PreparedStatement st = con.prepareStatement(sql)) {

            st.setFetchSize(50);
            try (ResultSet rst = st.executeQuery()) {
                while (rst.next()) {
                    int id = rst.getInt("prescription_id");
                    String status = rst.getString("status");
                    Date date = rst.getDate("date");
                    prescriptions.add(new Prescription(id, status, date));
                }
            }
            return prescriptions;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error while fetching prescription details: " + ex.getMessage(), "Error" , JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }

    public List<ImageIcon> getPrescriptionImages(int prescriptionId) {

        List<ImageIcon> imageIconList = new ArrayList<>();
        String sql = "Select image from prescription_images where pre_id = ? ";
        try (Connection con = DatabaseConnection.getConnection(); PreparedStatement st = con.prepareStatement(sql)) {

            st.setInt(1, prescriptionId);
            ResultSet rst = st.executeQuery();
            while (rst.next()) {
                Blob imageBlob = rst.getBlob(1);
                InputStream inputStream = imageBlob.getBinaryStream();
                byte[] imageBytes = new byte[(int) imageBlob.length()];
                Image image = Toolkit.getDefaultToolkit().createImage(imageBytes);
                inputStream.read(imageBytes);
                imageIconList.add(new ImageIcon(image));
            }
            return imageIconList;

        } catch (SQLException | IOException ex) {
            JOptionPane.showMessageDialog(null, "Error while fetching prescription details: " + ex.getMessage(), "Error" , JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }

    public Date getPresDate(int prescriptionId) {

        Date date = null;
        String sql = "SELECT `date` FROM `prescription` WHERE prescription_id = ? ";
        try (Connection con = DatabaseConnection.getConnection(); PreparedStatement st1 = con.prepareStatement(sql)) {
            st1.setInt(1, prescriptionId);
            try (ResultSet rst = st1.executeQuery()) {
                while (rst.next()) {
                    date = rst.getDate(1);
                }
                return date;
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error while fetching prescription details: " + ex.getMessage(), "Error" , JOptionPane.ERROR_MESSAGE);
        }
        return date;
    }

    public int getCusName(int prescriptionId) {

        int tp = 0;
        String sql = "Select telephone from customer INNER JOIN prescription ON customer.customer_id = prescription.cid where prescription_id = ?";
        try (Connection con = DatabaseConnection.getConnection(); PreparedStatement st1 = con.prepareStatement(sql)) {

            st1.setInt(1, prescriptionId);
            try (ResultSet rst = st1.executeQuery()) {
                while (rst.next()) {
                    tp = rst.getInt(1);
                }
                return tp;
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error while fetching customer details: " + ex.getMessage(), "Error" , JOptionPane.ERROR_MESSAGE);
        }
        return 0;
    }

    public int getCustomerId(int prescriptionId) {
        int cid = 0;
        String sql = "Select cid from prescription  where prescription_id = ?";
        try (Connection con = DatabaseConnection.getConnection(); PreparedStatement st1 = con.prepareStatement(sql)) {

            st1.setInt(1, prescriptionId);
            try (ResultSet rst = st1.executeQuery()) {
                while (rst.next()) {
                    cid = rst.getInt(1);
                }
                return cid;
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error while fetching prescription details: " + ex.getMessage(), "Error" , JOptionPane.ERROR_MESSAGE);
        }
        return 0;
    }

    public boolean confirmPrescription(int prescriptionId) {
        String sql = "UPDATE prescription SET status = 'issued' where prescription_id = ? ";
        try (Connection con = DatabaseConnection.getConnection(); PreparedStatement st1 = con.prepareStatement(sql)) {

            st1.setInt(1, prescriptionId);

            return st1.executeUpdate() == 1;

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error while fetching prescription details: " + ex.getMessage(), "Error" , JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }

    public boolean rejectPrescription(int prescriptionId) {
        String sql = "UPDATE prescription SET status = 'rejected' where prescription_id = ? ";
        try (Connection con = DatabaseConnection.getConnection(); PreparedStatement st1 = con.prepareStatement(sql)) {

            st1.setInt(1, prescriptionId);

            return st1.executeUpdate() == 1;

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error while fetching prescription details: " + ex.getMessage(), "Error" , JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }
    
    public String getPrescriptionStatus(int prescriptionId){
        String status = null;
        String sql = "Select status from prescription  where prescription_id = ?";
        try (Connection con = DatabaseConnection.getConnection(); PreparedStatement st1 = con.prepareStatement(sql)) {

            st1.setInt(1, prescriptionId);
            try (ResultSet rst = st1.executeQuery()) {
                while (rst.next()) {
                    status = rst.getString(1);
                }
                return status;
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error while fetching prescription details: " + ex.getMessage(), "Error" , JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }

}
