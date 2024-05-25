package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.DriverManager;
import java.util.HashMap;
import java.util.Map;

/**
 * Unit test for simple App.
 */
public class AppTest {

    public static void main(String[] args) {

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
    }
}
