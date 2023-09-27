package org.letsKode;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.SQLOutput;

public class RadioButtonExample {

    public static void main(String arg[]) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.letskodeit.com/practice");
        driver.manage().window().maximize();
        // Assert URL
        String url = driver.getCurrentUrl();
        Assert.assertEquals("https://www.letskodeit.com/practice", url);
        System.out.println("Url is as expected");
        // Assert Page Title
        String title = driver.getTitle();
        System.out.println("The title is " + title);
        if (title.endsWith("practice")) {
            System.out.println("Title is curract");
        } else {
            System.out.println("Title is wrong");
        }
        Assert.assertThat("the verify title is " + title, Matchers.endsWith("Page"));
        System.out.println("Titile is as expected ");

        //RadioButton
        WebElement BMW = driver.findElement(By.xpath("//input[@id='bmwradio']"));
        BMW.click();
        WebElement Benz = driver.findElement(By.xpath("//input[@id='benzradio']"));
        Benz.click();
        WebElement Honda = driver.findElement(By.xpath("//input[@id='hondaradio']"));
        Honda.click();

        //Assert BMW
        if (Honda.isSelected()) {
            System.out.println("Test pass");
        } else {
            System.out.println("Test fail");
        }

        driver.close();
    }
}
