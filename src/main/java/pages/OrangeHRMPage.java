package pages;

import org.openqa.selenium.WebElement;
import utils.CommonUtils;

public class OrangeHRMPage {
    public static OrangeHRMPage orangeHRMPage;

    private OrangeHRMPage(){

    }

    public static OrangeHRMPage getInstance(){
        if(orangeHRMPage == null){
            orangeHRMPage = new OrangeHRMPage();
        }
        return orangeHRMPage;
    }
    static String page = "OrangeHRM";

    public void enterText(String element, String elementType, String text){
        WebElement username = CommonUtils.getElement(page,elementType,element,"clickable");
        username.clear();
        username.sendKeys(text);
    }

    public void clickElement(String element, String elementType){
        CommonUtils.getElement(page,elementType,element,"clickable").click();
    }
}
