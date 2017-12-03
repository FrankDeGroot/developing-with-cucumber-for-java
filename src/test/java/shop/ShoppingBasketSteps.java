package shop;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.MatcherAssert.assertThat;

public class ShoppingBasketSteps {

    private ShoppingBasket shoppingBasket;

    @Given("^My basket is empty$")
    public void myBasketIsEmpty() throws Throwable {
        shoppingBasket = new ShoppingBasket();
    }

    @When("^I add a (\\S+|(?:')[^']+(?:')) to my basket$")
    public void iAddAProductToMyBasket(String product) throws Throwable {
        shoppingBasket.add(product);
    }

    @Then("^My basket contains a (\\S+|(?:')[^']+(?:'))$")
    public void myBasketContainsABanana(String product) throws Throwable {
        assertThat(shoppingBasket.getContents(), hasItem(product));
    }
}
