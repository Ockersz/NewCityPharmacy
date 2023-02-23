package Controller;

import Model.ProductPriceDetails;
import Model.Quotation;
import java.util.List;

public class QuotationController {

    public boolean createQuotation(int finalAmount, int prescriptionId, int customerId, int pharmacistId, List<ProductPriceDetails> productDetails) {
        Quotation quotation = new Quotation();
        return quotation.createQuotation(finalAmount, prescriptionId, customerId, pharmacistId, productDetails);
    }

    public List <Quotation> getQuotationDetails(int customerId) {

        Quotation quotation = new Quotation();
        return quotation.getQuotationDetails(customerId);
    }
    
    public List<ProductPriceDetails> getQuotationProductDetails(int quotationId) {
        Quotation quotation = new Quotation();
        return quotation.getQuotationProductDetails(quotationId);
    }
    
    public int getPrescriptionId(int quotationId){
        Quotation quotation = new Quotation();
        return quotation.getPrescriptionId(quotationId);
    }
    
    public boolean cancelQuotation(int quotationId){
        Quotation quotation = new Quotation();
        return quotation.cancelQuotation(quotationId);
    }
    
    
}
