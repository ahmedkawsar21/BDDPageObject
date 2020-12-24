package base;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseApi {
    public static WebDriver driver;
    @BeforeMethod
    public void setUp() throws IOException {
        String browserName = getGlobalProperties("browser");
        if (browserName.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
            driver = new ChromeDriver();
        }else if (browserName.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver");
            driver = new FirefoxDriver();
        }
        driver.get(getGlobalProperties("qaUrl"));
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().deleteAllCookies();
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
    public String getScreenShotPath(String testName) throws IOException {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        String destinationFile = System.getProperty("user.dir") + "/reports/" + testName + ".png";
        FileUtils.copyFile(source,new File(destinationFile));
        return destinationFile;

    }

    @AfterMethod
    public void tearUp() {
        driver.quit();
    }

}
