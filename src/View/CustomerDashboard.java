/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import java.awt.Component;
import javax.swing.JInternalFrame;

/**
 *
 * @author Shahe
 */
public class CustomerDashboard extends javax.swing.JFrame {

    public static int customerId =0;
    /**
     * Creates new form CustomerHome
     *
     */
    
    public CustomerDashboard() {
        initComponents();
        
        FrameLoader.removeAll();
        CustomerHomePage obj = new CustomerHomePage();
        FrameLoader.add(obj).setVisible(true);
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
        lbl_homeImage = new javax.swing.JLabel();
        nav_panel = new javax.swing.JPanel();
        btn_actInformation = new javax.swing.JButton();
        btn_prescription = new javax.swing.JButton();
        btn_orders = new javax.swing.JButton();
        btn_logOut = new javax.swing.JButton();
        FrameLoader = new javax.swing.JDesktopPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Customer Home Page");
        setBounds(new java.awt.Rectangle(0, 0, 1360, 900));
        setPreferredSize(new java.awt.Dimension(1440, 920));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        lbl_homeImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Images/Home.png"))); // NOI18N

        nav_panel.setBackground(new java.awt.Color(159, 225, 249));
        nav_panel.setPreferredSize(new java.awt.Dimension(300, 600));

        btn_actInformation.setBackground(new java.awt.Color(63, 196, 243));
        btn_actInformation.setFont(new java.awt.Font("Times New Roman", 1, 28)); // NOI18N
        btn_actInformation.setText("Account Information");
        btn_actInformation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_actInformationActionPerformed(evt);
            }
        });

        btn_prescription.setBackground(new java.awt.Color(63, 196, 243));
        btn_prescription.setFont(new java.awt.Font("Times New Roman", 1, 28)); // NOI18N
        btn_prescription.setText("My Prescription");
        btn_prescription.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_prescriptionActionPerformed(evt);
            }
        });

        btn_orders.setBackground(new java.awt.Color(63, 196, 243));
        btn_orders.setFont(new java.awt.Font("Times New Roman", 1, 28)); // NOI18N
        btn_orders.setText("My Orders");
        btn_orders.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ordersActionPerformed(evt);
            }
        });

        btn_logOut.setBackground(new java.awt.Color(63, 196, 243));
        btn_logOut.setFont(new java.awt.Font("Times New Roman", 1, 28)); // NOI18N
        btn_logOut.setText("Log Out");
        btn_logOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_logOutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout nav_panelLayout = new javax.swing.GroupLayout(nav_panel);
        nav_panel.setLayout(nav_panelLayout);
        nav_panelLayout.setHorizontalGroup(
            nav_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(nav_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(nav_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_actInformation, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_orders, javax.swing.GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE)
                    .addComponent(btn_prescription, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE)
                    .addComponent(btn_logOut, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        nav_panelLayout.setVerticalGroup(
            nav_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(nav_panelLayout.createSequentialGroup()
                .addGap(199, 199, 199)
                .addComponent(btn_prescription, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_orders, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_actInformation, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 155, Short.MAX_VALUE)
                .addComponent(btn_logOut, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
        );

        javax.swing.GroupLayout FrameLoaderLayout = new javax.swing.GroupLayout(FrameLoader);
        FrameLoader.setLayout(FrameLoaderLayout);
        FrameLoaderLayout.setHorizontalGroup(
            FrameLoaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        FrameLoaderLayout.setVerticalGroup(
            FrameLoaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_homeImage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(nav_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(FrameLoader))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(lbl_homeImage)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nav_panel, javax.swing.GroupLayout.DEFAULT_SIZE, 709, Short.MAX_VALUE)
                    .addComponent(FrameLoader)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_actInformationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_actInformationActionPerformed
        FrameLoader.removeAll();
        CustomerAccountInformation obj = new CustomerAccountInformation();
        FrameLoader.add(obj).setVisible(true);
    }//GEN-LAST:event_btn_actInformationActionPerformed

    private void btn_prescriptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_prescriptionActionPerformed
        FrameLoader.removeAll();
        CustomerMyPrecription obj = new CustomerMyPrecription();
        FrameLoader.add(obj).setVisible(true);
    }//GEN-LAST:event_btn_prescriptionActionPerformed

    private void btn_ordersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ordersActionPerformed
        FrameLoader.removeAll();
        CustomerMyOrders obj = new CustomerMyOrders();
        FrameLoader.add(obj).setVisible(true);

    }//GEN-LAST:event_btn_ordersActionPerformed

    private void btn_logOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_logOutActionPerformed
        UserLogin obj = new UserLogin();
        obj.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_logOutActionPerformed

    public static void SendLoader(Component test){
        FrameLoader.removeAll();
        FrameLoader.add(test).setVisible(true);
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CustomerDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CustomerDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CustomerDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CustomerDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CustomerDashboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private static javax.swing.JDesktopPane FrameLoader;
    private javax.swing.JButton btn_actInformation;
    private javax.swing.JButton btn_logOut;
    private javax.swing.JButton btn_orders;
    private javax.swing.JButton btn_prescription;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbl_homeImage;
    private javax.swing.JPanel nav_panel;
    // End of variables declaration//GEN-END:variables
}
