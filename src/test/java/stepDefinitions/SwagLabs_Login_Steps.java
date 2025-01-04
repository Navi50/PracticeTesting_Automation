package stepDefinitions;


import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.SwagLoginPage;
import utils.DriverManager;
import utils.ExtentReportsUtil;

import java.io.IOException;


public class SwagLabs_Login_Steps {


    @Given("Open the login page")
    public void open_the_login_page() throws IOException {
        ExtentReportsUtil.addLog("Open the login page - Successful");
    }

    @When("User enter the Username")
    public void user_enter_the_username() {
        SwagLoginPage.getInstance().enterUsername();
        ExtentReportsUtil.addLog("User enter the Username - Successful");
    }


    @When("User enter the Pasword")
    public void user_enter_the_pasword() {
        SwagLoginPage.getInstance().enterPassword();
        ExtentReportsUtil.addLog("User enter the Password - Successful");
    }


    @When("User click on the Login")
    public void user_click_on_the_login() throws InterruptedException {
        SwagLoginPage.getInstance().clickLogin();
        Thread.sleep(2000);
        ExtentReportsUtil.addLog("User click on Login - Successful");
    }


    @Then("Swaglabs Homepage should be loaded")
    public void swaglabs_homepage_should_be_loaded() {
        WebElement verifyTitle = DriverManager.getDriver().findElement(By.className("product_label"));
        verifyTitle.isDisplayed();
        System.out.println("Title is verified");
        ExtentReportsUtil.addLog("SwagLabs home page should be loaded - Successful");

    }

}
