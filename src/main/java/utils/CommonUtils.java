package utils;

import io.cucumber.core.internal.com.fasterxml.jackson.databind.ObjectMapper;

import org.openqa.selenium.support.PageFactory;
import pages.SwagLoginPage;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
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

    }

    public void iniWebElements() {
        PageFactory.initElements(DriverManager.getDriver(), SwagLoginPage.getInstance());
    }


    public static Map<String, String> getLocators(String page, String eleType){

        ObjectMapper objectMapper = new ObjectMapper();

        try{
            File jsonFile = new File("src/test/resources/Locator.json");
            Map<String, Object> dataMap = objectMapper.readValue(jsonFile, Map.class);
            Map<String, Object> datapage = (Map<String, Object>) dataMap.get(page);
            Map<String, Object> data = (Map<String, Object>) datapage.get(eleType);

            Map<String, String> locator = new HashMap<>();

            for(Map.Entry<String, Object> entry : data.entrySet()){
                locator.put(entry.getKey(), entry.getValue().toString());
            }

            return locator;

        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
