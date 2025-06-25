package com.examples.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataPowerTest {

    @DataProvider(name = "testdata")
    public Object[][] testData() {
        return new Object[][] {
                {"Bahadir", 23},
                {"Testname", 40},
                {"Melisa", 1}
        };
    }

    @Test(dataProvider = "testdata")
    public void testMethod(String name, int age) {
        System.out.println("Name: " + name + ", Age: " + age);
    }
}
