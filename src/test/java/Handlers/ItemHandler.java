package Handlers;

import Helpers.WebDriverManager;
import Models.Cart;
import Models.InventoryItem;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ItemHandler {
  private static final WebDriver driver = WebDriverManager.getInstance();

  public static void addItemToCart(InventoryItem item) {
    Cart cart = Cart.getInstance();
    driver.findElement(By.xpath(item.getAddToCartButton())).click();
    cart.addItem(item);
  }

  public static void removeItemFromCart() {
    Cart cart = Cart.getInstance();
    cart.getItems().forEach(inventoryItem -> driver.findElement(By.xpath(inventoryItem.getRemoveButton())).click());
    for (int i = cart.getItems().size() - 1; i >= 0; i--) {
      cart.removeItem(cart.getItems().get(i));
    }
  }
}