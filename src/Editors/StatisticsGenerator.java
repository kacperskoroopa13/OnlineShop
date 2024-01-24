package Editors;

import Data.Customer;
import Data.Product;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StatisticsGenerator {
    public void calculatePurchaseCostForCustomer(List<Customer> customerList) {
        Map<String, List<Integer>> costsForCustomers = customerList.stream()
                .collect(Collectors.groupingBy(customer -> customer.getName(),
                        Collectors.mapping(customer -> customer.getOrderList().getListOfProducts().stream()
                                .mapToInt(Product::getPrice)
                                .sum(), Collectors.toList())));

        for (Map.Entry<String, List<Integer>> entry : costsForCustomers.entrySet()) {
            System.out.println("Customer: " + entry.getKey() + " costs sum: " + entry.getValue());
        }
    }

    public void calculateAverageCostsBySex(List<Customer> customerList) {
        Map<String, Double> averageCostsBySex = customerList.stream()
                .collect(Collectors.groupingBy(
                        Customer::getSex,
                        Collectors.averagingInt(customer ->
                                customer.getOrderList().getListOfProducts().stream()
                                        .mapToInt(Product::getPrice)
                                        .sum()
                        )
                ));
        for (Map.Entry<String, Double> entry : averageCostsBySex.entrySet()) {
            System.out.println("Customer: " + entry.getKey() + " costs sum: " + entry.getValue());
        }
    }
}
