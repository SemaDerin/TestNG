package com.examples.tests;

import com.fasterxml.jackson.databind.ser.Serializers;
import org.testng.annotations.Test;

public class LoadingTest extends BaseTest{




    @Test(timeOut = 6000)
    public void loading(){
        driver.get("https://practicetestautomation.com/practice-test-login/");

    }

}
