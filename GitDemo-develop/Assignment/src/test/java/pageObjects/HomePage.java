package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import base.BasePage;

import java.util.List;

public class HomePage extends BasePage {

    String homepageURL = "https://covid.starlingminds.com/";
    String expectedLandingPageTitle = "Login";
    String usernameIdLocator = "username";
    String passwordIdLocator = "password";
    String loginButtonIdLocator = "login";
    String expectedSessionHeading = "Session";
    String sessionHeadingXpathLocator = "(//*[@class='session-title'])[1]";
    String firstStepNameXpathLocator = "(//*[@class='step-index'])[1]";
    String allStepsXpathLocator = "(//*[@class='step-index'])";
    String introHeadingClassLocator = "challenge-session-intro-title";
    String stepNameListClassLocator = "step-name";
    String randomCheckboxOneXpathLocator = "//*[@id='ember254']";
    String randomCheckboxTwoXpathLocator = "//*[@id='ember191']";
    String randomInputAreaXpathLocator = "//*[@id='ember267']";
    String expectedIntroHeading = "Managing mental health during COVID-19";

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void goToHomepage(){
        driver.get(homepageURL);
    }

    // VERIFY PAGE TITLE
    public void verifyHomePageTitle(){
        String actualTitle = "";
        actualTitle = driver.getTitle();
        Assert.assertTrue(actualTitle.contentEquals(expectedLandingPageTitle),"Home page title didn't match.");
    }

    // FILL LOGIN DETAILS
    public void fillLoginDetails(String username,String password){
        driver.findElement(By.id(usernameIdLocator)).sendKeys(username);
        driver.findElement(By.id(passwordIdLocator)).sendKeys(password);
        driver.findElement(By.id(loginButtonIdLocator)).click();
    }

    // VERIFY SESSION 1 HEADING
    public void verifySessionOneHeading(){
        String actualSessionHeading = driver.findElement(By.xpath(sessionHeadingXpathLocator)).getText();
        Assert.assertTrue(actualSessionHeading.contains(expectedSessionHeading),"Session Heading is present.");
    }

    // VERIFY ALL 11 STEPS ARE PRESENT ON THE PAGE
    public void verifyIfElevenStepsArePresent(){
        WebDriverWait wait =  new WebDriverWait(driver,60);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(firstStepNameXpathLocator)));
        List<WebElement> stepsList =  driver.findElements(By.xpath(allStepsXpathLocator));
        Assert.assertTrue(stepsList.size()==11,"All 11 Steps are present on the page.");
    }

    // VERIFY SESSION INTRO TITLE
    public void verifySessionIntroTitle(){
        String actualIntroHeading = driver.findElement(By.className(introHeadingClassLocator)).getText().trim();
        Assert.assertTrue(actualIntroHeading.contains(expectedIntroHeading),"Intro Title is present.");
    }

    // VERIFY ALL STEP NAMES
    public void verifyAllStepsName(){
        String[] stepNames = {"We're glad you're here!","Try this relaxation strategy","Rate the effect of COVID-19 on your life","How has COVID-19 affected you?","Rate your level of anxiety related to COVID-19","How your anxiety and worry works","COVID-19 anxiety and worry","Excessive worry","Managing the messaging","Rate this session","Reflect and share: Your experiences and insights with COVID-19"};
        List<WebElement> stepsNamesList = driver.findElements(By.className(stepNameListClassLocator));
        for(int i=0;i<stepsNamesList.size();i++){
            Assert.assertTrue(stepsNamesList.get(i).getText().contains(stepNames[i]),"Step name not correct.");
        }
    }

    // VERIFY CHECKBOXES AND INPUT
    public void verifyCheckboxesAndInputsAreWorking(){
        driver.switchTo().defaultContent();
        //clicking random checkboxes
        WebElement checkbox1 = driver.findElement(By.xpath(randomCheckboxOneXpathLocator));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", checkbox1);
        checkbox1.click();

        WebElement checkbox2 = driver.findElement(By.xpath(randomCheckboxTwoXpathLocator));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", checkbox2);
        checkbox2.click();
        driver.findElement(By.xpath(randomInputAreaXpathLocator)).sendKeys("This is a test message.");
    }
}