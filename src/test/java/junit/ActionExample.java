package junit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.hamcrest.Matchers;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class ActionExample {
    private WebDriver driver;

    @Before
    public void openBrowser() {
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        driver.get("https://www.letskodeit.com/practice");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void mouseHover() throws InterruptedException {
        WebElement hover = driver.findElement(By.xpath("//button[@id='mousehover']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();",hover);
        Thread.sleep(5000);
        Actions actions = new Actions(driver);
        actions.moveToElement(hover).build().perform();
        WebElement topClick = driver.findElement(By.xpath("//div[@class='mouse-hover-content']/a[1]"));
        topClick.click();
    }

    @After
    public void teaDown() {
        driver.close();
    }
}
