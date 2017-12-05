package shop;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.mockito.Mockito;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

public class ShoppingBasketSteps {
    private static final String PRODUCT_NAME = "'([^']*)'";

    private ShoppingBasket shoppingBasket;
    private Inventory inventory;
    private Exception exception;

    @Before
    public void before() {
        inventory = Mockito.mock(Inventory.class);
    }

    @Given("^My basket is empty$")
    public void myBasketIsEmpty() throws Throwable {
        //inventory = new AlwaysInStockInventory();
        shoppingBasket = new ShoppingBasket(inventory, catalog);
    }

    @When("^I add a " + PRODUCT_NAME + " to my basket$")
    public void iAddAProductToMyBasket(String product) throws Throwable {
        try {
            shoppingBasket.add(product);
        } catch (Exception exception) {
            this.exception = exception;
        }
    }

    @When("^I remove a " + PRODUCT_NAME + " from my basket$")
    public void iRemoveAProductFromMyBasket(String product) throws Throwable {
        shoppingBasket.remove(product);
    }

    @Then("^My basket contains a " + PRODUCT_NAME + "$")
    public void myBasketContainsABanana(String product) throws Throwable {
        assertThat(shoppingBasket.getContents(), hasItem(new Item(product)));
    }

    @Then("^My basket does NOT contain a " + PRODUCT_NAME + "$")
    public void myBasketDoesNOTContainABanana(String product) throws Throwable {
        assertThat(shoppingBasket.getContents(), not(hasItem(new Item(product))));
    }

    @Then("^I get an Empty Product error$")
    public void iGetAnEmptyProductError() {
        assertThat(this.exception, notNullValue());
        assertThat(this.exception.getMessage(), equalTo("Empty product"));
    }

    @Then("^I should have (\\d+) " + PRODUCT_NAME + "s? in my basket$")
    public void iShouldHaveBananaInMyBasket(int count, String product) throws Throwable {
//        assertThat(shoppingBasket.getContents(), not(hasItem(new Item(product))));
        assertThat(shoppingBasket.getItem(product).getCount(), equalTo(2));
    }

    @Given("^A " + PRODUCT_NAME + " is in stock$")
    public void aBananaInStock(String product) throws Throwable {
        when(inventory.inStock(eq(product))).thenReturn(true);
    }

    @Given("^A " + PRODUCT_NAME + " is out of stock$")
    public void aBananaOutOfStock(String product) throws Throwable {
        when(inventory.inStock(eq(product))).thenReturn(false);
    }
}
