package basic.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class AutoSuggestionDropdownTest {
    static WebDriver driver;
    @Test
    public void testAutoSuggestionDropdown() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.findElement(By.id("autosuggest")).sendKeys("ja");
        List<WebElement> elements = driver.findElements(By.xpath("//ul[@id='ui-id-1']//a"));
        for (WebElement element : elements) {
            if (element.getText().equalsIgnoreCase("japan")) {
                element.click();
                break;
            }
        }
        Thread.sleep(1000);


        driver.quit();
    }
}
