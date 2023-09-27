package junit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.hamcrest.Matchers;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class IframeExample {
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
    public void iFrameExample(){
       WebElement ifraame = driver.findElement(By.xpath("//iframe[@id='courses-iframe']"));
        driver.switchTo().frame(ifraame);
        WebElement searchbox = driver.findElement(By.xpath("//input[@id='search']"));
        searchbox.sendKeys("java");
        WebElement searchicon = driver.findElement(By.xpath("//i[@class='fa fa-search']"));
        searchicon.click();

        List<WebElement> courseName = driver.findElements(By.xpath("//div[@id='zen_all_courses_dynamic']/div[3]/div/div/a/div[2]/h4"));
        int courseSize = courseName.size();                             //div[@id='zen_all_courses_dynamic']/div[3]/div[1]/div/a/div[2]/h4
        System.out.println(" the size is "+ courseSize);

        Assert.assertThat(courseSize, Matchers.is(6));

        for(int i=0;i<courseSize;i++){
          String boxname = courseName.get(i).getText();
            System.out.println("The name are "+ boxname);
        }

    }


    @After
    public void teaDown() {
        driver.close();
    }
}
