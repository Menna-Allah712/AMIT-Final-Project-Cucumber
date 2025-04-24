package stepsdef;

import org.openqa.selenium.WebDriver;
import pages.HomePage;
import pages.LoginAlert;
import pages.LoginPage;

public class LoginSteps {
    WebDriver driver= Hooks.getDriver();
    HomePage homePage =new HomePage(driver);
    LoginPage loginPage;
    LoginAlert loginAlert;

}
