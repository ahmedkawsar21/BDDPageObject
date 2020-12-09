package basic.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class LinksTest {
        static WebDriver driver;
        @Test
        public void testScope() throws InterruptedException {
            System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
            driver = new ChromeDriver();
            driver.get("https://rahulshettyacademy.com/AutomationPractice/");
            driver.manage().window().maximize();
            driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            System.out.println(driver.findElements(By.tagName("a")).size());
            //find total links on footer
            WebElement footer = driver.findElement(By.id("gf-BIG"));
            int a = footer.findElements(By.tagName("a")).size();
            System.out.println(a);
            //find total links on a column
            WebElement column = footer.findElement(By.xpath("//div/table//tbody/tr/td[1]/ul"));
            int a1 = column.findElements(By.tagName("a")).size();
            System.out.println(a1);
            //click all the links in different tab
            for (int i=1; i<a1; i++) {
                String clickOnTab = Keys.chord(Keys.COMMAND, Keys.ENTER);
                column.findElements(By.tagName("a")).get(i).sendKeys(clickOnTab);

                }
            Set<String> ids = driver.getWindowHandles();
            Iterator<String> iterator = ids.iterator();
            while (iterator.hasNext()) {
                String windows = iterator.next();
                driver.switchTo().window(windows);
                String titles = driver.getTitle();
                if (titles.equalsIgnoreCase("Apache JMeter - Apache JMeter™")) {
                    Assert.assertEquals(titles,"Apache JMeter - Apache JMeter™");
                }
                System.out.println(driver.getTitle());
            }





            Thread.sleep(2000);
            driver.quit();
        }
}

