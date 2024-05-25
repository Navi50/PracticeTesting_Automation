package org.example;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LocatorsDemo {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/v1/");
        driver.manage().window().maximize();

        //Using name locator
        driver.findElement(By.name("user-name")).sendKeys("standard_user");

        //Using id locator and WebElement class to store it
        WebElement passwordElement = driver.findElement(By.id("password"));
        passwordElement.sendKeys("secret_sauce");

        //Using className locator
        driver.findElement(By.className("btn_action")).click();
        Thread.sleep(2000);

        //Using cssSelector locator -> tag class----> tag.className
        List<WebElement> addToCart = driver.findElements(By.cssSelector("button.btn_primary"));
        addToCart.get(0).click();
        addToCart.get(1).click();
        addToCart.get(3).click();

        driver.findElement(By.cssSelector("select.product_sort_container")).click();

        //Using cssSelector locator -> tag attribute--> tag[attribute='value']
        driver.findElement(By.cssSelector("option[value='za']")).click();

        //Using cssSelector locator -> tag id----> tag#id
        driver.findElement(By.cssSelector("div#shopping_cart_container")).click();

        //Using linkText locator
        driver.findElement(By.linkText("CHECKOUT")).click();

        //Using id locator
        driver.findElement(By.id("first-name")).sendKeys("abc");
        driver.findElement(By.id("last-name")).sendKeys("xyz");
        driver.findElement(By.id("postal-code")).sendKeys("123");


        //Using cssSelector locator -> tag class attribute----> tag.className[attribute='value']
        driver.findElement(By.cssSelector("input.btn_primary[type='submit']")).click();

        //Using partiallinkText locator
        driver.findElement(By.partialLinkText("FINIS")).click();
        driver.close();
        driver.quit();
    }

}
