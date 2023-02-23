package Controller;

import Model.Product;
import java.util.Date;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class ProductController {

    public String getNewProductId() {
        int maxId;
        String newId;
        Product obj = new Product();
        if (obj.getMaxProductId() == null) {

            maxId = 0;
        } else {
            maxId = Integer.parseInt(obj.getMaxProductId());
        }
        maxId++;
        newId = Integer.toString(maxId);
        
        switch (newId.length()) {
            case 1:
                newId  = "0000"+newId;
                break;
            case 2:
                newId  = "000"+newId;
                break;
            case 3:
                newId = "00"+newId;
                break;
            case 4:
                newId = "0"+newId;
                break;
            default:
                break;
        }
        return newId;
    }

    public boolean addProduct(String productId, String generic, String brand, String company, String dosage, String category, Date expiryDate, int availableQuantity, int unitPrice) {

        Product product = new Product();
        return product.addProduct(productId, generic, brand, company, dosage, category, expiryDate, availableQuantity, unitPrice);

    }

    public List<Product> getProductShortDetail() {
        Product product = new Product();
        return product.getProductShortDetail();
    }

    public Product getProductAllDetails(String productId) {
        Product product = new Product();
        return product.getProductAllDetails(productId);
    }

    public boolean updateProduct(String productId, String generic, String brand, String company, String dosage, String category, Date expiryDate, int availableQuantity, int unitPrice) {
        Product product = new Product();
        return product.updateProduct(productId, generic, brand, company, dosage, category, expiryDate, availableQuantity, unitPrice);
    }

    public boolean deleteProduct(String productId) {
        Product product = new Product();
        return product.deleteProduct(productId);
    }

    public DefaultTableModel getProductDetails() {
        Product product = new Product();
        return product.getProductDetails();
    }

    public String getGenericName(String productId) {
        Product product = new Product();
        return product.getGenericName(productId);
    }

    public int getUnitPrice(String productId) {
        Product product = new Product();
        return product.getUnitPrice(productId);
    }

    public int getAvailableQuantity(String productId) {
        Product product = new Product();
        return product.getAvailableQuantity(productId);
    }

    public String getDosage(String productId) {
        Product product = new Product();
        return product.getDosage(productId);
    }

    public List<Product> getLowStockProducts() {
        Product product = new Product();
        return product.getLowStockProducts();
    }

    public List<Product> getExpiryProducts() {
        Product product = new Product();
        return product.getExpiryProducts();
    }
}
