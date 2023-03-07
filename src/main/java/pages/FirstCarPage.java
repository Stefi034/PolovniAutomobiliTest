package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import java.util.ArrayList;

public class FirstCarPage extends BasePageClass{
    public FirstCarPage(WebDriver driver) {
        super(driver);
    }
    private final By getCarPriceLocator = By.xpath("//span[@class='priceClassified regularPriceColor']");

    public FirstCarPage switchToFirstCarPage(){
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        return this;
    }
    public String getCarPrice(){
        WebElement carPriceTag = getWebElement(getCarPriceLocator);
        return getTextFromWebElement(carPriceTag);
    }


}
