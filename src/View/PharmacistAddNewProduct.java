/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package View;

import Controller.ProductController;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicInternalFrameUI;

/**
 *
 * @author Nawoda Gamage
 */
public class PharmacistAddNewProduct extends javax.swing.JInternalFrame {

    /**
     * Creates new form Product
     */
    public PharmacistAddNewProduct() {
        initComponents();
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        BasicInternalFrameUI bi = (BasicInternalFrameUI) this.getUI();
        bi.setNorthPane(null);

        ProductController obj = new ProductController();
        lbl_productId.setText(obj.getNewProductId());

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btn_save = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btn_back = new javax.swing.JButton();
        txt_category = new javax.swing.JComboBox<>();
        txt_genericName = new javax.swing.JTextField();
        txt_brandName = new javax.swing.JTextField();
        txt_company = new javax.swing.JTextField();
        txt_dosage = new javax.swing.JTextField();
        lbl_productId = new javax.swing.JLabel();
        txt_expiryDate = new com.toedter.calendar.JDateChooser();
        txt_quantity = new javax.swing.JTextField();
        txt_unitPrice = new javax.swing.JTextField();
        txt_errorMessage = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(null);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel1.setText("Add New Product");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jLabel8.setText("Category          :");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jLabel7.setText("Dosage            :");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jLabel9.setText("Expire Date      :");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jLabel6.setText("Company        :");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jLabel10.setText("Quantity           :");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jLabel4.setText("Generic Name :");

        btn_save.setBackground(new java.awt.Color(63, 196, 243));
        btn_save.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        btn_save.setText("Save");
        btn_save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_saveActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jLabel11.setText("Unit Price(LKR) :");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jLabel5.setText("Brand Name    :");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jLabel2.setText("Product ID      :");

        btn_back.setBackground(new java.awt.Color(63, 196, 243));
        btn_back.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        btn_back.setText("Back");
        btn_back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_backActionPerformed(evt);
            }
        });

        txt_category.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        txt_category.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cardiovascular", "Respiratory", "Urinary", "Analgesics", "CentralNervous" }));

        txt_genericName.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        txt_genericName.setPreferredSize(new java.awt.Dimension(64, 39));

        txt_brandName.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        txt_brandName.setPreferredSize(new java.awt.Dimension(64, 39));

        txt_company.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        txt_company.setPreferredSize(new java.awt.Dimension(64, 39));

        txt_dosage.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        txt_dosage.setPreferredSize(new java.awt.Dimension(64, 39));

        lbl_productId.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        lbl_productId.setText("Id");

        txt_expiryDate.setDateFormatString("dd-MM-yyyy");
        txt_expiryDate.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N

        txt_quantity.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        txt_quantity.setPreferredSize(new java.awt.Dimension(64, 39));

        txt_unitPrice.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        txt_unitPrice.setPreferredSize(new java.awt.Dimension(64, 39));

        txt_errorMessage.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_errorMessage.setForeground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_save, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(btn_back, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(131, 131, 131))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_errorMessage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txt_genericName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel4)
                                .addComponent(jLabel6)
                                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txt_brandName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txt_company, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txt_dosage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addGap(21, 21, 21)
                                    .addComponent(lbl_productId, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 374, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_category, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_expiryDate, javax.swing.GroupLayout.DEFAULT_SIZE, 275, Short.MAX_VALUE)
                            .addComponent(txt_quantity, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_unitPrice, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(220, 220, 220))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(lbl_productId))
                .addGap(18, 18, 18)
                .addComponent(txt_errorMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_category, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel9)
                        .addGap(18, 18, 18)
                        .addComponent(txt_expiryDate, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_genericName, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel5)
                        .addGap(12, 12, 12)
                        .addComponent(txt_brandName, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel10))
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txt_quantity, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txt_company, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel11))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txt_dosage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_unitPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_save)
                    .addComponent(btn_back))
                .addGap(77, 77, 77))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_backActionPerformed
        PharmacistProductDetails obj = new PharmacistProductDetails();
        PharmacistDashboard.sendLoader(obj);
    }//GEN-LAST:event_btn_backActionPerformed

    private void btn_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_saveActionPerformed
        if (txt_genericName.getText().isEmpty()) {
            txt_errorMessage.setText("*Generic Name cannot be blank");
        } else if (!txt_genericName.getText().matches("^[a-zA-Z]+$")) {
            txt_errorMessage.setText("*Invalid Generic Name");
        } else if (!txt_genericName.getText().matches(".*\\S+.*")) {
            txt_errorMessage.setText("Generic Name cannot be space");
        } else if (txt_brandName.getText().isEmpty()) {
            txt_errorMessage.setText("*Brand Name cannot be blank");
        } else if (!txt_brandName.getText().matches("^[a-zA-Z]+$")) {
            txt_errorMessage.setText("*Invalid Brand Name");
        } else if (!txt_brandName.getText().matches(".*\\S+.*")) {
            txt_errorMessage.setText("Brand Name cannot be space");
        } else if (txt_company.getText().isEmpty()) {
            txt_errorMessage.setText("*Company Name cannot be blank");
        } else if (!txt_genericName.getText().matches(".*\\S+.*")) {
            txt_errorMessage.setText("Company Name cannot be space");
        } else if (txt_dosage.getText().isEmpty()) {
            txt_errorMessage.setText("*Dosage cannot be blank");
        } else if (!txt_dosage.getText().matches(".*\\S+.*")) {
            txt_errorMessage.setText("Dosage cannot be space");
        } else if (txt_quantity.getText().isEmpty()) {
            txt_errorMessage.setText("*Quantity cannot be blank");
        } else if (!txt_genericName.getText().matches(".*\\S+.*")) {
            txt_errorMessage.setText("Quantity cannot be space");
        } else if (txt_quantity.getText().matches("^[a-zA-Z]+$")) {
            txt_errorMessage.setText("*Invalid quantity");
        } else if (txt_unitPrice.getText().isEmpty()) {
            txt_errorMessage.setText("*Unit price cannot be blank");
        } else if (!txt_unitPrice.getText().matches("\\d+")) {
            txt_errorMessage.setText("*Invalid unit price");
        } else if (!txt_genericName.getText().matches(".*\\S+.*")) {
            txt_errorMessage.setText("Unit price cannot be space");
         } else {
            txt_errorMessage.setText("");

            ProductController product = new ProductController();
            if (product.addProduct(lbl_productId.getText(), txt_genericName.getText(), txt_brandName.getText(), txt_company.getText(), txt_dosage.getText(), txt_category.getSelectedItem().toString(), txt_expiryDate.getDate(), Integer.parseInt(txt_quantity.getText()), Integer.parseInt(txt_unitPrice.getText()))) {
                JOptionPane.showMessageDialog(null, "Product added successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
                PharmacistProductDetails obj = new PharmacistProductDetails();
                PharmacistDashboard.sendLoader(obj);
            } else {
                JOptionPane.showMessageDialog(null, "Product could not be added. Please try again", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

    }//GEN-LAST:event_btn_saveActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_back;
    private javax.swing.JButton btn_save;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbl_productId;
    private javax.swing.JTextField txt_brandName;
    private javax.swing.JComboBox<String> txt_category;
    private javax.swing.JTextField txt_company;
    private javax.swing.JTextField txt_dosage;
    private javax.swing.JLabel txt_errorMessage;
    private com.toedter.calendar.JDateChooser txt_expiryDate;
    private javax.swing.JTextField txt_genericName;
    private javax.swing.JTextField txt_quantity;
    private javax.swing.JTextField txt_unitPrice;
    // End of variables declaration//GEN-END:variables
}
