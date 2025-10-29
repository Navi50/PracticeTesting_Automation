package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.*;

public class Sort_IntParse {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.amazon.in/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("Laptops");
        driver.findElement(By.xpath("//input[starts-with(@id, 'nav') and @value='Go']")).click();

        Select select = new Select(driver.findElement(By.name("s")));
        select.selectByValue("price-asc-rank");
        Thread.sleep(3000);

        List<WebElement> ratesElement = driver.findElements(By.xpath("//*[@class='a-section']//span[@class='a-price-whole']"));
        List<Integer> ratesOfProduct = new ArrayList<>();
        for(WebElement rates : ratesElement){
            String rate = rates.getText().replaceAll("[^0-9]","");
            System.out.println(rate);
            int temp = Integer.parseInt(rate);

            ratesOfProduct.add(temp);
        }

        List<Integer> sortedRates = new ArrayList<>(ratesOfProduct);
        Collections.sort(ratesOfProduct);

        if(!ratesOfProduct.equals(sortedRates)){
                System.out.println("The Sorting is wrong");
        }
        System.out.println(ratesOfProduct);
        System.out.println(sortedRates);


        driver.close();

    }
}
