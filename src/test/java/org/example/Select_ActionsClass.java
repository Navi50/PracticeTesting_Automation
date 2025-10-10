package org.example;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Select_ActionsClass {

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

        WebElement verifyTitle = driver.findElement(By.className("product_label"));
        verifyTitle.isDisplayed();

        WebElement dd = driver.findElement(By.xpath("//*[@class='product_sort_container']"));
        Select select = new Select(dd);
        List<WebElement> options = select.getOptions();

        for(WebElement o : options){
            System.out.println(o.getText());
        }

        select.selectByValue("za");
        Thread.sleep(2000);
        select.selectByVisibleText("Price (low to high)");
        Thread.sleep(2000);
        select.selectByIndex(0);
        Thread.sleep(2000);

        System.out.println("Title is verified");

        driver.navigate().back();
        driver.navigate().forward();

        driver.close();
        driver.quit();
    }

}
