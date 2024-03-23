package StepDefinitions;

import Pages.InventoryPage;
import io.cucumber.java.en.And;


public class InventoryPageSteps {
  InventoryPage inventoryPage = new InventoryPage();

  @And("I add two products to the Cart")
  public void addTwoProductsToTheCart() {
    inventoryPage.addTwoRandomItemsInCart();
  }

  @And("I verify products are {word} {word} the Cart")
  public void verifyProductsAreAddedOrRemovedFromTheCart(String condition, String word) {
    inventoryPage.verifyProductsAreAddedToCart(condition);
  }

  @And("I remove products from the Cart")
  public void removeProductsFromTheCart() {
    inventoryPage.removeItemsInCart();
  }

  @And("I add two products {int} and {int} to the Cart")
  public void addTwoProductsAndToTheCart(int firstProduct, int secondProduct) {
    inventoryPage.addProductToTheCart(firstProduct);
    inventoryPage.addProductToTheCart(secondProduct);
  }
}
