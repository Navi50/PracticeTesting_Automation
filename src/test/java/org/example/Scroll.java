package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class Scroll {
    public static JavascriptExecutor js;
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://www.saucedemo.com/v1/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        System.out.println(driver.getTitle());

        driver.findElement(By.name("user-name")).sendKeys("standard_user");

        WebElement passwordElement = driver.findElement(By.id("password"));
        passwordElement.sendKeys("secret_sauce");

        driver.findElement(By.id("login-button")).click();
        Thread.sleep(2000);

        WebElement product = driver.findElement(By.className("product_label"));
        scrollUsingJSExecutor(driver,product);

        WebElement footerImage = driver.findElement(By.xpath("//img[contains(@class,'footer_robot')]"));
        scrollToDownAndElementUsingActions(driver,footerImage);

        driver.close();
        driver.quit();

    }

    public static void scrollUsingJSExecutor(WebDriver driver, WebElement element) throws InterruptedException {
        js = (JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(0,500)","");
        Thread.sleep(5000);
        js.executeScript("arguments[0].scrollIntoView();",element);
    }


    public static void scrollToDownAndElementUsingActions(WebDriver driver, WebElement element) throws InterruptedException {
        Actions action = new Actions(driver);
        action.scrollToElement(element).perform();
        Thread.sleep(5000);
        action.scrollByAmount(0,-200).perform();
    }
}

