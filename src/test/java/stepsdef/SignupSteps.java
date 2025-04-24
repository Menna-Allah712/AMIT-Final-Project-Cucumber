package stepsdef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.HomePage;
import pages.LoginPage;
import pages.SignupAlert;
import pages.SignupPage;

public class SignupSteps {
    WebDriver driver= Hooks.getDriver();
    HomePage homePage =new HomePage(driver);
    SignupPage signupPage;
    SignupAlert signupAlert;


    @Given("user open home page & click on signup button")
    public void user_open_home_page_click_on_signup_button() {
      signupPage= homePage.clickSignupLink();
    }

    @When("user enters username & password & press on signup button")
    public void userEntersUsernamePasswordPressOnSignupButton() {
        signupPage.insertUsername("Menna14");
        signupPage.insertPassword("123!");
        signupAlert = signupPage.clickOnSignupButton();

        
    }

    @Then("user is switched to signupAlert & success message appear")
    public void userIsSwitchedToSignupAlertSuccessMessageAppear() {
        String expectedResult = "Sign up successful.";
        String actualResult = signupAlert.readMessage();
        Thread.sleep (2000);
        Assert.assertTrue(actualResult.contains(expectedResult));
        SignupAlert.closeAlert();
    }

    @When("user enters exist {string} & {string} & press on signup button")
    public void userEntersExistPressOnSignupButton(String username, String password) {
        signupPage.insertUsername(username);
        signupPage.insertPassword(password);
        signupAlert = signupPage.clickOnSignupButton();
        
    }

    @Then("user is switched to signupAlert & error message appear")
    public void userIsSwitchedToSignupAlertErrorMessageAppear() {
        String expectedResult = "This user already exist.";
        String actualResult = signupAlert.readMessage();
        Thread.sleep (2000);
        Assert.assertTrue(actualResult.contains(expectedResult));

    }


}
