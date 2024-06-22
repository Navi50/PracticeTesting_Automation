package pages;

import org.json.simple.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.CommonUtils;
import utils.DriverManager;

public class SwagLoginPage {

    public static SwagLoginPage swagLoginPage;

    private SwagLoginPage(){

    }
    WebDriver driver = DriverManager.getDriver();

    JSONObject locators = CommonUtils.getLocators();
    JSONObject loginPage;

    {
        assert locators != null;
        loginPage = (JSONObject) locators.get("Loginpage");
    }

    public static SwagLoginPage getInstance(){
        if(swagLoginPage == null){
            swagLoginPage = new SwagLoginPage();
        }
        return swagLoginPage;
    }


//    @FindBy(name = "user-name")
//    public WebElement username;

    @FindBy(id = "password")
    public WebElement password;

    @FindBy(id = "login-button")
    public WebElement login;

    public void enterUsername(){
        WebElement username = driver.findElement(By.name((String) loginPage.get("username")));
        username.clear();
        username.sendKeys("standard_user");
    }

    public void enterPassword(){
        password.clear();
        password.sendKeys("secret_sauce");
    }

    public void clickLogin(){
        login.click();
    }
}
