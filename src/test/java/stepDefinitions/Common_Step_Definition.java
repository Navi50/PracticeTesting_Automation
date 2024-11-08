package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
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

    @AfterStep
    public void attachScreenshot(Scenario scenario){
        byte[] screenshotTaken = ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BYTES);
        if(scenario.isFailed()){
            scenario.attach(screenshotTaken,"image/png","Error Screen");
        }else {
            scenario.attach(screenshotTaken,"image/png","Screen after the step");
        }
    }

    @After
    public void afterall(){
        DriverManager.quitDriver();
    }
}
