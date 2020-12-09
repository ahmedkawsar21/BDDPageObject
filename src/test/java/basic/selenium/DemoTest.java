package basic.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class DemoTest {
    static WebDriver driver;
    @Test
    public void testLocators() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://www.facebook.com");
        driver.manage().window().maximize();
        driver.findElement(By.id("email")).sendKeys("this is email");
        Thread.sleep(2000);
        driver.findElement(By.name("pass")).sendKeys("234980");
        Thread.sleep(200);
        driver.findElement(By.linkText("Forgot Password?")).click();







        driver.quit();

    }



}
