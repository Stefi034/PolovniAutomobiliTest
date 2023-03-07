package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utils.PropertiesUtils;

import java.time.Duration;
import java.util.List;

public abstract class BasePageClass {

    protected WebDriver driver;

    public BasePageClass(WebDriver driver){
        this.driver=driver;
    }
    protected String getPageUrl(String path){
        return PropertiesUtils.getProdUrl()+path;
    }
    protected boolean waitForUrlChange(String url, int timeout){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.urlToBe(url));
    }
    protected void openPage(String pageUrl){
        driver.get(pageUrl);
    }
    protected WebElement getWebElement(By locator){
        return driver.findElement(locator);
    }
    protected WebElement getWebElement(By locator, int timeout){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }
    protected WebElement waitForWebElementToBeClickable(WebElement element, int timeout){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }
    protected boolean isWebElementDisplayed(By locator){
        try {
            WebElement element = getWebElement(locator);
            return element.isDisplayed();
        }catch (Exception e){
            return false;
        }
    }
    protected int numberOfElementsSelected(By locator){
        List<WebElement> elements = driver.findElements(locator);
        return elements.size();
    }
    public boolean isListSorted(List<WebElement> elements){
        String[] values = new String[elements.size()];
        for (int i=0; i<elements.size(); i++){
            values[i] = elements.get(i).getText();
        }
        char[] firstCompareValue;
        char[] secondCompareValue;
        boolean isSorted = true;

        for (int i = 0; i< values.length-1; i++){
            firstCompareValue= values[i].toUpperCase().toCharArray();
            secondCompareValue = values[i+1].toUpperCase().toCharArray();
            int shorterCompare = firstCompareValue.length;
            if (shorterCompare>secondCompareValue.length){
                shorterCompare=secondCompareValue.length;
            }
            for (int y=0; y<shorterCompare; y++){
                if (secondCompareValue[y]>firstCompareValue[y]){
                    break;
                }else if (secondCompareValue[y]<firstCompareValue[y]){
                    isSorted=false;
                    break;
                }else if (y==shorterCompare-1){
                    if (firstCompareValue.length>secondCompareValue.length){
                        isSorted=false;
                        break;
                    }
                }
            }
            if (isSorted==false){
                break;
            }
        }
        return isSorted;
    }
    protected String getTextFromWebElement(WebElement element){
        return element.getText();
    }
    protected void clickOnWebElement(WebElement element){
        element.click();
    }
    protected void clickOnWebElement(WebElement element, int timeout){
        WebElement webElement = waitForWebElementToBeClickable(element,timeout);
        webElement.click();
    }
    protected void clickOnWebElementJS(WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click", element);
    }
    protected void scrollDownJS(WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", element);
    }



}
