package View;

import Controller.PrescriptionController;
import java.awt.Image;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicInternalFrameUI;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
/**
 *
 * @author Shahe
 */
public class PharmacistPrescriptionDetailedView extends javax.swing.JInternalFrame {

    public static int PrescriptionId;

    /**
     * Creates new form Prescription_Details1
     */
    public PharmacistPrescriptionDetailedView() {
        initComponents();

        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        BasicInternalFrameUI bi = (BasicInternalFrameUI) this.getUI();
        bi.setNorthPane(null);
    }

    public PharmacistPrescriptionDetailedView(int prescriptionId) {
        initComponents();

        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        BasicInternalFrameUI bi = (BasicInternalFrameUI) this.getUI();
        bi.setNorthPane(null);

        PrescriptionController prescription = new PrescriptionController();
        List<ImageIcon> images = prescription.getPrescriptionImages(prescriptionId);

        switch (images.size()) {
            case 3:
                pb_1.setIcon(makeImage(images.get(0), pb_1));
                pb_2.setIcon(makeImage(images.get(1), pb_2));
                pb_3.setIcon(makeImage(images.get(2), pb_3));
                break;
            case 2:
                pb_1.setIcon(makeImage(images.get(0), pb_1));
                pb_2.setIcon(makeImage(images.get(1), pb_2));
                break;
            case 1:
                pb_1.setIcon(makeImage(images.get(0), pb_1));
                break;
            default:
                break;
        }
        String strDate;
        SimpleDateFormat simple = new SimpleDateFormat("dd-MM-yyyy");
        PrescriptionController obj = new PrescriptionController();
        strDate = simple.format(obj.getPresDate(prescriptionId));
        lbl_prescriptionId.setText(Integer.toString(prescriptionId));
        lbl_issueDate.setText(strDate);
        lbl_customerName.setText(Integer.toString(obj.getCusName(prescriptionId)));
        String status = obj.getPrescriptionStatus(prescriptionId);
        if(status.equals("rejected") || status.equals("issued")){
            btn_createQuotation.hide();
        }
        
        this.PrescriptionId = prescriptionId;

    }

    public ImageIcon makeImage(ImageIcon icon, JLabel label) {
        Image img = icon.getImage();
        Image newimg = img.getScaledInstance(277, 277, java.awt.Image.SCALE_SMOOTH);
        ImageIcon test = new ImageIcon(newimg);
        return test;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btn_back = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        btn_createQuotation = new javax.swing.JButton();
        pb_2 = new javax.swing.JLabel();
        pb_3 = new javax.swing.JLabel();
        pb_1 = new javax.swing.JLabel();
        lbl_prescriptionId = new javax.swing.JLabel();
        lbl_customerName = new javax.swing.JLabel();
        lbl_issueDate = new javax.swing.JLabel();
        btn_reject = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel1.setText("Prescription Details");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel2.setText("Prescription ID             :");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel3.setText("Issued Date                  :");

        btn_back.setBackground(new java.awt.Color(63, 196, 243));
        btn_back.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        btn_back.setText("Back");
        btn_back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_backActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel4.setText("Customer Telephone        :");

        btn_createQuotation.setBackground(new java.awt.Color(63, 196, 243));
        btn_createQuotation.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        btn_createQuotation.setText("Create Quotataion");
        btn_createQuotation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_createQuotationActionPerformed(evt);
            }
        });

        pb_2.setBackground(new java.awt.Color(255, 255, 255));
        pb_2.setMinimumSize(new java.awt.Dimension(277, 277));
        pb_2.setOpaque(true);
        pb_2.setPreferredSize(new java.awt.Dimension(277, 277));

        pb_3.setBackground(new java.awt.Color(255, 255, 255));
        pb_3.setMinimumSize(new java.awt.Dimension(277, 277));
        pb_3.setOpaque(true);
        pb_3.setPreferredSize(new java.awt.Dimension(277, 277));

        pb_1.setBackground(new java.awt.Color(255, 255, 255));
        pb_1.setToolTipText("");
        pb_1.setMinimumSize(new java.awt.Dimension(277, 277));
        pb_1.setOpaque(true);
        pb_1.setPreferredSize(new java.awt.Dimension(277, 277));

        lbl_prescriptionId.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        lbl_prescriptionId.setText("Prescription ID");

        lbl_customerName.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        lbl_customerName.setText("Customer tp");

        lbl_issueDate.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        lbl_issueDate.setText("Issue Date");

        btn_reject.setBackground(new java.awt.Color(63, 196, 243));
        btn_reject.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        btn_reject.setText("Reject");
        btn_reject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_rejectActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_prescriptionId)
                            .addComponent(lbl_issueDate))
                        .addGap(155, 155, 155)
                        .addComponent(jLabel4)
                        .addGap(28, 28, 28)
                        .addComponent(lbl_customerName, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btn_reject))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(pb_1, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 78, Short.MAX_VALUE)
                                .addComponent(pb_2, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(41, 41, 41)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(pb_3, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(266, 266, 266))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(btn_createQuotation)
                                .addGap(40, 40, 40)
                                .addComponent(btn_back)
                                .addGap(225, 225, 225))))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1)
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(lbl_customerName))
                        .addGap(170, 170, 170))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(lbl_prescriptionId))
                        .addGap(38, 38, 38)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(lbl_issueDate))
                        .addGap(105, 105, 105)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pb_3, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pb_2, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pb_1, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(56, 56, 56)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_createQuotation)
                    .addComponent(btn_back)
                    .addComponent(btn_reject))
                .addGap(257, 257, 257))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_backActionPerformed
        PharmacistPrescriptions obj = new PharmacistPrescriptions();
        PharmacistDashboard.sendLoader(obj);
    }//GEN-LAST:event_btn_backActionPerformed

    private void btn_createQuotationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_createQuotationActionPerformed
        AddProductToQuotation obj = new AddProductToQuotation();
        PharmacistDashboard.sendLoader(obj);
    }//GEN-LAST:event_btn_createQuotationActionPerformed

    private void btn_rejectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_rejectActionPerformed
        PrescriptionController control = new PrescriptionController();
        if (control.rejectPrescription(PrescriptionId)) {
            JOptionPane.showMessageDialog(null, "This prescription has been rejected", "Success", JOptionPane.INFORMATION_MESSAGE);

            PharmacistPrescriptions obj = new PharmacistPrescriptions();
            PharmacistDashboard.sendLoader(obj);
        } else {
            JOptionPane.showMessageDialog(null, "This prescription could not rejected", "Error", JOptionPane.ERROR_MESSAGE);
            PharmacistPrescriptions obj = new PharmacistPrescriptions();
            PharmacistDashboard.sendLoader(obj);
        }
    }//GEN-LAST:event_btn_rejectActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_back;
    private javax.swing.JButton btn_createQuotation;
    private javax.swing.JButton btn_reject;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbl_customerName;
    private javax.swing.JLabel lbl_issueDate;
    private javax.swing.JLabel lbl_prescriptionId;
    private javax.swing.JLabel pb_1;
    private javax.swing.JLabel pb_2;
    private javax.swing.JLabel pb_3;
    // End of variables declaration//GEN-END:variables
}
