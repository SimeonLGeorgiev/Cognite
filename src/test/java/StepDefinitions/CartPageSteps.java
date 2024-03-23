package StepDefinitions;

import Pages.CartPage;
import Pages.InventoryPage;
import io.cucumber.java.en.And;


public class CartPageSteps {
  InventoryPage inventoryPage = new InventoryPage();
  CartPage cartPage = new CartPage();


  @And("I verify correct products are displayed in the Cart")
  public void verifyCorrectProductsAreDisplayedInTheCart() {
    inventoryPage.goToCart();
    cartPage.verifyPageIsLoaded();
    cartPage.verifyCorrectItemsInTheCart();
  }
}
