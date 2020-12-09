package basic.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SalesForceTest {
    static WebDriver driver;
    @Test
    public void testLocators() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://login.salesforce.com/");
        driver.manage().window().maximize();
        //driver.findElement(By.id("username")).sendKeys("fghj");
        driver.findElement(By.xpath("//div[@id='usernamegroup']/div/input")).sendKeys("parent xpath");
        driver.findElement(By.name("pw")).sendKeys("09876");
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        String text = driver.findElement(By.cssSelector("[id='error']")).getText();
        Assert.assertEquals("Please check your username and password. If you still can't log in, contact your Salesforce administrator.",text);
        Thread.sleep(2000);








        driver.quit();
    }
}
