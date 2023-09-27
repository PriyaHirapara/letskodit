package org.letsKode;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class ChromeTest {
    public static void main(String args[]) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.letskodeit.com/practice");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        String url = driver.getCurrentUrl();
        System.out.println("the url is "+ url);
        if(url.endsWith("/practice")){
            System.out.println("Test Pass");
        }else {
            System.out.println("Test Fail");
        }

        String title = driver.getTitle();
        System.out.println("The title is "+ title);

        Assert.assertEquals("Practice Page",title);
        driver.close();
    }
}