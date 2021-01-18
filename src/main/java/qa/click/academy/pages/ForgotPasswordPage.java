package qa.click.academy.pages;

import base.BaseApi;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ForgotPasswordPage extends BaseApi {
    @FindBy(xpath = "//input[@id='user_email']")
    private WebElement emailAddress;

    @FindBy(xpath = "//input[@type='submit']")
    private WebElement sendMeInstruction;

    public ForgotPasswordPage() {

        PageFactory.initElements(driver,this);
    }

    public WebElement getEmailAddress(String userName) {
        emailAddress.sendKeys(userName);
        return emailAddress;
    }

    public WebElement clickSendMeInstruction() {
        sendMeInstruction.click();
        return sendMeInstruction;
    }
}
