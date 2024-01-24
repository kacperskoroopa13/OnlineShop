package Editors;

import Data.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DataGenerator {
    Random rnd = new Random();

    public Address generateAddress() {
        return new Address(Constants.CITIES[rnd.nextInt(Constants.CITIES.length)], Constants.STREETS[rnd.nextInt(Constants.STREETS.length)], generatePostalCode(), generateHouseNumber());
    }

    public String generatePostalCode() {
        StringBuilder str = new StringBuilder();
        return str.append(rnd.nextInt(0, 10))
                .append(rnd.nextInt(0, 10))
                .append("-")
                .append(rnd.nextInt(0, 10))
                .append(rnd.nextInt(0, 10))
                .append(rnd.nextInt(0, 10))
                .toString();
    }

    private String generateHouseNumber() {
        StringBuilder str = new StringBuilder();
        return str.append(rnd.nextInt(0, 100))
                .append((char) rnd.nextInt(65, 91))
                .toString();
    }

    private String generateTypeOfCustomer() {
        return Constants.REGULAR[rnd.nextInt(Constants.REGULAR.length)];
    }

    private boolean isRegularCustomer(String X) {
        return X.equals("Y");
    }

    private PaymentDetails generatePaymentMethod() {
        return new PaymentDetails(Constants.PAYMENT_METHODS[rnd.nextInt(Constants.PAYMENT_METHODS.length)], generateBonus());
    }

    public int generateQuantity() {
        return rnd.nextInt(10);
    }

    private int generateBonus() {
        int bonus = 0;
        if (isRegularCustomer(generateTypeOfCustomer())) {
            return rnd.nextInt(1, 20);
        } else return bonus;
    }

    public int generatePrice() {
        int price = rnd.nextInt(40, 1501);
        if (isRegularCustomer(generateTypeOfCustomer())) {
            return price = price - generateBonus();
        } else return price;
    }

    public String generateOrderDate() {
        StringBuilder str = new StringBuilder();
        return str.append(rnd.nextInt(1, 32))
                .append("-")
                .append(rnd.nextInt(1, 13))
                .append("-")
                .append("2023")
                .toString();
    }

    private Product generateProduct() {
        Product product = new Product();
        product.setName(Constants.PRODUCTS[rnd.nextInt(Constants.PRODUCTS.length)]);
        product.setPrice(generatePrice());
        product.setAvailableQuantity(generateQuantity());
        return product;
    }

    private List<Product> generateListOfProducts(int n) {
        List<Product> productList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            productList.add(generateProduct());
        }
        return productList;
    }

    private Order generateOrder() {
        Order order = new Order();
        order.setListOfProducts(generateListOfProducts(rnd.nextInt(1, 10)));
        order.setOrderDate(generateOrderDate());
        order.setPaymentDetails(generatePaymentMethod());
        return order;
    }

    public String generatePhoneNumber() {
        StringBuilder str = new StringBuilder();
        return str.append(rnd.nextInt(0, 10))
                .append(rnd.nextInt(0, 10))
                .append(rnd.nextInt(0, 10))
                .append("-")
                .append(rnd.nextInt(0, 10))
                .append(rnd.nextInt(0, 10))
                .append(rnd.nextInt(0, 10))
                .append("-")
                .append(rnd.nextInt(0, 10))
                .append(rnd.nextInt(0, 10))
                .append(rnd.nextInt(0, 10))
                .toString();
    }

    public Customer generateCustomer() {
        Customer customer = new Customer();
        String sex = Constants.SEX[rnd.nextInt(Constants.SEX.length)];

        if (sex.equals("K")) {
            customer.setSex(sex);
            customer.setName(Constants.NAMES_FEMALE[rnd.nextInt(Constants.NAMES_FEMALE.length)]);
            customer.setSurname(Constants.SURNAMES_FEMALE[rnd.nextInt(Constants.SURNAMES_FEMALE.length)]);
        } else if (sex.equals("M")) {
            customer.setSex(sex);
            customer.setName(Constants.NAMES_MALE[rnd.nextInt(Constants.NAMES_MALE.length)]);
            customer.setSurname(Constants.SURNAMES_MALE[rnd.nextInt(Constants.SURNAMES_MALE.length)]);
        }
        customer.setAddress(generateAddress());
        customer.setPhoneNumber(generatePhoneNumber());
        customer.setRegularCustomer(generateTypeOfCustomer());
        customer.setOrderList(generateOrder());
        return customer;
    }

    public List<Customer> generateCustomerList(int n) {
        List<Customer> customerList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            customerList.add(generateCustomer());
        }
        return customerList;
    }
}
