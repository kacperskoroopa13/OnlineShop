package Tests;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;


import Editors.DataGenerator;

public class TestGenerator {
    @Test
    public void testGenerateQuantity() {
        DataGenerator dataGenerator = new DataGenerator();
        assertTrue(dataGenerator.generateQuantity() >= 0);
    }

    @Test
    public void testGeneratePhoneNumber() {
        DataGenerator dataGenerator = new DataGenerator();
        String number = dataGenerator.generatePhoneNumber();
        assertTrue(number.matches("\\d{3}-\\d{3}-\\d{3}"));
    }

    @Test
    public void testGeneratePostalCode() {
        DataGenerator dataGenerator = new DataGenerator();
        String code = dataGenerator.generatePostalCode();
        assertTrue(code.matches("\\d{2}-\\d{3}"));
    }

    @Test
    public void testGeneratePrice() {
        DataGenerator dataGenerator = new DataGenerator();
        int price = dataGenerator.generatePrice();
        assertTrue(price >= 0);
    }

    @Test
    public void testGenerateAddress() {
        DataGenerator dataGenerator = new DataGenerator();
        assertNotNull(dataGenerator.generateAddress());
    }

}
