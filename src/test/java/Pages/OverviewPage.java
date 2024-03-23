package Pages;

import Helpers.ItemHelper;
import Helpers.StringReplacer;
import Helpers.WebDriverManager;
import Models.Cart;
import Models.InventoryItem;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class OverviewPage extends BasePage {
  private final WebDriver driver = WebDriverManager.getInstance();
  private final By checkoutText = By.xpath("//span[@class='title'][text()='Checkout: Overview']");
  private final String cartItemLocator = "//div[@class='cart_item']";
  private final String cartItemNameLocator = "//div[@class='inventory_item_name']";
  private final String cartItemPriceLocator = "//div[@class='inventory_item_price']";
  private final String priceBeforeTax = "//div[contains(@class, 'summary_subtotal_label')]";
  private final String taxAmount = "//div[contains(@class, 'summary_tax_label')]";
  private final String totalPrice = "//div[contains(@class, 'summary_info_label summary_total_label')]";
  private final By cancelButton = By.xpath("//button[@id='cancel']");
  private final By finishButton = By.xpath("//button[@id='finish']");

  public void verifyPageIsLoaded() {
    driver.findElement(checkoutText).isDisplayed();
  }

  public void verifyCorrectItemsInTheCart() {
    ArrayList<InventoryItem> itemsInOverview = ItemHelper.getAllPageItems(cartItemLocator, cartItemNameLocator, cartItemPriceLocator);
    Cart cart = Cart.getInstance();
    Assert.assertEquals(cart.getItems(), itemsInOverview);
  }

  public void verifyPrices() {
    ArrayList<InventoryItem> itemsInOverview = ItemHelper.getAllPageItems(cartItemLocator, cartItemNameLocator, cartItemPriceLocator);
    double totalPriceInCart = itemsInOverview.stream().mapToDouble(InventoryItem::getPrice).sum();
    BigDecimal tax = BigDecimal.valueOf(totalPriceInCart / 12.5).setScale(2, RoundingMode.HALF_UP);
    BigDecimal pricePlusTax = BigDecimal.valueOf(totalPriceInCart).add(tax);
    WebElement priceBeforeTaxValue = driver.findElement(By.xpath(priceBeforeTax));
    WebElement priceTaxAmountValue = driver.findElement(By.xpath(taxAmount));
    WebElement totalPriceValue = driver.findElement(By.xpath(totalPrice));
    double priceBeforeTax = StringReplacer.extractPrice(priceBeforeTaxValue.getText());

    Assert.assertEquals(priceBeforeTax, totalPriceInCart);
    Assert.assertEquals(StringReplacer.extractPrice(priceTaxAmountValue.getText()), tax.doubleValue());
    Assert.assertEquals(StringReplacer.extractPrice(totalPriceValue.getText()), pricePlusTax.doubleValue());
  }

  public void verifyButtons() {
    driver.findElement(finishButton).isDisplayed();
    driver.findElement(cancelButton).isDisplayed();
  }

  public void clickFinish() {
    driver.findElement(finishButton).click();
  }
}