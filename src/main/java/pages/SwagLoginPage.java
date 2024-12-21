package pages;

import org.openqa.selenium.WebElement;
import utils.CommonUtils;


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
    static String page = "Loginpage";

    public void enterUsername(){
        WebElement username = CommonUtils.getElement(page,"name","username","visible");
        username.clear();
        username.sendKeys("standard_user");
    }

    public void enterPassword(){
        WebElement password = CommonUtils.getElement(page,"name","password","visible");
        password.clear();
        password.sendKeys("secret_sauce");
    }

    public void clickLogin(){
        WebElement login = CommonUtils.getElement(page,"id","login","clickable");
        login.click();
    }
}
