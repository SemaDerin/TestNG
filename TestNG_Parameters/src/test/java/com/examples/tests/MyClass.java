package com.examples.tests;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.net.SocketTimeoutException;
import java.sql.SQLOutput;

public class MyClass {
    @Parameters({"browser","baseUrl"})
    @Test
    public void testMethod(String browser,String baseUrl){
        System.out.println(browser);
        System.out.println(baseUrl);

    }
}
