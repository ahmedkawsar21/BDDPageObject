package pages;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BaseApi;
import utils.Pages;
import utils.ReusableMethods;

public class AddToCart extends BaseApi {
    public Pages pages;
    @BeforeMethod
    public void init() {
        pages=PageFactory.initElements(driver,Pages.class);
    }
    @Test
    public void addToCart() {
        String[] names= {"Cucumber", "Brocolli", "Tomato", "Walnuts"};
        ReusableMethods.addItems(names);
        pages.getAddToCart().click();
        pages.getProceedToCheckout().click();
        webDriverWait(pages.getInputBox());
        pages.getInputBox().sendKeys("rahulshettyacademy");
        pages.getApplyPromo().click();
        webDriverWait(pages.getSuccessMessage());
        String successMessage = pages.getSuccessMessage().getText();
        Assert.assertEquals(successMessage,"Code applied ..!");
    }
}
