package basic.selenium;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class JavaScriptExecutorTest {
    static WebDriver driver;
    @Test
    public void javaScriptExecutor() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        driver = new ChromeDriver();
        driver.get("https:www.ksrtc.in");
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.findElement(By.id("fromPlaceName")).sendKeys("Beng");
        Thread.sleep(2000);
        driver.findElement(By.id("fromPlaceName")).sendKeys(Keys.DOWN);
        //driver.findElement(By.id("fromPlaceName")).sendKeys(Keys.ENTER);
//        String text = driver.findElement(By.id("fromPlaceName")).getText();
//        System.out.println(text);
        String s = "return document.getElementById(\"fromPlaceName\").value;";
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String text1 = (String) js.executeScript(s);
        System.out.println(text1);
        int i=0;
        while (!text1.equalsIgnoreCase("BENGALURU NTERNATION AIRPORT")){
            driver.findElement(By.id("fromPlaceName")).sendKeys(Keys.DOWN);
            i++;
            text1 = (String) js.executeScript(s);
            System.out.println(text1);
            if (i>10) {
                break;
            }
        }
        if (i>10) {
            System.out.println("not Found");
        }else {
            System.out.println("found");
        }



        driver.quit();
    }
}
