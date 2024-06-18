package stepDefinitions;

import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import utils.CommonUtils;
import utils.DriverManager;

import java.io.IOException;

public class Common_Step_Definition {

    public WebDriver driver;

    @Before
    public void beforeScenario() throws IOException {
        try{
            CommonUtils commonUtils = new CommonUtils();
            commonUtils.loadProperties();
            if (driver==null){
                DriverManager.launchDriver();
                commonUtils.iniWebElements();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
