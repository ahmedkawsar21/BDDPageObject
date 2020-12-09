package basic.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TableExerciseTest {
    static WebDriver driver;
    @Test
    public void testTableGrid() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://www.cricbuzz.com/live-cricket-scorecard/32142/rjshi-vs-ctgrm-10th-match-bangabandhu-t20-cup-2020");
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        WebElement table = driver.findElement(By.cssSelector("div[class='cb-col cb-col-100 cb-ltst-wgt-hdr']"));
        //int rowCount = table.findElements(By.cssSelector("div[class='cb-col cb-col-100 cb-scrd-itms")).size();
        //System.out.println(rowCount);
        int sum = 0;
        int count = table.findElements(By.cssSelector("div[class='cb-col cb-col-100 cb-scrd-itms'] div:nth-child(3)")).size();
        for (int i=0; i<count-2; i++) {
            String run = table.findElements(By.cssSelector("div[class='cb-col cb-col-100 cb-scrd-itms'] div:nth-child(3)")).get(i).getText();
            int value = Integer.parseInt(run);
            sum = sum + value;
        }
        String text = table.findElement(By.xpath("//div[text()='Extras']/following-sibling::div")).getText();
        int extras = Integer.parseInt(text);
        int total = sum +extras;
        String text1 = table.findElement(By.xpath("//div[text()='Total']/following-sibling::div")).getText();
        int actualTotal = Integer.parseInt(text1);
        Assert.assertEquals(total,actualTotal);
        driver.quit();

    }

}
