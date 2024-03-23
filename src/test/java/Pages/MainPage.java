package Pages;

import Helpers.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage extends BasePage {
  private final WebDriver driver = WebDriverManager.getInstance();
  private final By loginButton =  By.xpath("//input[@data-test='login-button']");
  private final By userNameField = By.xpath("//input[@data-test='username']");
  private final By passwordField = By.xpath("//input[@data-test='password']");
  private final String PASSWORD = "secret_sauce";

  public void openPage() {
    driver.navigate().to(getBaseUrl());
  }

  public void verifyPageIsLoaded() {
   driver.findElement(loginButton).isDisplayed();
  }

  public void loginWithUser(String userName) {
    driver.findElement(userNameField).sendKeys(userName);
    driver.findElement(passwordField).sendKeys(PASSWORD);
    driver.findElement(loginButton).click();
  }
}
