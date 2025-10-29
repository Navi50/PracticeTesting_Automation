package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utils.CommonUtils;


public class SwagLabsPage {

    public static SwagLabsPage swagLabsPage;

    private SwagLabsPage(){

    }

    public static SwagLabsPage getInstance(){
        if(swagLabsPage == null){
            swagLabsPage = new SwagLabsPage();
        }
        return swagLabsPage;
    }
    static String page = "SWAGLABS";

    public void enterText(String element, String elementType, String text){
        try{
        WebElement username = CommonUtils.getElement(page,elementType,element,"clickable");
        username.clear();
        username.sendKeys(text);
    }catch(Exception e){
        e.printStackTrace();
    }
    }

    public void clickElement(String element, String elementType){
        try{
        CommonUtils.getElement(page,elementType,element,"clickable").click();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void changeSort(String sort){
        try{
        WebElement sortElement = CommonUtils.getElement(page,"xpath","sort","clickable");
        Select select = new Select(sortElement);
        select.selectByVisibleText(sort);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public String getElementText(String element, String elementType){
        try{
        WebElement elementText = CommonUtils.getElement(page,elementType,element,"visible");
        return elementText.getText();
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }


}
