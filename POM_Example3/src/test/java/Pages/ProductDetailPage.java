package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductDetailPage extends BasePage{

    private final By addBasketLocator = By.className("product-add-cart");


    public ProductDetailPage(WebDriver driver){
        super(driver);

    }

    public void addBasket(){
        driver.findElement(addBasketLocator).click();
    }




}




