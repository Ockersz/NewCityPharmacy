package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class SalesInvoice extends Invoice {

    public void inputSalesDetails(int orderId, float invoiceAmount, String paymentMethod, ProductPriceDetails[] productList) {
        try (Connection con = DatabaseConnection.getConnection(); PreparedStatement st1 = con.prepareStatement("Insert into Invoice (amount, payment_method) values (?,?)", Statement.RETURN_GENERATED_KEYS); PreparedStatement st2 = con.prepareStatement("insert into sales_invoice (oid, s_inv_id) values (?,?)"); PreparedStatement st3 = con.prepareStatement("insert into invoice_has_products (inv_id, pid, quantity) values (?,?,?)");) {

            st1.setFloat(1, invoiceAmount);
            st1.setString(2, paymentMethod);

            int i = st1.executeUpdate();

            if (i == 1) {
                ResultSet rst = st1.getGeneratedKeys();
                if (rst.next()) {
                    setInvoiceId(rst.getInt(1));
                }
            }

            st2.setInt(1, orderId);
            st2.setInt(2, getInvoiceId());

            if (st2.executeUpdate() == 1) {

                for (ProductPriceDetails product : productList) {
                    st3.setInt(1, getInvoiceId());
                    st3.setString(2, product.getProductId());
                    st3.setInt(3, product.getQuantity());
                    st3.executeUpdate();
                    st3.clearParameters();
                }
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Database Error", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

}
