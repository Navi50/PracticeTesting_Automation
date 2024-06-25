package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.CommonUtils;
import utils.DriverManager;

import java.util.Map;

public class SwagLoginPage {

    public static SwagLoginPage swagLoginPage;

    private SwagLoginPage(){

    }

    public static SwagLoginPage getInstance(){
        if(swagLoginPage == null){
            swagLoginPage = new SwagLoginPage();
        }
        return swagLoginPage;
    }

    WebDriver driver = DriverManager.getDriver();
    Map<String, String> loginLocators = CommonUtils.getLocators("Loginpage");



    public void enterUsername(){
        WebElement username = driver.findElement(By.name(loginLocators.get("username")));
        username.clear();
        username.sendKeys("standard_user");
    }

    public void enterPassword(){
        WebElement password = driver.findElement(By.name(loginLocators.get("password")));
        password.clear();
        password.sendKeys("secret_sauce");
    }

    public void clickLogin(){
        WebElement login = driver.findElement(By.id(loginLocators.get("login")));
        login.click();
    }
}
