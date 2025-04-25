package stepsdef;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.HomePage;
import pages.LaptopsPage;
import pages.ProductAddedAlert;
import pages.ProductPage;

public class AddProductSteps {
    WebDriver driver= Hooks.getDriver();
    HomePage homePage =new HomePage(driver);
    LaptopsPage laptopsPage;
    ProductPage productPage;
    ProductAddedAlert productAddedAlert;

    @When("the user click on Laptops and adds the first product to the cart")
    public void theUserClickOnLaptopsAndAddsTheFirstProductToTheCart() throws InterruptedException {
        laptopsPage = homePage.clickLaptopsLink();
        Thread.sleep(1000);
        productPage = laptopsPage.clickOnFirstProduct();
        productAddedAlert = productPage.clickOnAddToCartButton();
    }

    @Then("an alert message should contain {string}")
    public void verifyFirstProductAdded(String expectedAlert) {
        String actualAlert = productAddedAlert.readMessage();
        Assert.assertTrue(actualAlert.contains(expectedAlert));
        productPage = productAddedAlert.closeAlert();
        homePage = productPage.clickOnHomePageButton();
    }
    @When("the user click on to Laptops again and adds the second product to the cart")
    public void addSecondLaptopToCart() throws InterruptedException {
        laptopsPage = homePage.clickLaptopsLink();
        Thread.sleep(1000);
        productPage = laptopsPage.clickOnSecondProduct();
        productAddedAlert = productPage.clickOnAddToCartButton();
    }

    @Then("another alert message should contain {string}")
    public void verifySecondProductAdded(String expectedAlert) {
        String actualAlert = productAddedAlert.readMessage();
        Assert.assertTrue(actualAlert.contains(expectedAlert));
        productPage = productAddedAlert.closeAlert();
    }
}
