package com.examples.tests;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class MyClass {
    @Parameters({"browser","baseUrl"})
    @Test
    public void testMethod(String browser,String baseUrl){
        System.out.println(browser);
        System.out.println(baseUrl);

    }
}
