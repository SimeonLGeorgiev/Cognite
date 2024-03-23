package Pages;

import Handlers.ItemHandler;
import Helpers.ItemHelper;
import Helpers.WebDriverManager;
import Models.Cart;
import Models.InventoryItem;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class InventoryPage extends BasePage {
  private final WebDriver driver = WebDriverManager.getInstance();
  private final By firstItemCartButton = By.xpath("//*[@id=\"add-to-cart-sauce-labs-backpack\"]");
  private final By goToCartButton = By.xpath("//a[@class='shopping_cart_link']");
  private final String inventoryItemLocator = "//div[@class='inventory_item']";
  private final String inventoryItemNameLocator = "//div[@class='inventory_item_name ']";
  private final String inventoryItemPriceLocator = "//div[@class='inventory_item_price']";
  private final String inventoryItemAddToCartLocator = "//button[text()=\"Add to cart\"]";
  private final String inventoryRemoveFromCartLocator = "//button[text()=\"Remove\"]";
  ArrayList<InventoryItem> inventoryItems = new ArrayList<>();

  public void verifyPageIsLoaded() {
    driver.findElement(firstItemCartButton).isDisplayed();
  }

  public void addTwoRandomItemsInCart() {
    inventoryItems =
        ItemHelper.getAllPageItemsAndButtons(inventoryItemLocator, inventoryItemNameLocator,
            inventoryItemPriceLocator, inventoryItemAddToCartLocator, inventoryRemoveFromCartLocator);
    addTwoRandomItemsInTheCart(inventoryItems);
  }

  public void verifyProductsAreAddedToCart(String condition) {
    Cart cart = Cart.getInstance();
    if (condition.equals("added")) {
      cart.getItems().forEach(inventoryItem -> Assert.assertTrue(driver.findElement(By.xpath(inventoryItem.getRemoveButton())).isDisplayed()));
    } else {
      cart.getItems().forEach(inventoryItem -> Assert.assertTrue(driver.findElement(By.xpath(inventoryItem.getAddToCartButton())).isDisplayed()));
    }
  }

  public void removeItemsInCart() {
    ItemHandler.removeItemFromCart();
  }

  private void addTwoRandomItemsInTheCart(ArrayList<InventoryItem> inventoryItems) {
    Random random = new Random();
    HashSet<Integer> usedNumbers = new HashSet<>();
    for (int i = 0; i < 2; i++) {
      int randomNumber = random.nextInt(6);
      if (!usedNumbers.contains(randomNumber)) {
        usedNumbers.add(randomNumber);
        InventoryItem item = inventoryItems.get(randomNumber);
        ItemHandler.addItemToCart(item);
      }
    }
  }

  public void addProductToTheCart(int productNumber) {
    ItemHandler.addItemToCart(inventoryItems.get(productNumber));
  }

  public void goToCart() {
    driver.findElement(goToCartButton).click();
  }
}