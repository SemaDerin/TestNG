package com.examples.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ResultPage {


    private final WebDriver driver;

    private final By resultTextLocator = By.className("resultView");
    private final By productLocator = By.cssSelector("img.cardImage");



    public ResultPage(WebDriver driver){
        this.driver = driver;
    }

    public void clickToProduct(){
        driver.findElements(productLocator).get(0).click();
    }



    public WebElement verifyMessage(){
        return driver.findElement(resultTextLocator);

    }


}


