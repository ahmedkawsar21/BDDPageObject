package pages;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import utils.BaseApi;
import utils.Pages;

public class ActionDemo extends BaseApi {
    public Pages pages;
    @BeforeMethod
    public void init() {
        pages= PageFactory.initElements(driver,Pages.class);
    }
    //@Parameters({"amazonUrl"})
    @Test(priority = 1)
    public void mouseHover() {
        Actions action = new Actions(driver);
        action.moveToElement(pages.getSignInMouseHover()).contextClick().build().perform();

    }
    @Test(priority = 2,enabled = true,dataProvider = "")
    public void writeInCaps() throws InterruptedException {
        Actions action = new Actions(driver);
        action.moveToElement(pages.getSearchBox()).click().keyDown(Keys.SHIFT).sendKeys("hello").doubleClick().build().perform();
        Thread.sleep(2000);

    }
}
