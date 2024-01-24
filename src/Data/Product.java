package Data;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class Product {
    private String name;
    private int price;
    private int availableQuantity;
}
