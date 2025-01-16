package stepDefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.OrangeHRMPage;
import pages.SwagLabsPage;
import utils.Constants;
import utils.DriverManager;
import utils.ExtentReportsUtil;

public class OrangeHRM_Steps {
    @Given("User Open the OrangeHRM page")
    public void user_open_the_orange_hrm_page() {
        DriverManager.getDriver().navigate().to(Constants.ORANGEURL);
        ExtentReportsUtil.addLog("\n"+" Open the login page - Successful \n");
    }

    @When("User enter the Username and Password for OrangeHRM page")
    public void userEnterTheUsernameAndPasswordForOrangeHRMPage() throws InterruptedException {
        OrangeHRMPage.getInstance().enterText("username","name","Admin");
        ExtentReportsUtil.addLog("\n"+" User enter the Username - Successful"+"\n");

        OrangeHRMPage.getInstance().enterText("password","name","admin123");
        ExtentReportsUtil.addLog("\n"+" User enter the Password - Successful"+"\n");

        Thread.sleep(2000);
    }


    @And("User click on the Login for OrangeHRM page")
    public void userClickOnTheLoginForOrangeHRMPage() throws InterruptedException {
        OrangeHRMPage.getInstance().clickElement("login","xpath");
        Thread.sleep(2000);
        ExtentReportsUtil.addLog("\n"+" User click on Login - Successful"+"\n");
    }

    @Then("OrangeHRM Homepage should be loaded")
    public void orange_hrm_homepage_should_be_loaded() {
        WebElement verifyTitle = DriverManager.getDriver().findElement(By.className("oxd-brand-banner"));
        verifyTitle.isDisplayed();
        System.out.println("Home page is verified");
        ExtentReportsUtil.addLog("\n"+" OrangeHRM home page should be loaded - Successful"+"\n");
    }



}
