package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Unit test for simple App.
 */
public class ScreenShotDemo {

    public static void main(String[] args) throws IOException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        Map<String,String> locators = new HashMap();
        locators.put("username","user-name");
        locators.put("password","password");

        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/v1/");

        WebElement username = driver.findElement(By.id(locators.get("username")));
        WebElement password = driver.findElement(By.id(locators.get("password")));

        username.sendKeys("standard_user");
        password.sendKeys("secret_sauce");

        driver.findElement(By.id("login-button")).click();

        File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        File location = new File("D:\\Learning\\Screenshot\\Screenshot.png");
        FileUtils.copyFile(file,location);
        driver.close();
        driver.quit();
    }


}
