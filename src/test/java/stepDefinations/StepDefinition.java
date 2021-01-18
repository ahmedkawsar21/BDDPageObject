package stepDefinations;

import base.BaseApi;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import qa.click.academy.pages.ForgotPasswordPage;
import qa.click.academy.pages.LandingPage;
import qa.click.academy.pages.LoginPage;

import java.io.IOException;

public class StepDefinition extends BaseApi {
    public static String welcomeMessage;
    static LandingPage landingPage;
    static LoginPage loginPage;
    static ForgotPasswordPage forgotPasswordPage;
    @Given("User already on landing page")
    public void user_already_on_landing_page() throws IOException {
        setUp();
    }
    @When("User click on login Button")
    public void user_click_on_login_button() {
        landingPage = new LandingPage();
        landingPage.clickLogin();
    }
    @Then("User navigate to login page")
    public void user_navigate_to_login_page() {
        welcomeMessage = landingPage.getWelcomeMessage();
    }
    @Then("welcome message displayed")
    public void welcome_message_displayed() {
        Assert.assertEquals(welcomeMessage,"Log In to WebServices Testing using SoapUI");
        tearUp();

    }
    @Given("User already on login page")
    public void user_already_on_login_page() throws IOException {
        setUp();
        landingPage = new LandingPage();
        loginPage = landingPage.clickLogin();
    }
    @When("User enters {string} and {string}")
    public void user_enters_and(String username, String password) {
        loginPage.getEmailId(username);
        loginPage.getEmailPassword(password);
    }
    @Then("User click on login bar")
    public void user_click_on_login_bar() {
        loginPage.clickConfirmSignIn();
    }
    @Then("User click on forgot password button")
    public void user_click_on_forgot_password_button() {
       forgotPasswordPage = loginPage.clickOnForgotPassword();
    }
    @Then("User enters {string}")
    public void user_enters(String username) {
        forgotPasswordPage.getEmailAddress(username);
    }
    @Then("click on send instructions button")
    public void click_on_send_instructions_button() {
        forgotPasswordPage.clickSendMeInstruction();
        tearUp();
    }
}


