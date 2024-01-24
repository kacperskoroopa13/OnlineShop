package Editors;

import Data.Customer;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileHelper {

    private static final String FILE_NAME = "data.txt";

    public void saveCustomersToFile(List<Customer> customerList) throws IOException {
        File file = new File(FILE_NAME);
        if (!file.exists()) {
            file.createNewFile();
        }
        FileWriter fileWriter = new FileWriter(file);
        for (Customer data : customerList) {
            String customer = data.getName() + ";;" + data.getSurname() + ";;" + data.getSex() + ";;" +
                    data.getPhoneNumber() + ";;" + data.getAddress() + ";;" + data.getOrderList().getListOfProducts() + ";;" +
                    data.getRegularCustomer() + "\n";
            fileWriter.write(customer);
        }
        fileWriter.close();
    }

    public List<String> readFromFile() throws IOException {
        ArrayList<String> listOfStrings = new ArrayList<>();
        File file = new File(FILE_NAME);
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            listOfStrings.add(line);
        }
        return listOfStrings;
    }

}
