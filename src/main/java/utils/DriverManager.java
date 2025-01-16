package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;


import java.util.concurrent.TimeUnit;

public class DriverManager {
    private static WebDriver driver = null;

    public static void launchDriver(){
        switch (Constants.BROWSER){
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;

            case "edge":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


    }

    public  static void quitDriver(){
        if(driver != null){
            driver.quit();
            driver = null;
        }
    }

    public static WebDriver getDriver(){
        return driver;
    }

}
