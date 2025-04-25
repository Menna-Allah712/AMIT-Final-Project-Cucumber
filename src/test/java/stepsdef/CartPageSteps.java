package stepsdef;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.CartPage;
import pages.ProductPage;

public class CartPageSteps {
    ProductPage productPage;
    CartPage cartPage;
    @When("the user goes to the cart page")
    public void goToCartPage() {
        productPage = new ProductPage(Hooks.getDriver());
        cartPage = productPage.clickOnCartPageButton();
    }

    @Then("the cart should contain two products")
    public void verifyCartItems() {
        Assert.assertNotNull(cartPage.getFirstItem());
        Assert.assertNotNull(cartPage.getSecondItem());
    }

    @Then("the total price should be the sum of the two product prices")
    public void verifyTotalPrice() {
        int first = cartPage.getFirstCartItemPrice();
        int second = cartPage.getSecondCartItemPrice();
        int total = cartPage.getTotalPrice();
        Assert.assertEquals(first + second, total);
    }
}
