package basic.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

public class DropdownTest {
    static WebDriver driver;
    @Test
    public void testDropdown() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://www.spicejet.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        Select select = new Select(driver.findElement(By.xpath("//*[@id=\"ctl00_mainContent_DropDownListCurrency\"]")));
        select.selectByValue("BDT");
        Thread.sleep(1000);
        select.selectByIndex(3);
        Thread.sleep(1000);
        select.selectByVisibleText("USD");
        Thread.sleep(1000);











        driver.quit();

    }

}
