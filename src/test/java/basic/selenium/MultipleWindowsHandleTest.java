package basic.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class MultipleWindowsHandleTest {
    static WebDriver driver;

    @Test
    public void testMultipleWindows() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://accounts.google.com/signup/v2/webcreateaccount?hl=en&flowName=GlifWebSignIn&flowEntry=SignUp");
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.findElement(By.linkText("Help")).click();
        System.out.println(driver.getTitle());
        Set<String> ids = driver.getWindowHandles();
        Iterator<String> iterator = ids.iterator();
        String parentId = iterator.next();
        String childId = iterator.next();
        driver.switchTo().window(childId);
        System.out.println(driver.getTitle());
        driver.switchTo().window(parentId);
        System.out.println(driver.getTitle());
        driver.quit();
    }
}
