package Model;

import java.util.Date;

public class Invoice {

    protected int invoiceId;
    protected float invoiceAmount;
    protected String paymentMethod;
    protected Date date;

    //Setters
    public void setInvoiceId(int invoiceId) {
        this.invoiceId = invoiceId;
    }

    public void setInvoiceAmount(float invoiceAmount) {
        this.invoiceAmount = invoiceAmount;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    //Getters
    public int getInvoiceId() {
        return invoiceId;
    }

    public float getInvoiceAmount() {
        return invoiceAmount;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public Date getDate() {
        return date;
    }

    
}
