package junit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.hamcrest.Matchers;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class JunitExample {
    // decler driver as variable globally
    WebDriver driver;

    @Before
    public void openBrowser() {
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        driver.get("https://www.letskodeit.com/practice");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void radio() {
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
    }

    @Test
    public void checkBox() {
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
    }

    @Test
    public void select() throws InterruptedException {
        WebElement box = driver.findElement(By.xpath("//select[@id='carselect']"));
        Select sel = new Select(box);
        sel.selectByIndex(2);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        sel.selectByVisibleText("Benz");
        Thread.sleep(5000);

        sel.selectByValue("honda");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        List<WebElement> option = sel.getOptions();
        int boxsize = option.size();
        System.out.println(" Box size is " + boxsize);
        //Assertion
        Assert.assertThat(boxsize, Matchers.is(3));
        //print text contain in select box
        for (int i = 0; i < boxsize; i++) {
            String boxName = option.get(i).getText();
            System.out.println("the name are " + boxName);
        }
    }

    @Test
    public void Alert() throws InterruptedException {
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
    }

    @Test
    public void multi(){
        WebElement multiselcect = driver.findElement(By.id("multiple-select-example"));
        Select select = new Select(multiselcect);
        select.selectByIndex(2);
        select.deselectByVisibleText("Peach");
        select.selectByValue("apple");
        select.deselectByVisibleText("Orange");
        select.deselectAll();
        // box size
        List<WebElement>option = select.getOptions();
        int boxsize = option.size();
        System.out.println(" box size is "+ boxsize);
        for(int i=0;i<boxsize;i++){
            String boxname = option.get(i).getText();
            System.out.println("the name are "+ boxname);
        }

    }
    @After
    public void teaDown() {
        driver.close();
    }
}
