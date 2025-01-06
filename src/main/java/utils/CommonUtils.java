package utils;

import io.cucumber.core.internal.com.fasterxml.jackson.databind.ObjectMapper;

import io.cucumber.java.AfterStep;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.SwagLoginPage;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;

public class CommonUtils {



    public void loadProperties() throws IOException {

        Properties properties = new Properties();

        try {
            properties.load(getClass().getResourceAsStream("/config.properties"));
        } catch (Exception e) {
            e.printStackTrace();
        }

        Constants.BROWSER = properties.getProperty("BROWSER");
        Constants.URL = properties.getProperty("URL");
        Constants.APPLICATION = properties.getProperty("APPLICATION");

    }

    public void iniWebElements() {
        PageFactory.initElements(DriverManager.getDriver(), SwagLoginPage.getInstance());
    }


    public static Map<String, String> getLocators(String page, String eleType){

        ObjectMapper objectMapper = new ObjectMapper();

        try{
            File jsonFile = new File("src/test/resources/Locator.json");
            Map dataMap = objectMapper.readValue(jsonFile, Map.class);
            Map<String, Object> datapage = (Map<String, Object>) dataMap.get(page);
            Map<String, Object> data = (Map<String, Object>) datapage.get(eleType);

            Map<String, String> locators = new HashMap<>();


            for(Map.Entry<String, Object> entry : data.entrySet()){
                locators.put(entry.getKey(), entry.getValue().toString());
            }
            return locators;

        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public static WebElement getElement(String page, String eleType, String element, String waitFor){
        WebDriver driver = DriverManager.getDriver();

        WebElement locator =null;
        Map<String, String> loginLocators;
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(10));

        switch (waitFor){
            case "clickable":
                if (Objects.equals(eleType, "name")){
                    loginLocators = getLocators(page,"name");
                    locator = driver.findElement(By.name(loginLocators.get(element)));
                    wait.until(ExpectedConditions.elementToBeClickable(locator));

                } else if (Objects.equals(eleType,"id")) {
                    loginLocators = getLocators("Loginpage","id");
                    locator = driver.findElement(By.id(loginLocators.get(element)));
                    wait.until(ExpectedConditions.elementToBeClickable(locator));

                } else if (Objects.equals(eleType,"xpath")) {
                    loginLocators = getLocators("Loginpage","xpath");
                    locator = driver.findElement(By.xpath(loginLocators.get(element)));
                    wait.until(ExpectedConditions.elementToBeClickable(locator));
                }
                break;
            case "visible":
                if (Objects.equals(eleType, "name")){
                    loginLocators = getLocators(page,"name");
                    locator = driver.findElement(By.name(loginLocators.get(element)));
                    wait.until(ExpectedConditions.visibilityOf(locator));
                } else if (Objects.equals(eleType,"id")) {
                    loginLocators = getLocators("Loginpage","id");
                    locator = driver.findElement(By.id(loginLocators.get(element)));
                    wait.until(ExpectedConditions.visibilityOf(locator));
                } else if (Objects.equals(eleType,"xpath")) {
                    loginLocators = getLocators("Loginpage","xpath");
                    locator = driver.findElement(By.xpath(loginLocators.get(element)));
                    wait.until(ExpectedConditions.visibilityOf(locator));
                }
                break;
            default:
                if (Objects.equals(eleType, "name")){
                    loginLocators = getLocators(page,"name");
                    locator = driver.findElement(By.name(loginLocators.get(element)));
                } else if (Objects.equals(eleType,"id")) {
                    loginLocators = getLocators("Loginpage","id");
                    locator = driver.findElement(By.id(loginLocators.get(element)));
                } else if (Objects.equals(eleType,"xpath")) {
                    loginLocators = getLocators("Loginpage","xpath");
                    locator = driver.findElement(By.xpath(loginLocators.get(element)));
                }

        }
        return locator;
    }



}
