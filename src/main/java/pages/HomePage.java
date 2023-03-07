package pages;

import data.PageUrlPaths;
import data.Time;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class HomePage extends BasePageClass {

    public HomePage(WebDriver driver){
        super(driver);
    }

    private final String HOME_PAGE_URL = getPageUrl(PageUrlPaths.HOME_PAGE);
    private final By eightDropDownsInSearchContainerLocator = By.xpath("//form[@class='uk-form js_uk-form']/descendant::select");
    private final By isFuelSortedLocator = By.xpath("//select[@id='fuel']/descendant::option");
    private final By firstCarInSelectionGridLocator = By.xpath("//div[@class='uk-grid uk-margin-remove']/descendant::a[1]");


    public HomePage open(){
        openPage(HOME_PAGE_URL);
        return this;
    }
    public HomePage verifyHomePage(){
        waitForUrlChange(HOME_PAGE_URL, Time.PAGE_LOAD_TIMEOUT);
        return this;
    }
    public void isDisplayedEightDropDownsInSearchContainer() {
        int checkNumber = numberOfElementsSelected(eightDropDownsInSearchContainerLocator);
        Assert.assertEquals(checkNumber, 8, "There is no 8 drop downs in vehicle search container!!");
        }
    public void isFuelSorted(){

        List<String> inputs = new ArrayList<>();

        List<WebElement> elements = driver.findElements(isFuelSortedLocator);
        for (WebElement element : elements){
            inputs.add(element.getText());
        }
        if (isListSorted(elements)){
            System.out.println("Search options in fuel drop down are alphabetically sorted!!!");
        }else {
            System.out.println("Search options in fuel drop down are not alphabetically sorted!!!");
        }
        isListSorted(elements);
    }
    public boolean isFirstCarInSelectionGridDisplayed(){
        return isWebElementDisplayed(firstCarInSelectionGridLocator);
    }
    public void scrollDownToCarGridContainer(){
        WebElement firstCarInSelectionGrid = getWebElement(firstCarInSelectionGridLocator);
        scrollDownJS(firstCarInSelectionGrid);
    }
    public FirstCarPage clickFirstCarInSelectionGrid(){
        Assert.assertTrue(isFirstCarInSelectionGridDisplayed(),"First car in selection grid is not displayed!!!");
        WebElement firstCarInSelectionGrid = getWebElement(firstCarInSelectionGridLocator);
        clickOnWebElement(firstCarInSelectionGrid);
        FirstCarPage firstCarPage = new FirstCarPage(driver);
        return firstCarPage.switchToFirstCarPage();
    }













}






