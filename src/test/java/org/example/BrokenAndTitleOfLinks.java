package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;

public class BrokenAndTitleOfLinks {

    public static void main(String[] args) throws InterruptedException, IOException {
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

        checkBrokenLinks(driver);
        printTitleOfLinks(driver);

        driver.close();
        driver.quit();
    }

    public static void checkBrokenLinks(WebDriver driver) throws IOException {
        List<WebElement> links = driver.findElements(By.tagName("a"));

        for (WebElement link:links){
            String url = link.getAttribute("href");
            if (url!=null && !url.isEmpty()){
                try{
                    URL linkURL = new URL(url);
                    HttpURLConnection connection = (HttpURLConnection)linkURL.openConnection();
                    connection.setRequestMethod("HEAD");
                    connection.connect();

                    int responseCode = connection.getResponseCode();

                    if (responseCode>=400){
                        System.out.println("Broken Link: "+url+"(Response Code: "+responseCode+")");
                    }else{
                        System.out.println("Valid Link: "+url+"(Response Code: "+responseCode+")");
                    }
                }catch (Exception e){
                    System.out.println("Error checking link: " + url + " - " + e.getMessage());
                }

            } else {
                System.out.println("Empty or null URL for link: " + link.getText());
            }
        }
    }

    public static void printTitleOfLinks(WebDriver driver){
        List<WebElement> titleLinks = driver.findElements(By.tagName("a"));

        for(WebElement link:titleLinks){
            String title = link.getAttribute("title");
            if (title!=null && !title.isEmpty()){
                System.out.println("Title of Link: "+title);
            }else{
                System.out.println("No Title for this link");
            }
        }
    }
}
