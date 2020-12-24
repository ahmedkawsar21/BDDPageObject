package page.pages;
import base.BaseApi;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Pages extends BaseApi {
    @FindBy(css = "input.promoCode")
    WebElement inputBox;

    @FindBy(css = "span.promoInfo")
    WebElement successMessage;

    @FindBy(css = "img[alt='Cart']")
    WebElement addToCart;

    @FindBy(xpath = "//button[text()='PROCEED TO CHECKOUT']")
    WebElement proceedToCheckout;

    @FindBy(css = "button.promoBtn")
    WebElement applyPromo;

    @FindBy(xpath = "//a[@data-csa-c-content-id=\"nav_ya_signin\"='nav_ya_signin']")
    WebElement signInMouseHover;

    @FindBy(id = "twotabsearchtextbox")
    WebElement searchBox;

    @FindBy(id = "travel_date")
    WebElement dateSearch;

    @FindBy(css = "[class='datepicker-days'] [class='datepicker-switch']")
    WebElement monthName;

    @FindBy(css = "[class='datepicker-days'] [class='next']")
    WebElement nextMonth;

    public Pages() {
        PageFactory.initElements(driver,this);
    }

    public WebElement getInputBox() {
        return inputBox;
    }

    public WebElement getSuccessMessage() {
        return successMessage;
    }

    public WebElement getAddToCart() {
        return addToCart;
    }

    public WebElement getProceedToCheckout() {
        return proceedToCheckout;
    }

    public WebElement getApplyPromo() {
        return applyPromo;
    }

    public WebElement getSignInMouseHover() {
        return signInMouseHover;
    }
    public WebElement getSearchBox() {
        return searchBox;
    }

    public WebElement clickDateSearch() {
        dateSearch.click();
        return dateSearch;
    }
    public List<WebElement> monthView() {
        List<WebElement> totalDates = driver.findElements(By.xpath("//td[@class='day']"));
        return totalDates;
    }

    public WebElement getMonthName() {
        return monthName;
    }

    public WebElement clickNextMonth() {
        nextMonth.click();
        return nextMonth;
    }
}
