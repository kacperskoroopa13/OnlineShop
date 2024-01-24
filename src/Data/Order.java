package Data;


import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor

public class Order {
    private List<Product> listOfProducts;
    private String orderDate;
    private PaymentDetails paymentDetails;

    public Order(List<Product> listOfProducts) {
        this.listOfProducts = listOfProducts;
    }
}
