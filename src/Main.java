import Data.Customer;
import Data.Invoice;
import Editors.DataGenerator;
import Editors.FileHelper;
import Editors.StatisticsGenerator;

import java.io.IOException;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) throws IOException {
        Random rnd = new Random();
        DataGenerator dataGenerator = new DataGenerator();
        StatisticsGenerator statisticsGenerator = new StatisticsGenerator();
        FileHelper fileHelper = new FileHelper();

        List<Customer> customers = dataGenerator.generateCustomerList(5);

        System.out.println("----------------------------------------------------------------");
        for (Customer customer: customers){
            System.out.println(customer);
        }
        System.out.println("----------------------------------------------------------------");
        statisticsGenerator.calculatePurchaseCostForCustomer(customers);
        System.out.println("----------------------------------------------------------------");
        statisticsGenerator.calculateAverageCostsBySex(customers);
        System.out.println("----------------------------------------------------------------");
        fileHelper.saveCustomersToFile(customers);
        System.out.println("----------------------------------------------------------------");
        List<String> listOfCustomers = fileHelper.readFromFile();
        for (String t: listOfCustomers){
            System.out.println(t);
        }
        System.out.println("----------------------------------------------------------------");
        int clientNumber = rnd.nextInt(customers.size());
        Invoice invoice = new Invoice(customers.get(clientNumber).getOrderList(), customers.get(clientNumber));
        invoice.generateInvoice();

    }
}