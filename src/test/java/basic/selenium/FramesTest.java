package basic.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class FramesTest {
    static WebDriver driver;
    @Test
    public void testFrames() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://jqueryui.com/droppable/");
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.switchTo().frame(0);
        WebElement source = driver.findElement(By.cssSelector("div[id='draggable']"));
        WebElement target = driver.findElement(By.cssSelector("div[id='droppable']"));
        Actions action = new Actions(driver);
        action.dragAndDrop(source,target).build().perform();
        driver.switchTo().defaultContent();
        Thread.sleep(2000);




        driver.quit();
    }
}
