package Helpers;

import Models.InventoryItem;
import java.util.ArrayList;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ItemHelper {
  private static final WebDriver driver = WebDriverManager.getInstance();

  public static ArrayList<InventoryItem> getAllPageItems(String itemsLocator, String itemName, String itemPrice) {
    ArrayList<InventoryItem> itemsInCart = new ArrayList<>();
    int numberOfItemsInCart = driver.findElements(By.xpath(itemsLocator)).size();
    for (int i = 1; i <= numberOfItemsInCart; i++) {
      String itemElementLocator = itemsLocator + "[" + i + "]";
      InventoryItem item = new InventoryItem();
      item.setName(getName(itemElementLocator, itemName));
      item.setPrice(getDoublePrice(itemElementLocator, itemPrice));
      itemsInCart.add(item);
    }
    return itemsInCart;
  }

  public static ArrayList<InventoryItem> getAllPageItemsAndButtons(String inventoryItemLocator, String inventoryItemNameLocator,
                                                                   String inventoryItemPriceLocator, String inventoryItemAddToCartLocator,
                                                                   String inventoryRemoveFromCartLocator) {
    ArrayList<InventoryItem> itemsInCart = getAllPageItems(inventoryItemLocator, inventoryItemNameLocator, inventoryItemPriceLocator);
    for (int i = 0; i < itemsInCart.size(); i++) {
      int itemNumber = i + 1;
      String itemElementLocator = inventoryItemLocator + "[" + itemNumber + "]";
      itemsInCart.get(i).setAddToCartButton(itemElementLocator + inventoryItemAddToCartLocator);
      itemsInCart.get(i).setRemoveButton(itemElementLocator + inventoryRemoveFromCartLocator);
    }
    return itemsInCart;

  }

  public static double getDoublePrice(String item, String priceElement) {
    return StringReplacer.extractPrice(driver.findElement(By.xpath(item + priceElement)).getText());
  }

  public static String getName(String itemElementLocator, String inventoryItemNameLocator) {
    return driver.findElement(By.xpath(itemElementLocator + inventoryItemNameLocator)).getText();
  }
}