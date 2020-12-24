package qa.click.academy.pages;

import base.BaseApi;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BaseApi {
    @FindBy(xpath = "//input[@name='email']")
    private WebElement email;

    @FindBy(xpath = "//input[@name=' password']")
    private WebElement password;

    @FindBy(xpath = "//input[@name='commit']")
    private WebElement confirmSignIn;

    @FindBy(xpath = "//a[@class='link-below-button']")
    private WebElement forgotPassword;

    public LoginPage() {
        PageFactory.initElements(driver,this);
    }

    public WebElement getEmailId(String userName) {
        email.sendKeys(userName);
        return email;
    }

    public WebElement getEmailPassword(String emailPassword) {
        password.sendKeys(emailPassword);
        return password;
    }

    public WebElement clickConfirmSignIn() {
        confirmSignIn.click();
        return confirmSignIn;
    }

    public ForgotPasswordPage clickOnForgotPassword() {
        forgotPassword.click();
        ForgotPasswordPage forgotPassword = new ForgotPasswordPage();
        return forgotPassword;
    }
}
