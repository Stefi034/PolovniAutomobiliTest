package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.FirstCarPage;
import pages.HomePage;

public class PricePrintOfFirstCarInGridContainer extends BaseTestClass {

    private WebDriver driver;


    @BeforeTest
    public void setUpTest(){
        driver = setUpDriver();
    }


    @Test
    public void testFuelDropDownContentNotAlphabeticalSorted(){
        HomePage homePage = new HomePage(driver).open();
        homePage.verifyHomePage();
        homePage.scrollDownToCarGridContainer();
        FirstCarPage firstCarPage =homePage.clickFirstCarInSelectionGrid();
        System.out.println(firstCarPage.getCarPrice());
    }


    @AfterMethod(alwaysRun = true)
    public void tearDownTest(){
        tearDown(driver);
    }
}
