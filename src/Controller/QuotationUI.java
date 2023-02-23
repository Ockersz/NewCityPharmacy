package Controller;

import View.CustomerDashboard;
import View.CustomerViewOrderDetails;
import View.CustomerViewQuotationDetails;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class QuotationUI {
    
     private JLabel generic, dosage, quantity, amount,quotationId,date,status,finalAmount;
     private JButton view; 
     
     
     public void createEntry(Container container, int x, int y, String generic, String dosage, int quantity, int amount) {

        this.generic = new JLabel();
        this.generic.setBounds(x+40, y, 170, 40);
        this.generic.setName("lbl_generic_" + generic);
        this.generic.setText(generic);
        this.generic.setForeground(new Color(0, 0, 0));
        this.generic.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        this.generic.setHorizontalAlignment(SwingConstants.CENTER);
        container.add(this.generic);

        this.dosage = new JLabel();
        this.dosage.setBounds(x + 450, y, 150, 40);
        this.dosage.setName("dosage_" + dosage);
        this.dosage.setText(dosage);
        this.dosage.setForeground(new Color(0, 0, 0));
        this.dosage.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        this.dosage.setHorizontalAlignment(SwingConstants.CENTER);
        container.add(this.dosage);
        
        this.quantity = new JLabel();
        this.quantity.setBounds(x + 700, y, 150, 40);
        this.quantity.setName("status_" + Integer.toString(quantity));
        this.quantity.setText(Integer.toString(quantity));
        this.quantity.setForeground(new Color(0, 0, 0));
        this.quantity.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        this.quantity.setHorizontalAlignment(SwingConstants.CENTER);
        container.add(this.quantity);
        
        this.amount = new JLabel();
        this.amount.setBounds(x + 900, y, 150, 40);
        this.amount.setName("status_" + Integer.toString(amount));
        this.amount.setText(Integer.toString(amount));
        this.amount.setForeground(new Color(0, 0, 0));
        this.amount.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        this.amount.setHorizontalAlignment(SwingConstants.CENTER);
        container.add(this.amount);
     }
     
      public void createCustomerQuotationUI(Container container, int x, int y, int quotationId, Date date, String status,int finalAmount){
        
         SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        String strDate = formatter.format(date);

        this.quotationId = new JLabel();
        this.quotationId.setBounds(x+50, y, 40, 40);
        this.quotationId.setName("lbl_quotationId_" + Integer.toString(quotationId));
        this.quotationId.setText(Integer.toString(quotationId));
        this.quotationId.setForeground(new Color(0, 0, 0));
        this.quotationId.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        this.quotationId.setHorizontalAlignment(SwingConstants.CENTER);
        container.add(this.quotationId);

        this.status = new JLabel();
        this.status.setBounds(x + 310, y, 150, 40);
        this.status.setName("status_" + Integer.toString(quotationId));
        this.status.setText(status);
        this.status.setForeground(new Color(0, 0, 0));
        this.status.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        this.status.setHorizontalAlignment(SwingConstants.CENTER);
        container.add(this.status);
        
        this.date = new JLabel();
        this.date.setBounds(x + 512, y, 150, 40);
        this.date.setName("date_" + Integer.toString(quotationId));
        this.date.setText(strDate);
        this.date.setForeground(new Color(0, 0, 0));
        this.date.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        this.date.setHorizontalAlignment(SwingConstants.CENTER);
        container.add(this.date);
        
        this.finalAmount = new JLabel();
        this.finalAmount.setBounds(x + 725, y, 150, 40);
        this.finalAmount.setName("finalAmount_" + Integer.toString(quotationId));
        this.finalAmount.setText(Integer.toString(finalAmount));
        this.finalAmount.setForeground(new Color(0, 0, 0));
        this.finalAmount.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        this.finalAmount.setHorizontalAlignment(SwingConstants.CENTER);
        container.add(this.finalAmount);
        
        view = new JButton();
        view.setBounds(x+972, y, 40, 40);
        this.view.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Images/view.png")));
        view.setName(Integer.toString(quotationId));
        view.setBackground(new Color(63,196,243));        
       this.view.addActionListener((ActionEvent e) -> {
            btn_viewClicked();
        });
        container.add(view);
    }
      
      public void btn_viewClicked(){
          
          CustomerViewQuotationDetails obj = new CustomerViewQuotationDetails(Integer.parseInt(quotationId.getText()));
          CustomerDashboard.SendLoader(obj);
          
      }
    
}
