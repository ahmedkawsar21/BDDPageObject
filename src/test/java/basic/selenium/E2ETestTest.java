package basic.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class E2ETestTest {
    static WebDriver driver;
    @Test
    public void EndToEnd() throws InterruptedException {
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
        driver.findElement(By.xpath("//*[@id=\"ctl00_mainContent_ddl_originStation1_CTXT\"]")).click();
        Thread.sleep(1000);
        if (driver.findElement(By.cssSelector("div[id='Div1']")).getAttribute("style").contains("0.5")) {
            System.out.println("is disabled");
            Assert.assertTrue(true);
        }else {
            Assert.assertTrue(false);
        }
        driver.findElement(By.id("divpaxinfo")).click();
        driver.findElement(By.xpath("//input[contains(@id,'friendsandfamily')]")).click();
        boolean selected = driver.findElement(By.xpath("//input[contains(@id,'friendsandfamily')]")).isSelected();
        Assert.assertTrue(selected);
        Select s = new Select(driver.findElement(By.xpath("//select[@id='ctl00_mainContent_ddl_Adult']")));
        s.selectByIndex(4);
        Select select = new Select(driver.findElement(By.xpath("//*[@id=\"ctl00_mainContent_DropDownListCurrency\"]")));
        select.selectByVisibleText("USD");
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("input[id='ctl00_mainContent_btn_FindFlights']")).click();
        Thread.sleep(2000);

        driver.quit();
    }
}
