package Controller;

import Model.Prescription;
import View.PharmacistDashboard;
import View.PharmacistPrescriptionDetailedView;
import View.PrescriptionImageViewer;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class PrescriptionEntriesUI implements ActionListener{

    private JLabel prescriptionId, date, status;
    private JButton image;

    public void createEntry(Container container, int x, int y, int prescriptionId, Date date, String status) {

        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        String strDate = formatter.format(date);

        this.prescriptionId = new JLabel();
        this.prescriptionId.setBounds(x+40, y, 40, 40);
        this.prescriptionId.setName("lbl_precriptionId_" + Integer.toString(prescriptionId));
        this.prescriptionId.setText(Integer.toString(prescriptionId));
        this.prescriptionId.setForeground(new Color(0, 0, 0));
        this.prescriptionId.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        this.prescriptionId.setHorizontalAlignment(SwingConstants.CENTER);
        container.add(this.prescriptionId);

        this.date = new JLabel();
        this.date.setBounds(x + 500, y, 150, 40);
        this.date.setName("date_" + Integer.toString(prescriptionId));
        this.date.setText(strDate);
        this.date.setForeground(new Color(0, 0, 0));
        this.date.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        this.date.setHorizontalAlignment(SwingConstants.CENTER);
        container.add(this.date);
        
        this.status = new JLabel();
        this.status.setBounds(x + 700, y, 150, 40);
        this.status.setName("status_" + Integer.toString(prescriptionId));
        this.status.setText(status);
        this.status.setForeground(new Color(0, 0, 0));
        this.status.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        this.status.setHorizontalAlignment(SwingConstants.CENTER);
        container.add(this.status);
        
        image = new JButton();
        image.setBounds(x+900, y, 120, 40);
        image.setText("Images");
        image.setName(Integer.toString(prescriptionId));
        image.setBackground(new Color(63,196,243));
        image.setForeground(Color.BLACK);
        image.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        image.addActionListener(this);
        container.add(image);
    }
    
    public void createPrescriptionUI(Container container, int x, int y, int prescriptionId, Date date, String status){
        
         SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        String strDate = formatter.format(date);

        this.prescriptionId = new JLabel();
        this.prescriptionId.setBounds(x+50, y, 40, 40);
        this.prescriptionId.setName("lbl_precriptionId_" + Integer.toString(prescriptionId));
        this.prescriptionId.setText(Integer.toString(prescriptionId));
        this.prescriptionId.setForeground(new Color(0, 0, 0));
        this.prescriptionId.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        this.prescriptionId.setHorizontalAlignment(SwingConstants.CENTER);
        container.add(this.prescriptionId);

        this.date = new JLabel();
        this.date.setBounds(x + 325, y, 150, 40);
        this.date.setName("date_" + Integer.toString(prescriptionId));
        this.date.setText(strDate);
        this.date.setForeground(new Color(0, 0, 0));
        this.date.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        this.date.setHorizontalAlignment(SwingConstants.CENTER);
        container.add(this.date);
        
        this.status = new JLabel();
        this.status.setBounds(x + 615, y, 150, 40);
        this.status.setName("status_" + Integer.toString(prescriptionId));
        this.status.setText(status);
        this.status.setForeground(new Color(0, 0, 0));
        this.status.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        this.status.setHorizontalAlignment(SwingConstants.CENTER);
        container.add(this.status);
        
        image = new JButton();
        image.setBounds(x+910, y, 40, 40);
        this.image.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Images/view.png")));
        image.setName(Integer.toString(prescriptionId));
        image.setBackground(new Color(63,196,243));        
       this.image.addActionListener((ActionEvent e) -> {
            btn_viewClicked();
        });
        container.add(image);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //do the image thing here
        PrescriptionImageViewer obj = new PrescriptionImageViewer(Integer.parseInt(image.getName()));
        obj.setVisible(true);
    }
    
    public void btn_viewClicked(){
        PharmacistPrescriptionDetailedView obj = new PharmacistPrescriptionDetailedView(Integer.parseInt(image.getName()));
        PharmacistDashboard.sendLoader(obj);
    }
    

}


