package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseApi {
    public static WebDriver driver;
    @BeforeMethod
            public void setUp() throws IOException {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        driver = new ChromeDriver();
        driver.get(getGlobalProperties("amazonUrl"));
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

    }
    public String getGlobalProperties(String key) throws IOException {
        Properties prop = new Properties();
        FileInputStream files = new FileInputStream("src/main/resources/global.Properties");
        prop.load(files);
        return prop.getProperty(key);
    }
    public void webDriverWait(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.visibilityOf(element));
    }
    @AfterMethod
    public void tearUp() {
        driver.quit();
    }

}
