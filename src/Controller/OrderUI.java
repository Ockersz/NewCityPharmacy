package Controller;

import View.CustomerDashboard;
import View.CustomerViewOrderDetails;
import View.PharmacistDashboard;
import View.PharmacistViewOrders;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class OrderUI {
    
    private JLabel orderId, orderAmount, date, status;
    private JButton view;    
    
    public void createEntry(Container container, int x, int y, int orderId, Date date, String status, int amount) {
        
        String dateStr = null;
        SimpleDateFormat simple = new SimpleDateFormat("dd-MM-yyyy");
        dateStr = simple.format(date);
        
        this.orderId = new JLabel();
        this.orderId.setBounds(x + 10, y, 100, 40);
        this.orderId.setName("lbl_order_id_" + Integer.toString(orderId));
        this.orderId.setText(Integer.toString(orderId));
        this.orderId.setForeground(new Color(0, 0, 0));
        this.orderId.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        this.orderId.setHorizontalAlignment(SwingConstants.CENTER);
        container.add(this.orderId);
        
        this.date = new JLabel();
        this.date.setBounds(x + 430, y, 150, 40);
        this.date.setName("date" + dateStr);
        this.date.setText(dateStr);
        this.date.setForeground(new Color(0, 0, 0));
        this.date.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        this.date.setHorizontalAlignment(SwingConstants.CENTER);
        container.add(this.date);
        
        this.status = new JLabel();
        this.status.setBounds(x + 600, y, 150, 40);
        this.status.setName("status_" + status);
        this.status.setText(status);
        this.status.setForeground(new Color(0, 0, 0));
        this.status.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        this.status.setHorizontalAlignment(SwingConstants.CENTER);
        container.add(this.status);
        
        this.orderAmount = new JLabel();
        this.orderAmount.setBounds(x + 780, y, 150, 40);
        this.orderAmount.setName("orderAmount_" + Integer.toString(amount));
        this.orderAmount.setText(Integer.toString(amount));
        this.orderAmount.setForeground(new Color(0, 0, 0));
        this.orderAmount.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        this.orderAmount.setHorizontalAlignment(SwingConstants.CENTER);
        container.add(this.orderAmount);
        
        view = new JButton();
        view.setBounds(x + 990, y, 40, 40);
        this.view.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Images/view.png")));
        view.setName(Integer.toString(orderId));
        view.setBackground(new Color(63, 196, 243));        
        this.view.addActionListener((ActionEvent e) -> {
            btn_viewClicked();
        });
        container.add(view);
    }
    
    public void btn_viewClicked() {
        CustomerViewOrderDetails obj = new CustomerViewOrderDetails(Integer.parseInt(orderId.getText()));
        CustomerDashboard.SendLoader(obj);
    }
    
        public void createEntry(Container container, int x, int y, int orderId, Date date, String status, int amount ,String phar_id) {
        
        String dateStr = null;
        SimpleDateFormat simple = new SimpleDateFormat("dd-MM-yyyy");
        dateStr = simple.format(date);
        
        this.orderId = new JLabel();
        this.orderId.setBounds(x + 10, y, 100, 40);
        this.orderId.setName("lbl_order_id_" + Integer.toString(orderId));
        this.orderId.setText(Integer.toString(orderId));
        this.orderId.setForeground(new Color(0, 0, 0));
        this.orderId.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        this.orderId.setHorizontalAlignment(SwingConstants.CENTER);
        container.add(this.orderId);
        
        this.date = new JLabel();
        this.date.setBounds(x + 430, y, 150, 40);
        this.date.setName("date" + dateStr);
        this.date.setText(dateStr);
        this.date.setForeground(new Color(0, 0, 0));
        this.date.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        this.date.setHorizontalAlignment(SwingConstants.CENTER);
        container.add(this.date);
        
        this.status = new JLabel();
        this.status.setBounds(x + 600, y, 150, 40);
        this.status.setName("status_" + status);
        this.status.setText(status);
        this.status.setForeground(new Color(0, 0, 0));
        this.status.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        this.status.setHorizontalAlignment(SwingConstants.CENTER);
        container.add(this.status);
        
        this.orderAmount = new JLabel();
        this.orderAmount.setBounds(x + 780, y, 150, 40);
        this.orderAmount.setName("orderAmount_" + Integer.toString(amount));
        this.orderAmount.setText(Integer.toString(amount));
        this.orderAmount.setForeground(new Color(0, 0, 0));
        this.orderAmount.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        this.orderAmount.setHorizontalAlignment(SwingConstants.CENTER);
        container.add(this.orderAmount);
        
        view = new JButton();
        view.setBounds(x + 990, y, 40, 40);
        this.view.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Images/view.png")));
        view.setName(Integer.toString(orderId));
        view.setBackground(new Color(63, 196, 243));        
        this.view.addActionListener((ActionEvent e) -> {
            btn_viewOrderClicked();
        });
        container.add(view);
    }
    
        public void btn_viewOrderClicked(){
            
            PharmacistViewOrders obj = new PharmacistViewOrders(Integer.parseInt(orderId.getText()));
            PharmacistDashboard.sendLoader(obj);
            
        }
}
