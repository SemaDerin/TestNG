package com.examples.pom;

import org.testng.Assert;
import org.testng.annotations.Test;

public class N11Test extends BaseTest{

    TabBarPage tabBarPage;
    ResultPage resultPage;
    ProductDetailPage productDetailPage;

    @Test(priority = 1)
    public void searchTest(){
        driver.get("https://www.n11.com/");
        tabBarPage = new TabBarPage(driver);
        tabBarPage.searchData("laptop");

    }

    @Test(priority = 2)
    public void resultPage(){
        resultPage = new ResultPage(driver);
        String message = resultPage.verifyMessage().getText();
        Assert.assertTrue(message.contains("sonuç bulundu."));
        resultPage.clickToProduct();

    }

    @Test(priority = 3)
    public void addBasket(){
        productDetailPage = new ProductDetailPage(driver);
        productDetailPage.addBasket();
        String basket = tabBarPage.getBasketNumber();
        softAssert.assertTrue(basket != "1");


    }
}
