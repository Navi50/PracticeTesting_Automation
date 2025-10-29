package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;
import java.util.Set;

public class TableAutomation {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://tablepress.org/demo/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        System.out.println(driver.getTitle());

//         WebElement table = driver.findElement(By.id("tablepress-demo-premium"));
//        List<WebElement> rows = table.findElements(By.tagName("tr"));
//
//        WebElement cellValue = rows.get(2).findElements(By.tagName("td")).get(2);
//        System.out.println(cellValue.getText());
//
//        for (WebElement row : rows) {
//           List<WebElement> cells = row.findElements(By.tagName("td"));
//           for (WebElement cell : cells){
//               //System.out.println(cell.getText());
//           }
//        }
        //driver.close();

        swithWindow(3, driver);

    }

    public static void swithWindow(int i, WebDriver driver) throws InterruptedException {
        driver.get("https://opensource-demo.orangehrmlive.com/");
        System.out.println(driver.getTitle());
        driver.findElement(By.name("username")).sendKeys("admin");

        WebElement passwordElement = driver.findElement(By.name("password"));
        passwordElement.sendKeys("admin123");

        driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@Class='orangehrm-upgrade-link']")).click();
        driver.findElement(By.xpath("//*[@Class='orangehrm-upgrade-link']")).click();
        driver.findElement(By.xpath("//*[@Class='orangehrm-upgrade-link']")).click();
        driver.findElement(By.xpath("//*[@Class='orangehrm-upgrade-link']")).click();
        String mainWindow = driver.getWindowHandle();
        Set<String> windows = driver.getWindowHandles();
        String[] windowList = windows.toArray(new String[0]);

        if (windowList.length>=4){
            driver.switchTo().window(windowList[3]);
            driver.findElement(By.xpath("//a[text()='Book a Free Demo']")).click();
        }
    }

}
