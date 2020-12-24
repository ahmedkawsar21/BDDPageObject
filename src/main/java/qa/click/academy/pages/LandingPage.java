package qa.click.academy.pages;

import base.BaseApi;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage extends BaseApi {
    @FindBy(xpath = "//i[@class='fa fa-lock fa-lg']")
    private WebElement login;

    @FindBy(xpath = "//div[@class='main-hero']/h1")
    private WebElement welcomeMessage;

    public LandingPage() {
        PageFactory.initElements(driver,this);
    }

    public LoginPage clickLogin() {
        login.click();
        LoginPage loginPage = new LoginPage();
        return loginPage;
    }

    public String getWelcomeMessage() {
        String message = welcomeMessage.getText();
        return message;
    }
}
