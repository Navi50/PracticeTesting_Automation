package stepDefinitions;


import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pages.SharedState;
import pages.SwagLabsPage;
import utils.Constants;
import utils.DriverManager;
import utils.ExtentReportsUtil;

import java.io.IOException;


public class SwagLabs_Login_Steps {

    private final SharedState sharedState;

    public SwagLabs_Login_Steps(SharedState sharedState){
        this.sharedState = sharedState;
    }

    @Given("Open the login page")
    public void open_the_login_page() throws IOException {
        DriverManager.getDriver().navigate().to(Constants.URL);
        ExtentReportsUtil.addLog("\n"+" Open the login page - Successful \n");
    }

    @When("User enter the Username and Password")
    public void user_enter_the_username_and_password() throws InterruptedException {
        SwagLabsPage.getInstance().enterText("username","name","standard_user");
        ExtentReportsUtil.addLog("\n"+" User enter the Username - Successful"+"\n");

        SwagLabsPage.getInstance().enterText("password","name","secret_sauce");
        ExtentReportsUtil.addLog("\n"+" User enter the Password - Successful"+"\n");

        Thread.sleep(2000);
    }

    @When("User click on the Login")
    public void user_click_on_the_login() throws InterruptedException {
        SwagLabsPage.getInstance().clickElement("login","id");
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
        SwagLabsPage.getInstance().changeSort(sortOption);
        Thread.sleep(1000);
    }

    @Then("User click on first product")
    public void user_click_on_first_product() {
        String title = SwagLabsPage.getInstance().getElementText("item1Name","xpath");
        SwagLabsPage.getInstance().clickElement("item1","xpath");

        sharedState.setSharedData(title);
    }


    @And("User Verify the Item name")
    public void userVerifyTheItemName() {
        String title = SwagLabsPage.getInstance().getElementText("itemName","xpath");
        String validate = sharedState.getSharedData();

        Assert.assertEquals(title,validate);
    }

    @When("User click on Add to Cart")
    public void userClickOnAddToCart() {
        SwagLabsPage.getInstance().clickElement("addToCard","xpath");
    }

    @Then("User Verify Item added in Cart")
    public void userVerifyItemAddedInCart() {
        SwagLabsPage.getInstance().clickElement("itemCart","xpath");
        String title = SwagLabsPage.getInstance().getElementText("itemNameInCart","xpath");
        String validate = sharedState.getSharedData();

        Assert.assertEquals(title,validate);
    }

    @When("User click on Checkout")
    public void userClickOnCheckout() {
        SwagLabsPage.getInstance().clickElement("checkOut","xpath");
    }

    @Then("User fills checkout details")
    public void userFillsCheckoutDetails() {
        SwagLabsPage.getInstance().enterText("firstName","id","Naveen");
        SwagLabsPage.getInstance().enterText("lastname","id","Kumar");
        SwagLabsPage.getInstance().enterText("zip","id","641001");
    }

    @When("User click on Continue")
    public void userClickOnContinue() {
        SwagLabsPage.getInstance().clickElement("continue","xpath");
    }

    @Then("User Verify Item name in checkout page")
    public void userVerifyItemNameInCheckoutPage() {
        String title = SwagLabsPage.getInstance().getElementText("itemNameInCart","xpath");
        String validate = sharedState.getSharedData();

        Assert.assertEquals(title,validate);
    }

    @When("User click on finish")
    public void userClickOnFinish() {
        SwagLabsPage.getInstance().clickElement("finish","xpath");
    }

    @Then("User verify the confirmation page")
    public void userVerifyTheConfirmationPage() {
        String title = SwagLabsPage.getInstance().getElementText("thankYou","xpath");
        String validate = "THANK YOU FOR YOUR ORDER";

        Assert.assertEquals(title,validate);
    }
}
