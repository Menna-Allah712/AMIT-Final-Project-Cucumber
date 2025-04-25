package stepsdef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.HomePage;
import pages.LoginAlert;
import pages.LoginPage;

public class LoginSteps {
    WebDriver driver= Hooks.getDriver();
    HomePage homePage =new HomePage(driver);
    LoginPage loginPage;
    LoginAlert loginAlert;

    @Given("user open homepage & click on login button")
    public void userOpenHomepageClickOnLoginButton() {
        loginPage = homePage.clickLoginLink();
    }

    @When("user enters username & password & press on login button")
    public void userEntersUsernamePasswordPressOnLoginButton() {
        loginPage.insertUsername("Menna14");
        loginPage.insertPassword("123");
        homePage = loginPage.clickOnLoginButton();
    }

    @Then("user is switched to loginAlert & success message appear")
    public void userIsSwitchedToLoginAlertSuccessMessageAppear() {
        //compare
        String expectedResult = "Welcome";
        String actualResult = homePage.readWelcomeMessage();
        //assert
        Assert.assertTrue(actualResult.contains(expectedResult));
    }


    @When("the user attempts to log in with username {string} and password {string}")
    public void user_attempts_invalid_login(String username, String password){
        loginPage.insertUsername(username);
        loginPage.insertPassword(password);
        loginAlert = loginPage.clickOnLoginButtonWrongPassword();
    }

    @Then("the user should see an alert message Wrong password.")
    public void user_should_see_alert_message() {
        String expectedAlert = "Wrong password.";
        String actualAlert = loginAlert.readMessage();
        Assert.assertTrue(actualAlert.contains(expectedAlert));
        loginAlert.closeAlert();
    }
}
