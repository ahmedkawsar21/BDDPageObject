package basic.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;


public class Popup {
    static WebDriver driver;
    @Test
    public void testMultipleWindows() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
        driver.manage().window().maximize();
        //driver.findElement(By.linkText("Basic Auth")).click();
        Thread.sleep(2000);
        driver.quit();



}

}
