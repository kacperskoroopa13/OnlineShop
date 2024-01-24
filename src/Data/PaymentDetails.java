package Data;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor

public class PaymentDetails {
    private String paymentMethod;
    private int bonus;
}
