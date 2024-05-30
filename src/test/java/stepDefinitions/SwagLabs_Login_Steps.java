package stepDefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class SwagLabs_Login_Steps {
    WebDriver driver = new ChromeDriver();
    @Given("Open the login page")
    public void open_the_login_page() {
        driver.get("https://www.saucedemo.com/v1/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
    }

    @When("User enter the Username")
    public void user_enter_the_username() {
        System.out.println(driver.getTitle());
        driver.findElement(By.name("user-name")).sendKeys("standard_user");
    }


    @When("User enter the Pasword")
    public void user_enter_the_pasword() {
        WebElement passwordElement = driver.findElement(By.id("password"));
        passwordElement.sendKeys("secret_sauce");
    }


    @When("User click on the Login")
    public void user_click_on_the_login() throws InterruptedException {
        driver.findElement(By.id("login-button")).click();
        Thread.sleep(2000);
    }


    @Then("Swaglabs Homepage should be loaded")
    public void swaglabs_homepage_should_be_loaded() {
        WebElement verifyTitle = driver.findElement(By.className("product_label"));
        verifyTitle.isDisplayed();
        System.out.println("Title is verified");

        driver.close();
        driver.quit();
    }

}
