package org.example;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class loginTestNGDemo {

    WebDriver driver;

    @BeforeClass
    public void beforeclass() {
        System.out.println("Before Class");
        driver =  new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
    }

    @AfterClass
    public void afterclass() {
        System.out.println("After Class");
		driver.close();
		driver.quit();
    }

    @BeforeSuite
    public void beforesuite() {
        System.out.println("Before Suite");
    }

    @AfterSuite
    public void aftersuite() {
        System.out.println("After Suite");

    }

    @BeforeTest
    public void beforetest() {
        System.out.println("Before Test");
    }

    @AfterTest
    public void aftertest() {
        System.out.println("After Test");

    }


    @BeforeMethod
    public void beforemethod() {
        System.out.println("Before Method");
    }

    @AfterMethod
    public void aftermethod() {
        System.out.println("After Method");

    }

    @BeforeGroups
    public void beforegroups() {
        System.out.println("Before Groups");
    }

    @AfterGroups
    public void aftergroups() {
        System.out.println("After Groups");

    }

    @Test
    public void test() throws InterruptedException {

        System.out.println("Test");
        driver.get("https://www.saucedemo.com/v1/");
        System.out.println(driver.getTitle());

        driver.findElement(By.name("user-name")).sendKeys("standard_user");

        WebElement passwordElement = driver.findElement(By.id("password"));
        passwordElement.sendKeys("secret_sauce");

        driver.findElement(By.id("login-button")).click();

        Thread.sleep(2000);

        WebElement verifyTitle = driver.findElement(By.className("product_label"));
        verifyTitle.isDisplayed();
        System.out.println("Title is verified");
    }
}


