package org.example;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DynamicXpath {

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

        try{
            Alert alert = driver.switchTo().alert();
            alert.accept();
        }catch(Exception e){
        }


        // Dynamic Xpath
        // @class='product_label
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        WebElement pageTitle = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@class='product_label']"))));
        pageTitle.isDisplayed();


        // Using AND operater and text()
        // @class='inventory_item_name' and text()='Sauce Labs Backpack
        WebElement product1 = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@class='inventory_item_name' and text()='Sauce Labs Backpack']"))));
        product1.click();

        // Using Contains() and text()
        // contains(text(),'ADD')
        WebElement addToCart = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//button[contains(text(),'ADD')]"))));
        addToCart.click();

        // Using Following/Tag inside one tag
        // [@class='inventory_details']//button[contains(text(), 'Back')]
        WebElement back = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@class='inventory_details']//button[contains(text(), 'Back')]"))));
        back.click();

        // Using Start-with
        // [starts-with(@id, 'shopping')]
        WebElement cart = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[starts-with(@id, 'shopping')]"))));
        cart.click();


        driver.close();

    }


}
