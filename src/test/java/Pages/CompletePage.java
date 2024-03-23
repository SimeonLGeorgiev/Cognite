package Pages;

import Helpers.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CompletePage extends BasePage {
  private final WebDriver driver = WebDriverManager.getInstance();
  private final By successMessageElement = By.xpath("//div[@id='checkout_complete_container']");
  private final By backHomeButton = By.xpath("//button[@data-test='back-to-products']");

  public void verifyPageIsLoaded() {
    driver.findElement(backHomeButton).isDisplayed();
  }

  public void verifySuccessMessage() {
    driver.findElement(successMessageElement).isDisplayed();
  }

  public void logout() {
    driver.findElement(backHomeButton).click();
  }
}