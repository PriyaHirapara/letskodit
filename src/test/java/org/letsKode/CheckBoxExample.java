package org.letsKode;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class CheckBoxExample {
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
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        //checkbox
        WebElement BMWCheckBox = driver.findElement(By.xpath("//input[@id='bmwcheck']"));
        BMWCheckBox.click();
        WebElement BenzCheckBox = driver.findElement(By.xpath("//input[@id='benzcheck']"));
        BenzCheckBox.click();
        WebElement HondaCheckBox = driver.findElement(By.xpath("//input[@id='hondacheck']"));
        HondaCheckBox.click();

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        //Assert BMW
        if (HondaCheckBox.isSelected()) {
            System.out.println("Test pass");
        } else {
            System.out.println("Test fail");
        }

        driver.close();
    }
}
