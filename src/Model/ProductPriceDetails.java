package Model;

public class ProductPriceDetails {

    private String productId;
    private String generic;
    private String dosage;
    private int quantity;
    private int amount;
    

    public ProductPriceDetails(String productId, int quantity, int amount) {
        this.productId = productId;
        this.quantity = quantity;
        this.amount = amount;
    }
    
    public ProductPriceDetails(String productId, int quantity) {
        this.productId = productId;
        this.quantity = quantity;

    }
    
    
    public ProductPriceDetails(String productId, String generic, String dosage, int quantity, int amount ) {
        this.generic = generic;
        this.productId = productId;
        this.dosage = dosage;
        this.quantity = quantity;
        this.amount = amount;

    }

    public String getProductId() {
        return productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getAmount() {
        return amount;
    }
    
    public String getGeneric(){
        return generic;
    }
    
    public String getDosage(){
        return dosage;
    }
    
    
    
    
    

}
