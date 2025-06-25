package com.examples.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class MyTest {

    WebDriver driver;

    @Parameters({"browser"})
    @BeforeClass
    public void setUp(String browser) throws IllegalAccessException {
        switch (browser.toLowerCase()) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            default:
                throw new IllegalAccessException("Invalid browser name: " + browser);
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void test01() {
        driver.get("https://www.amazon.com.tr/");

        // Explicit wait for cookie popup
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            WebElement cookieButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("sp-cc-accept")));
            cookieButton.click();
        } catch (TimeoutException e) {
            System.out.println("Çerez butonu bulunamadı veya görünür değil.");
        }

        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iPhone" + Keys.ENTER);
    }



    @Test(enabled = false)
    public void test02() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            // Üçüncü ürüne tıklama
            WebElement thirdProduct = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//div[@data-index='2']")));
            thirdProduct.click();

            // Cookie kabul
            try {
                WebElement cookieButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("sp-cc-accept")));
                cookieButton.click();
            } catch (TimeoutException ignored) {}

            // Sepete ekleme
            WebElement addToCart = wait.until(ExpectedConditions.elementToBeClickable(By.id("add-to-cart-button")));
            addToCart.click();

            // Sepet sayısını kontrol et
            WebElement basketCount = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nav-cart-count")));
            String basketCountText = basketCount.getText();

            Assert.assertFalse(basketCountText.equals("0"), "Sepet boş!");
        } catch (Exception e) {
            Assert.fail("test02 sırasında bir hata oluştu: " + e.getMessage());
        }
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
