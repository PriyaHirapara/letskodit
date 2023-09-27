package org.letsKode;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class SelectExample {
    public static void main(String arg[]) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.letskodeit.com/practice");
        driver.manage().window().maximize();

        //select class
        WebElement box =driver.findElement(By.xpath("//select[@id='carselect']"));
        Select sel = new Select(box);
        sel.selectByIndex(2);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        sel.selectByVisibleText("Benz");
        Thread.sleep(5000);

        sel.selectByValue("honda");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        List<WebElement>option = sel.getOptions();
       int boxsize = option.size();
        System.out.println(" Box size is " + boxsize);
        //Assertion
        Assert.assertThat(boxsize,Matchers.is(3));
        //print text contain in select box
        for(int i=0;i<boxsize;i++) {
            String boxName = option.get(i).getText();
            System.out.println("the name are " + boxName);
        }
        driver.close();
    }
    }
