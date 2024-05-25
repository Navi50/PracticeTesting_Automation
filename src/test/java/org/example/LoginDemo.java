package org.example;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginDemo {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/v1/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
        System.out.println(driver.getTitle());

        driver.findElement(By.name("user-name")).sendKeys("standard_user");

        WebElement passwordElement = driver.findElement(By.id("password"));
        passwordElement.sendKeys("secret_sauce");

        driver.findElement(By.id("login-button")).click();

        Thread.sleep(2000);

        WebElement verifyTitle = driver.findElement(By.className("product_label"));
        verifyTitle.isDisplayed();
        System.out.println("Title is verified");

        driver.close();
        driver.quit();
    }

}
