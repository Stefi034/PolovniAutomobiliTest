package tests;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import utils.WebDriverUtils;

public abstract class BaseTestClass {

    protected WebDriver setUpDriver(){
        return WebDriverUtils.setUpDriver();
    }
    protected void quitDriver(WebDriver driver){
        WebDriverUtils.quitDriver(driver);
    }

    protected void tearDown(WebDriver driver){
        quitDriver(driver);
    }




}
