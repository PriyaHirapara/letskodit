package org.letsKode;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertExample {
    public static void main(String arg[]) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.letskodeit.com/practice");
        driver.manage().window().maximize();

        WebElement fieldInput = driver.findElement(By.cssSelector("div[id='alert-example-div'] fieldset input:nth-child(2)"));
        fieldInput.sendKeys("pet");

        WebElement aleartButton = driver.findElement(By.xpath("//input[@id='alertbtn']"));
        aleartButton.click();
        Alert popup = driver.switchTo().alert();
        Thread.sleep(5000);

        popup.accept();

        WebElement confirmInput = driver.findElement(By.cssSelector("div[id='alert-example-div'] fieldset input:nth-child(2)"));
        confirmInput.sendKeys("swami");

        WebElement confirmButton = driver.findElement(By.xpath("//input[@id='confirmbtn']"));
        confirmButton.click();
        Alert confirmPopup = driver.switchTo().alert();
        popup.accept();
        Thread.sleep(5000);
        driver.close();
    }
}