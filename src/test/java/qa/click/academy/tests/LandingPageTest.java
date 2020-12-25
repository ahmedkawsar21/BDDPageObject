package qa.click.academy.tests;

import base.BaseApi;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import qa.click.academy.pages.LandingPage;

public class LandingPageTest extends BaseApi {
    @Test
    public void testLandingPage(String browserName) {
        browserName.equalsIgnoreCase("chrome");
        LandingPage landingPage = new LandingPage();
        landingPage.clickLogin();
        String welcomeMessage = landingPage.getWelcomeMessage();
        Assert.assertEquals(welcomeMessage,"Log In to WebServices Testing using SoapUI");

    }


}
