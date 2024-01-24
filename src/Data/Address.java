package Data;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor

public class Address {
    private String city;
    private String street;
    private String postalCode;
    private String houseNumber;
}
