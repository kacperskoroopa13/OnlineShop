package Data;

import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor

public class Invoice {
    private String customerName;
    private String customerSurname;
    private String customerPhoneNumber;
    private String invoiceDate;
    private List<Product> listOfProducts;

    public Invoice(Order order, Customer customer) {
        listOfProducts = order.getListOfProducts();
        customerName = customer.getName();
        customerSurname = customer.getSurname();
        customerPhoneNumber = customer.getPhoneNumber();
        invoiceDate = order.getOrderDate();
    }

    public double sumInvoiceCost() {
        double sum = 0.0;
        for (Product p : listOfProducts
        ) {
            sum += p.getPrice();
        }
        return sum;
    }

    public void generateInvoice() {
        System.out.println("Invoice for: " + customerName + " " + customerSurname);
        System.out.println("Phone number: " + customerPhoneNumber);
        System.out.println("Date: " + invoiceDate);
        System.out.println("Products: " + listOfProducts.toString());
        System.out.println("Total sum: " + sumInvoiceCost());
    }
}
