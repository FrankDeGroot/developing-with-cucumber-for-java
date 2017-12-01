package shop;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ShoppingBasketSteps {

    private ShoppingBasket shoppingBasket;

    @Given("^My basket is empty$")
    public void myBasketIsEmpty() throws Throwable {
        shoppingBasket = new ShoppingBasket();
    }

    @When("^I add a banana to my basket$")
    public void iAddABananaToMyBasket() throws Throwable {
        shoppingBasket.add("banana");
    }

    @Then("^My basket contains a banana$")
    public void myBasketContainsABanana() throws Throwable {
        if (!shoppingBasket.getContents().contains("banana")) throw new AssertionError();
    }
}
