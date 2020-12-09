package basic.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class DropdownAndCheckboxTest {
    static WebDriver driver;
    @Test
    public void testUpdatedDropdown() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.findElement(By.id("divpaxinfo")).click();
        int i=1;
        while (i<5) {
            driver.findElement(By.id("hrefIncAdt")).click();
            i++;
        }
        driver.findElement(By.id("btnclosepaxoption")).click();
        Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(),"5 Adult");
        Thread.sleep(1000);
        boolean selected = driver.findElement(By.xpath("//input[contains(@id,'friendsandfamily')]")).isSelected();
        Assert.assertFalse(selected);
        driver.findElement(By.xpath("//input[contains(@id,'friendsandfamily')]")).click();
        boolean select = driver.findElement(By.xpath("//input[contains(@id,'friendsandfamily')]")).isSelected();
        Assert.assertTrue(select);
        int size = driver.findElements(By.xpath("//input[@type='checkbox']")).size();
        Assert.assertEquals(size,6);

        Thread.sleep(1000);



        driver.quit();
    }

}

