package Controller;

import View.PharmacistDashboard;
import View.PharmacistEditProduct;
import View.PharmacistProductDetails;
import View.PharmacistViewDetailedProduct;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

public class ProductEntriesUI implements ActionListener {

    private JLabel productId, genericName, dosage, availableQuantity,status,expDate;
    private JButton view, update, delete;

    public void createProductEntry(Container container, int x, int y, String productId, String genericName, String dosage, int availableQuantity) {

        this.productId = new JLabel();
        this.productId.setBounds(x + 50, y, 70, 40);
        this.productId.setName("lbl_prodcutId_" + productId);
        this.productId.setText(productId);
        this.productId.setForeground(new Color(0, 0, 0));
        this.productId.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        this.productId.setHorizontalAlignment(SwingConstants.CENTER);
        container.add(this.productId);

        this.genericName = new JLabel();
        this.genericName.setBounds(x + 220, y, 150, 40);
        this.genericName.setName("lbl_genericName_" + genericName);
        this.genericName.setText(genericName);
        this.genericName.setForeground(new Color(0, 0, 0));
        this.genericName.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        this.genericName.setHorizontalAlignment(SwingConstants.CENTER);
        container.add(this.genericName);

        this.dosage = new JLabel();
        this.dosage.setBounds(x + 410, y, 150, 40);
        this.dosage.setName("lbl_dosage_" + dosage);
        this.dosage.setText(dosage);
        this.dosage.setForeground(new Color(0, 0, 0));
        this.dosage.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        this.dosage.setHorizontalAlignment(SwingConstants.CENTER);
        container.add(this.dosage);

        this.availableQuantity = new JLabel();
        this.availableQuantity.setBounds(x + 650, y, 40, 40);
        this.availableQuantity.setName("lbl_availableQuantity_" + Integer.toString(availableQuantity));
        this.availableQuantity.setText(Integer.toString(availableQuantity));
        this.availableQuantity.setForeground(new Color(0, 0, 0));
        this.availableQuantity.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        this.availableQuantity.setHorizontalAlignment(SwingConstants.CENTER);
        container.add(this.availableQuantity);

        this.view = new JButton();
        this.view.setBounds(x + 875, y, 40, 40);
        this.view.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Images/view.png")));
        this.view.setName(productId);
        this.view.setBackground(new Color(63, 196, 243));
        this.view.addActionListener((ActionEvent e) -> {
            btn_viewClicked();
        });
        container.add(view);

        this.update = new JButton();
        this.update.setBounds(x + 925, y, 40, 40);
        this.update.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Images/edit.png")));
        this.update.setName(productId);
        this.update.setBackground(new Color(63, 196, 243));
        this.update.addActionListener((ActionEvent e) -> {
            btn_updateClicked();
        });
        container.add(update);

        this.delete = new JButton();
        this.delete.setBounds(x + 975, y, 40, 40);
        this.delete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Images/delete.png")));
        this.delete.setName(productId);
        this.delete.setBackground(new Color(63, 196, 243));
        this.delete.addActionListener((ActionEvent e) -> {
            btn_deleteClicked();
        });
        container.add(delete);

    }


    public void btn_deleteClicked() {
        ProductController product = new ProductController();
        if(product.deleteProduct(delete.getName())){
            JOptionPane.showMessageDialog(null, "Product "+delete.getName()+ " deleted successfully", "Success",JOptionPane.INFORMATION_MESSAGE);
            PharmacistProductDetails obj = new PharmacistProductDetails();
            PharmacistDashboard.sendLoader(obj);
        }
        else{
            JOptionPane.showMessageDialog(null, "Product could not be deleted","Error",JOptionPane.ERROR_MESSAGE);
        }
    }

    public void btn_updateClicked() {
        PharmacistEditProduct obj = new PharmacistEditProduct(update.getName());
        PharmacistDashboard.sendLoader(obj);
    }

