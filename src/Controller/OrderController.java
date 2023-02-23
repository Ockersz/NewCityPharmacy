package Controller;

import Model.Order;
import Model.ProductPriceDetails;
import java.util.Date;
import java.util.List;

public class OrderController {

    public boolean confirmOrder(int orderAmount, int quotationId, int customerId, List<ProductPriceDetails> productDetails) {

        Order order = new Order();
        return order.confirmOrder(orderAmount, quotationId, customerId, productDetails);
        
    }

    public List<Order> getOrders(int customerId) {
        Order order = new Order();
        return order.getOrders(customerId);
    }

    public List<ProductPriceDetails> getOrderProducts(int orderId) {
        Order order = new Order();
        return order.getOrderProducts(orderId);
    }

    public String getStatus(int orderId) {
        Order order = new Order();
        return order.getStatus(orderId);
    }

    public List<Order> getOrders() {
        Order order = new Order();
        return order.getOrders();
    }

    public Date getDate(int orderId) {
        Order order = new Order();
        return order.getDate(orderId);
    }

    public String getCustomerName(int orderId) {
        Order order = new Order();
        return order.getCustomerName(orderId);
    }

    public String getCustomerAddress(int orderId) {
        Order order = new Order();
        return order.getCustomerAddress(orderId);
    }

    public int getCustomerTelephone(int orderId) {
        Order order = new Order();
        return order.getCustomerTelephone(orderId);
    }

    public int getQuotationId(int orderId) {
        Order order = new Order();
        return order.getQuotationId(orderId);
    }

    public int getAmount(int orderId) {
        Order order = new Order();
        return order.getAmount(orderId);
    }
    
    public boolean shipOrder(int orderId){
        Order order = new Order();
        return order.shipOrder(orderId);
    }
    
    public boolean cancelOrder(int orderId){
        Order order = new Order();
        return order.cancelOrder(orderId);
    }
    

}
