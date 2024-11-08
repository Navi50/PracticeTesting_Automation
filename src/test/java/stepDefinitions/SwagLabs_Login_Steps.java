package stepDefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.SwagLoginPage;
import utils.DriverManager;


public class SwagLabs_Login_Steps {



    @Given("Open the login page")
    public void open_the_login_page() {

    }

    @When("User enter the Username")
    public void user_enter_the_username() {
        SwagLoginPage.getInstance().enterUsername();
    }


    @When("User enter the Pasword")
    public void user_enter_the_pasword() {
        SwagLoginPage.getInstance().enterPassword();
    }


    @When("User click on the Login")
    public void user_click_on_the_login() throws InterruptedException {
        SwagLoginPage.getInstance().clickLogin();
        Thread.sleep(2000);
    }


    @Then("Swaglabs Homepage should be loaded")
    public void swaglabs_homepage_should_be_loaded() {
        WebElement verifyTitle = DriverManager.getDriver().findElement(By.className("product_label"));
        verifyTitle.isDisplayed();
        System.out.println("Title is verified");
    }

}
