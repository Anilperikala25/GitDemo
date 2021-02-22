package Tests;

import org.testng.Reporter;
import org.testng.annotations.Test;

import pageObjects.HomePage;

public class SessionOneTest extends BaseTest{

    @Test
    public void homepageTests() {
        HomePage homepage = new HomePage(getDriver());

        Reporter.log("STEP 1 : Going to Starling homepage.",true);
        homepage.goToHomepage();

        Reporter.log("STEP 2 : Verifying Starling homepage title.",true);
        homepage.verifyHomePageTitle();

        Reporter.log("STEP 3 : Filling login details.",true);
        homepage.fillLoginDetails("anilperikala16@gmail.com","Anil1234$");

        Reporter.log("STEP 4 : Verifying if all eleven steps are present.",true);
        homepage.verifyIfElevenStepsArePresent();

        Reporter.log("STEP 5 : Verifying session intro title.",true);
        homepage.verifySessionIntroTitle();

        Reporter.log("STEP 6 : Verifying session one heading.",true);
        homepage.verifySessionOneHeading();

        Reporter.log("STEP 7 : Verifying all steps names are correct.",true);
        homepage.verifyAllStepsName();

        Reporter.log("STEP 8 : Verifying if checkboxes and input are working..",true);
        homepage.verifyCheckboxesAndInputsAreWorking();
    }

}