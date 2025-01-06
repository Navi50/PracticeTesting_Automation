package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
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

    public void changeSort(String sort){
        WebElement sortElement = CommonUtils.getElement(page,"xpath","sort","clickable");
        Select select = new Select(sortElement);
        select.selectByVisibleText(sort);
    }

    public void clickOnFirstItem(){
        CommonUtils.getElement(page,"xpath","item1","nowait").click();
    }
}
