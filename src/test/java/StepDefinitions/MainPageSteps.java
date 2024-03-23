package StepDefinitions;

import Pages.InventoryPage;
import Pages.MainPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;


public class MainPageSteps {
  MainPage mainPage = new MainPage();
  InventoryPage inventoryPage = new InventoryPage();

  @Given("I navigate to Saucedemo main page")
  public void navigateToSaucedemoMainPage() {
    mainPage.openPage();
    mainPage.verifyPageIsLoaded();
  }

  @Then("I log in with {word}")
  public void logInWithUser(String userName) {
    mainPage.loginWithUser(userName);
    inventoryPage.verifyPageIsLoaded();
  }
}
