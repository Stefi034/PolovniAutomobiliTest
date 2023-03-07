package utils;

import data.Time;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.Assert;

import java.time.Duration;

public class WebDriverUtils {

    public static WebDriver setUpDriver(){
        WebDriver driver = null;

        String browser = PropertiesUtils.getBrowser();
        boolean headless = PropertiesUtils.getHeadless();
        String driversFolder = PropertiesUtils.getDriversFolder();

        String pathToChromeDriver = driversFolder+"chromedriver.exe";
        String pathToFirefoxDriver = driversFolder+"geckodriver.exe";
        String pathToEdgeDriver = driversFolder+"msedgedriver.exe";

        switch (browser){

            case "chrome":{
                ChromeOptions options = new ChromeOptions();
                options.setHeadless(headless);
                options.setPageLoadStrategy(PageLoadStrategy.EAGER);
                System.setProperty("webdriver.chrome.driver",pathToChromeDriver);
                driver = new ChromeDriver(options);
                break;
            }
            case "firefox":{
                FirefoxOptions options = new FirefoxOptions();
                options.setHeadless(headless);
                options.setPageLoadStrategy(PageLoadStrategy.EAGER);
                System.setProperty("webdriver.gecko.driver",pathToFirefoxDriver);
                driver = new FirefoxDriver(options);
                break;
            }
            case "edge":{
                EdgeOptions options = new EdgeOptions();
                options.setHeadless(headless);
                options.setPageLoadStrategy(PageLoadStrategy.EAGER);
                System.setProperty("webdriver.msedge.driver",pathToEdgeDriver);
                driver = new EdgeDriver(options);
                break;
            }
            default:{
                Assert.fail("Cannot create driver! Browser '"+browser+"' is not reckognized!!!");
            }
        }
        //default timeouts
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Time.IMPLICIT_WAIT));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Time.PAGE_LOAD_TIMEOUT));
        driver.manage().window().maximize();

        return driver;
    }
    public static void quitDriver(WebDriver driver){
        driver.quit();
    }
}
