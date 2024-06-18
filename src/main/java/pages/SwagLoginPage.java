package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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


    @FindBy(name = "user-name")
    public WebElement username;

    @FindBy(id = "password")
    public WebElement password;

    @FindBy(id = "login-button")
    public WebElement login;

    public void enterUsername(){
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
