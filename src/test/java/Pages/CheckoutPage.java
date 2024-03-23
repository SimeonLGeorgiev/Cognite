package Pages;

import Helpers.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class CheckoutPage extends BasePage {
  private final WebDriver driver = WebDriverManager.getInstance();
  private final By checkoutText = By.xpath("//span[@class='title'][text()='Checkout: Your Information']");
  private final By continueButton = By.xpath("//input[@id='continue']");

  private final By firstNameErrorIcon =
      By.xpath("//input[@id='first-name']/following-sibling::*[local-name()='svg' and @class='svg-inline--fa fa-times-circle fa-w-16 error_icon']");
  private final By lastNameErrorIcon =
      By.xpath("//input[@id='last-name']/following-sibling::*[local-name()='svg' and @class='svg-inline--fa fa-times-circle fa-w-16 error_icon']");
  private final By zipCodeErrorIcon =
      By.xpath("//input[@id='postal-code']/following-sibling::*[local-name()='svg' and @class='svg-inline--fa fa-times-circle fa-w-16 error_icon']");
  private final By bigErrorMessage = By.xpath("//div[contains(@class, 'error-message-container')]/h3[@data-test='error']");
  private final By firstNameInputField = By.xpath("//input[@id='first-name']");
  private final By lastNameInputField = By.xpath("//input[@id='last-name']");
  private final By zipCodeInputField = By.xpath("//input[@id='postal-code']");
  private final By closeErrorButtonBy = By.xpath("//button[@class='error-button']");
  private final String RED_COLOR = "rgba(72, 76, 85, 1)";

  public void verifyPageIsLoaded() {
    driver.findElement(checkoutText).isDisplayed();
  }

  public void proceedToNextCheckoutStep() {
    driver.findElement(continueButton).click();
  }

  public void validateAllErrors() {
    Assert.assertEquals(driver.findElement(firstNameInputField).getCssValue("color"), RED_COLOR);
    Assert.assertEquals(driver.findElement(lastNameInputField).getCssValue("color"), RED_COLOR);
    Assert.assertEquals(driver.findElement(zipCodeInputField).getCssValue("color"), RED_COLOR);
    driver.findElement(firstNameErrorIcon).isDisplayed();
    driver.findElement(lastNameErrorIcon).isDisplayed();
    driver.findElement(zipCodeErrorIcon).isDisplayed();
    driver.findElement(bigErrorMessage).isDisplayed();
  }

  public void removeErrors() {
    WebElement closeErrorButton = driver.findElement((closeErrorButtonBy));
    if (closeErrorButton.isDisplayed()) {
      closeErrorButton.click();
    }
  }
  public void fillInformationWithValidData() {
    driver.findElement(firstNameInputField).sendKeys("FirstName");
    driver.findElement(lastNameInputField).sendKeys("LastName");
    driver.findElement(zipCodeInputField).sendKeys("1234");
    driver.findElement(continueButton).click();
  }
}