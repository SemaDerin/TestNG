package com.examples.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTested extends BaseTest {

    @Test
    public void loginTest() {
        String baseUrl = "https://practicetestautomation.com/practice-test-login/";
        driver.get(baseUrl);

        driver.findElement(By.id("username")).sendKeys("student");
        driver.findElement(By.id("password")).sendKeys("Password123");
        driver.findElement(By.id("submit")).click();

        String expected = "Logged In Successfully";
        WebElement actual = driver.findElement(By.xpath("//*[@id=\"loop-container\"]/div/article/div[1]/h1"));
        String actualMessage = actual.getText();

        Assert.assertEquals(actualMessage, expected, "Login unsuccessful");
    }
}
