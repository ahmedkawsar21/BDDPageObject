package qa.click.academy.tests;

import base.BaseApi;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import qa.click.academy.pages.ForgotPasswordPage;
import qa.click.academy.pages.LandingPage;
import qa.click.academy.pages.LoginPage;

public class LoginPageTest extends BaseApi {
    private static final Logger log = LogManager.getLogger(LoginPageTest.class);
    @Test(dataProvider = "getData")
    public void testLoginPae(String userName, String emailPassword, String text) {
        LandingPage landingPage = new LandingPage();
        log.info("click on login button");
        LoginPage loginPage = landingPage.clickLogin();
        log.info("entering username");
        loginPage.getEmailId(userName);
        log.info("entering password");
        loginPage.getEmailPassword(emailPassword);
        log.info("click on confirm sign in");
        loginPage.clickConfirmSignIn();
        log.info(text);
        ForgotPasswordPage forgotPasswordPage = loginPage.clickOnForgotPassword();
        forgotPasswordPage.getEmailAddress();
        forgotPasswordPage.clickSendMeInstruction();



    }
    @DataProvider
    public Object[][] getData() {
        Object[][] data = new Object[2][3];
        data[0][0] = "nonretricteduser.com";
        data[0][1] = "12345";
        data[0][2] = "restricted user";

        data[1][0] = "restructeduser.com";
        data[1][1] = "67890";
        data[1][2] = "nonresytricte user";
        return data;
    }

}
