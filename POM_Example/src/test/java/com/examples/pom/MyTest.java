package com.examples.pom;

import org.testng.annotations.Test;

public class MyTest extends BaseTest{


    @Test
    public void shopping(){
        driver.get("https://www.n11.com/");
        shopping.searchBox("laptop");
        shopping.showResultMessage();
        shopping.findProduct();
        shopping.basketCount();
    }
}
