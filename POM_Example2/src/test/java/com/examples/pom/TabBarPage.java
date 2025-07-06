package com.examples.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class TabBarPage {
    private final WebDriver driver;

    private final By searhBoxLocator = By.id("searchData");
    private final By baseketTotalNumberLocator = By.className("basketTotalNum");

    public TabBarPage(WebDriver driver){
        this.driver= driver;
    }

    public void searchData(String product){
        driver.findElement(searhBoxLocator).sendKeys(product+ Keys.ENTER);
    }

    public String getBasketNumber(){
        return driver.findElement(baseketTotalNumberLocator).getText();

    }
}
