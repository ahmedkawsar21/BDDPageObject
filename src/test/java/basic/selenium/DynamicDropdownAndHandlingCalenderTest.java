package basic.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class DynamicDropdownAndHandlingCalenderTest {
    static WebDriver driver;
    @Test
    public void testDynamicDropdown() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://www.spicejet.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//*[@id=\"ctl00_mainContent_ddl_originStation1_CTXT\"]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@id='ctl00_mainContent_ddl_originStation1_CTNR']//a[@value='HYD']")).click();
        driver.findElement(By.xpath("//div[@id='ctl00_mainContent_ddl_destinationStation1_CTNR']//a[@value='DEL']")).click();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight.ui-state-active")).click();
        Thread.sleep(1000);
        System.out.println(driver.findElement(By.cssSelector("div[id='Div1']")).getAttribute("style"));
        driver.findElement(By.cssSelector("input[id='ctl00_mainContent_rbtnl_Trip_1']")).click();
        System.out.println(driver.findElement(By.cssSelector("div[id='Div1']")).getAttribute("style"));
        if (driver.findElement(By.cssSelector("div[id='Div1']")).getAttribute("style").contains("1")) {
            System.out.println("is enabled");
            Assert.assertTrue(true);
        }else {
            Assert.assertTrue(false);

        }



        driver.quit();
    }
}
