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
        ExtentReportsUtil.addLog("\n"+" Open the login page - Successful"+"\n");
    }

    @When("User enter the Username and Password")
    public void user_enter_the_username_and_password() throws InterruptedException {
        SwagLoginPage.getInstance().enterUsername();
        ExtentReportsUtil.addLog("\n"+" User enter the Username - Successful"+"\n");

        SwagLoginPage.getInstance().enterPassword();
        ExtentReportsUtil.addLog("\n"+" User enter the Password - Successful"+"\n");

        Thread.sleep(2000);
    }

    @When("User click on the Login")
    public void user_click_on_the_login() throws InterruptedException {
        SwagLoginPage.getInstance().clickLogin();
        Thread.sleep(2000);
        ExtentReportsUtil.addLog("\n"+" User click on Login - Successful"+"\n");
    }


    @Then("Swaglabs Homepage should be loaded")
    public void swaglabs_homepage_should_be_loaded() {
        WebElement verifyTitle = DriverManager.getDriver().findElement(By.className("product_label"));
        verifyTitle.isDisplayed();
        System.out.println("Title is verified");
        ExtentReportsUtil.addLog("\n"+" SwagLabs home page should be loaded - Successful"+"\n");

    }

    @When("User changed sort option to (.+)$")
    public void userChangedSortOptionTo(String sortOption) throws InterruptedException {
        SwagLoginPage.getInstance().changeSort(sortOption);
        Thread.sleep(1000);
    }

    @Then("User click on first product")
    public void user_click_on_first_product() {
       SwagLoginPage.getInstance().clickOnFirstItem();
    }



}
