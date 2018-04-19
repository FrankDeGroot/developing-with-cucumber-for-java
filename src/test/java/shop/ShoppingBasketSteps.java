package shop;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
//import cucumber.api.java8.En;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsCollectionContaining.hasItem;
import static org.junit.Assert.assertThat;

public class ShoppingBasketSteps /* implements En */ {

    private ShoppingBasket shoppingBasket;

    public ShoppingBasketSteps(ShoppingBasket shoppingBasket) {
        this.shoppingBasket = shoppingBasket;
//        Given("^My basket is empty$", () -> this.shoppingBasket = new ShoppingBasket());
//        When("^I add a banana to my basket$", () -> shoppingBasket.add("banana"));
//        When("^I remove a banana from my basket$", () -> shoppingBasket.remove("banana"));
//        Then("^My basket should contain a banana$", () -> assertThat(shoppingBasket.getContents(), hasItem("banana")));
//        Then("^My basket should be empty$", () -> assertThat(shoppingBasket.getContents().size(), is(0)));
    }

    @Given("^My basket is empty$")
    public void myBasketIsEmpty() throws Throwable {
        shoppingBasket.clear();
    }

    @When("^I add a banana to my basket$")
    public void iAddABananaToMyBasket() throws Throwable {
        shoppingBasket.add("banana");
    }

    @When("^I remove a banana from my basket$")
    public void iRemoveABananaFromMyBasket() throws Throwable {
        shoppingBasket.remove("banana");
    }

    @Then("^My basket should contain a banana$")
    public void myBasketShouldContainABanana() throws Throwable {
        assertThat(shoppingBasket.getCount("banana"), is(1));
    }

    @Then("^My basket should be empty$")
    public void myBasketShouldBeEmpty() throws Throwable {
        assertThat(shoppingBasket.getContents().isEmpty(), is(true));
    }
}
