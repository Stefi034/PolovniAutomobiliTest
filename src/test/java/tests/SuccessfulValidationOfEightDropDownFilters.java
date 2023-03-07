package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.HomePage;

public class SuccessfulValidationOfEightDropDownFilters extends BaseTestClass {

    private WebDriver driver;

    @BeforeTest
    public void setUpTest(){
        driver = setUpDriver();
    }
    @Test
    public void testSuccessfulValidationOfEightDropDownFilters(){
        HomePage homePage = new HomePage(driver).open();
        homePage.verifyHomePage();
        homePage.isDisplayedEightDropDownsInSearchContainer();
    }


    @AfterMethod(alwaysRun = true)
    public void tearDownTest(){
        tearDown(driver);
    }

}
