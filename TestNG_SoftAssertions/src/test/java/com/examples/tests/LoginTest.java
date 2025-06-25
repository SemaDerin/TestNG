package com.examples.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class LoginTest extends BaseTest {

    @Test
    public void loginTest() {
        String baseUrl = "https://practicetestautomation.com/practice-test-login/";
        driver.get(baseUrl);

        WebElement username = driver.findElement(By.id("username"));
        WebElement password = driver.findElement(By.id("password"));
        WebElement submit  = driver.findElement(By.id("submit"));

        username.sendKeys("admin");
        password.sendKeys("Password123");
        submit.click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        String errorMessage = driver.findElement(By.id("error")).getText();
        softAssert.assertEquals(errorMessage,"Your username is invalid!");



        username.sendKeys("student");
        password.sendKeys("Password12356");
        submit.click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        String errorMessage2 = driver.findElement(By.id("error")).getText();
        softAssert.assertEquals(errorMessage2,"Your password is invalid!");













        username.sendKeys("student");
        password.sendKeys("Password123");
        submit.click();

        String expected = "Logged In Successfully";
        WebElement actual = driver.findElement(By.className("post-title"));
        softAssert.assertTrue(actual.isDisplayed());
    }
}
