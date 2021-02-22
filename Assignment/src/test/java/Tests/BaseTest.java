package Tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;


public class BaseTest {

    private WebDriver driver;


// Just to update my details in git adding this note





// Again adding some comments just to see my code on eclipse is updating or not


// adding  a new comment to just to check my file is updating or not properly 




    @BeforeSuite
    public void beforeSuite() {
        System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") + "\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterSuite
    public void afterSuite() {
        if(null != driver) {
            driver.close();
            driver.quit();
        }
    }


    public WebDriver getDriver() {
        return driver;
    }
}