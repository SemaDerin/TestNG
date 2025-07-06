package com.examples.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductDetailPage {
    private final WebDriver driver;

    private final By addBasketLocator = By.className("product-add-cart");


    public ProductDetailPage(WebDriver driver){
        this.driver = driver;

    }

    public void addBasket(){
        driver.findElement(addBasketLocator).click();
    }




}