    public void btn_viewClicked() {
        PharmacistViewDetailedProduct obj = new PharmacistViewDetailedProduct(view.getName());
        PharmacistDashboard.sendLoader(obj);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
    }
    
    
    public void createLowStockUI(Container container, int x, int y, String productId, String genericName, String dosage, int availableQuantity){
        
        
        
        this.productId = new JLabel();
        this.productId.setBounds(x +30, y, 70, 40);
        this.productId.setName("lbl_prodcutId_" + productId);
        this.productId.setText(productId);
        this.productId.setForeground(new Color(0, 0, 0));
        this.productId.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        this.productId.setHorizontalAlignment(SwingConstants.CENTER);
        container.add(this.productId);

        this.genericName = new JLabel();
        this.genericName.setBounds(x + 220, y, 150, 40);
        this.genericName.setName("lbl_genericName_" + genericName);
        this.genericName.setText(genericName);
        this.genericName.setForeground(new Color(0, 0, 0));
        this.genericName.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        this.genericName.setHorizontalAlignment(SwingConstants.CENTER);
        container.add(this.genericName);

        this.dosage = new JLabel();
        this.dosage.setBounds(x + 410, y, 150, 40);
        this.dosage.setName("lbl_dosage_" + dosage);
        this.dosage.setText(dosage);
        this.dosage.setForeground(new Color(0, 0, 0));
        this.dosage.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        this.dosage.setHorizontalAlignment(SwingConstants.CENTER);
        container.add(this.dosage);

        this.availableQuantity = new JLabel();
        this.availableQuantity.setBounds(x + 650, y, 150, 40);
        this.availableQuantity.setName("lbl_availableQuantity_" + Integer.toString(availableQuantity));
        this.availableQuantity.setText(Integer.toString(availableQuantity));
        this.availableQuantity.setForeground(new Color(0, 0, 0));
        this.availableQuantity.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        this.availableQuantity.setHorizontalAlignment(SwingConstants.CENTER);
        container.add(this.availableQuantity);
        
        this.status = new JLabel();
        this.status.setBounds(x + 800, y, 200, 40);
        this.status.setName("lbl_status");
        if(availableQuantity <= 5){
            this.status.setText("Critically Low");
            this.status.setBackground(Color.red);
        }
        else if(availableQuantity <= 10){
            this.status.setText("Low");
            this.status.setBackground(Color.orange);
            
        }
        else if(availableQuantity <= 20){
            this.status.setText("Low Soon");
            this.status.setBackground(Color.yellow);
        }
        this.status.setOpaque(true);
        this.status.setForeground(new Color(0, 0, 0));
        this.status.setFont(new Font("Segoe UI", Font.BOLD, 20));
        this.status.setHorizontalAlignment(SwingConstants.CENTER);
        container.add(this.status);
    }
    
    public void createExpiryUI(Container container, int x, int y, String productId, String genericName, String dosage, int availableQuantity, Date expiryDate){
        
        SimpleDateFormat simple = new SimpleDateFormat("dd-MM-yyyy");
        String strDate = simple.format(expiryDate);
        
        
        this.productId = new JLabel();
        this.productId.setBounds(x +30, y, 70, 40);
        this.productId.setName("lbl_prodcutId_" + productId);
        this.productId.setText(productId);
        this.productId.setForeground(new Color(0, 0, 0));
        this.productId.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        this.productId.setHorizontalAlignment(SwingConstants.CENTER);
        container.add(this.productId);

        this.genericName = new JLabel();
        this.genericName.setBounds(x + 180, y, 150, 40);
        this.genericName.setName("lbl_genericName_" + genericName);
        this.genericName.setText(genericName);
        this.genericName.setForeground(new Color(0, 0, 0));
        this.genericName.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        this.genericName.setHorizontalAlignment(SwingConstants.CENTER);
        container.add(this.genericName);

        this.dosage = new JLabel();
        this.dosage.setBounds(x + 360, y, 150, 40);
        this.dosage.setName("lbl_dosage_" + dosage);
        this.dosage.setText(dosage);
        this.dosage.setForeground(new Color(0, 0, 0));
        this.dosage.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        this.dosage.setHorizontalAlignment(SwingConstants.CENTER);
        container.add(this.dosage);
        
        this.availableQuantity = new JLabel();
        this.availableQuantity.setBounds(x + 570, y, 150, 40);
        this.availableQuantity.setName("lbl_availableQuantity_" + Integer.toString(availableQuantity));
        this.availableQuantity.setText(Integer.toString(availableQuantity));
        this.availableQuantity.setForeground(new Color(0, 0, 0));
        this.availableQuantity.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        this.availableQuantity.setHorizontalAlignment(SwingConstants.CENTER);
        container.add(this.availableQuantity);

        this.expDate = new JLabel();
        this.expDate.setBounds(x + 770, y, 150, 40);
        this.expDate.setName("lbl_expdate_" + strDate);
        this.expDate.setText(strDate);
        this.expDate.setForeground(new Color(0, 0, 0));
        this.expDate.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        this.expDate.setHorizontalAlignment(SwingConstants.CENTER);
        container.add(this.expDate);
        
       
    }

}
