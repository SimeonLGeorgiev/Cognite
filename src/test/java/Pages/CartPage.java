package Pages;

import Helpers.ItemHelper;
import Helpers.WebDriverManager;
import Models.Cart;
import Models.InventoryItem;
import java.util.ArrayList;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CartPage extends BasePage {
  private final WebDriver driver = WebDriverManager.getInstance();
  private final By yourCartText = By.xpath("//span[@class='title'][text()='Your Cart']");
  private final By checkoutButton = By.xpath("//button[@id='checkout']");
  private final String cartItemLocator = "//div[@class='cart_item']";
  private final String cartItemNameLocator = "//div[@class='inventory_item_name']";
  private final String cartItemPriceLocator = "//div[@class='inventory_item_price']";

  public void verifyPageIsLoaded() {
    driver.findElement(yourCartText).isDisplayed();
  }

  public void verifyCorrectItemsInTheCart() {
    ArrayList<InventoryItem> itemsInCart = ItemHelper.getAllPageItems(cartItemLocator, cartItemNameLocator, cartItemPriceLocator);
    Cart cart = Cart.getInstance();
    Assert.assertEquals(cart.getItems(), itemsInCart);
  }

  public void goToCheckoutPage() {
    driver.findElement(checkoutButton).click();
  }
}