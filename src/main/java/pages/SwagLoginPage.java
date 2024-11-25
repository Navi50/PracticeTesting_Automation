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


    public WebElement getElement(String eleType, String element, String waitFor){
        WebElement locator =null;
        Map<String, String> loginLocators;
        switch (eleType){
            case "name":
                loginLocators = CommonUtils.getLocators("Loginpage","name",waitFor);
                locator = driver.findElement(By.name(loginLocators.get(element)));
                break;
            case "id":
                loginLocators = CommonUtils.getLocators("Loginpage","id",waitFor);
                locator = driver.findElement(By.id(loginLocators.get(element)));
                break;
            case "xpath":
                loginLocators = CommonUtils.getLocators("Loginpage","xpath",waitFor);
                locator = driver.findElement(By.xpath(loginLocators.get(element)));
                break;
        }

        return locator;
    }

    public void enterUsername(){
        WebElement username = getElement("name","username","visible");
        CommonUtils.waitForElement("visible",username);
        username.clear();
        username.sendKeys("standard_user");
    }

    public void enterPassword(){
        WebElement password = getElement("name","password","visible");
        CommonUtils.waitForElement("visible",password);
        password.clear();
        password.sendKeys("secret_sauce");
    }

    public void clickLogin(){
        WebElement login = getElement("id","login","visible");
        CommonUtils.waitForElement("clickable",login);
        login.click();
    }
}
