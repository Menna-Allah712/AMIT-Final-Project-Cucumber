package stepsdef;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.CartPage;
import pages.PlaceOrderPage;
import pages.PurchaseSuccessPage;

public class PlaceOrderSteps {
    CartPage cartPage = new CartPage(Hooks.getDriver());
    PlaceOrderPage placeOrderPage;
    PurchaseSuccessPage purchaseSuccessPage;

    @When("the user places the order with name {string}, country {string}, city {string}, credit card {string}, month {string}, and year {string}")
    public void placeOrderWithDetails(String name, String country, String city, String credit, String month, String year) {
        placeOrderPage = cartPage.clickOnPlaceOrderButton();

        // Validate total price before proceeding (optional)
        int totalOrderPrice = placeOrderPage.getTotalOrderPrice();
        Assert.assertEquals(totalOrderPrice, cartPage.getTotalPrice());

        placeOrderPage.insertName(name);
        placeOrderPage.insertCountry(country);
        placeOrderPage.insertCity(city);
        placeOrderPage.insertCreditCard(credit);
        placeOrderPage.insertMonth(month);
        placeOrderPage.insertYear(year);

        purchaseSuccessPage = placeOrderPage.clickOnPurchaseButton();
    }

    @Then("the user should see a success message {string}")
    public void verifyPurchaseSuccess(String expectedMessage) throws InterruptedException {
        String actualMessage = purchaseSuccessPage.readMessage();
        Assert.assertTrue(actualMessage.contains(expectedMessage));
    }
}
