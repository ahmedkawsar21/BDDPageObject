package pages.test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import base.BaseApi;
import page.pages.Pages;

public class ActionDemo extends BaseApi {
    @Test(priority = 1)
    public void mouseHover() {
        Pages pages = new Pages();
        Actions action = new Actions(driver);
        action.moveToElement(pages.getSignInMouseHover()).contextClick().build().perform();
    }

    @Test(priority = 2,enabled = true,dataProvider = "")
    public void writeInCaps() throws InterruptedException {
        Pages pages = new Pages();
        Actions action = new Actions(driver);
        action.moveToElement(pages.getSearchBox()).click().keyDown(Keys.SHIFT).sendKeys("hello").doubleClick().build().perform();
        Thread.sleep(2000);

    }
}
