package com.examples.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class MyTest {

    WebDriver driver;
    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void test01(){

        String baseUrl = "https://www.amazon.com.tr/?&tag=trtxtgoabkde-21&ref=pd_sl_7r6v9rntlw_e&adgrpid=154611856018&hvpone=&hvptwo=&hvadid=674177764078&hvpos=&hvnetw=g&hvrand=16099192299551097326&hvqmt=e&hvdev=c&hvdvcmdl=&hvlocint=&hvlocphy=21055&hvtargid=kwd-10573980&hydadcr=12932_2354400&language=tr_TR";
        driver.get(baseUrl);
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iPhone"+ Keys.ENTER);
        driver.findElement(By.id("sp-cc-accept")).click();
    }

    @Test
    public void test02(){
        driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div[1]/div/span[1]/div[1]/div[3]/div/div")).click();
        driver.findElement(By.id("sp-cc-accept")).click();
        driver.findElement(By.id("add-to-cart-button")).click();
        WebElement basketCount = driver.findElement(By.id("nav-cart-count"));
        String basketCountText = basketCount.getText();
        Assert.assertTrue(basketCountText != "0");

    }


    @AfterClass
    public void tearDown(){
        driver.quit();
    }
    // }

}