package com.examples.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class MyTestPage {

    WebDriver driver;

    private By searhBox = By.id("searchData");
    private By cookieAccept = By.id("1d5d7aff-8ee1-4a98-9022-f0e29a5e471c");
    private By resultMessage = By.className("resultText");
    private By product = By.cssSelector("img.cardImage");
    private By addBasket = By.xpath("//*[@id=\"unfDetailForm\"]/div[2]/div[2]/div[1]/button");

    private By basketNumber = By.className("basketTotalNum");


    public MyTestPage(WebDriver driver){
        this.driver = driver;
    }


    public void searchBox(String product){
        driver.findElement(searhBox).sendKeys(product + Keys.ENTER);
    }

    public void showResultMessage(){
        String result= driver.findElement(resultMessage).getText();
        Assert.assertTrue(result.contains("sonuç bulundu."));
    }

    public void findProduct(){
        //driver.findElement(cookieAccept).click();
        driver.findElement(product).click();
        driver.findElement(addBasket).click();
    }


    public String basketCount(){
        String number = driver.findElement(basketNumber).getText();
        return number;
    }


}
