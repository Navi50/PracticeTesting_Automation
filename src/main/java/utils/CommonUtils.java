package utils;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.support.PageFactory;
import pages.SwagLoginPage;

import java.io.FileReader;
import java.io.IOException;
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


    public static JSONObject getLocators() {
        JSONParser parser = new JSONParser();
        try {
            FileReader reader = new FileReader("src/test/resources/Locators.json");
            return (JSONObject) parser.parse(reader);
        } catch (
                Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
