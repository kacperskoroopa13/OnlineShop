package Data;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString


public class Customer {
    private String name;
    private String surname;
    private String sex;
    private Address address;
    private String phoneNumber;
    private String regularCustomer;
    private Order orderList;


    private void updatePhoneNumber(String newNumber){
        this.phoneNumber = newNumber;
    }
    private void updateCustomerAddress(Address newAddress){
        this.address = newAddress;
    }

}
