package StepDefinitions;

import Pages.CartPage;
import Pages.CheckoutPage;
import io.cucumber.java.en.And;


public class CheckoutPageSteps {
  CartPage cartPage = new CartPage();
  CheckoutPage checkoutPage = new CheckoutPage();


  @And("I proceed with Checkout Cart without valid data")
  public void proceedWithCheckoutCartWithoutValidData() {
    cartPage.goToCheckoutPage();
    checkoutPage.verifyPageIsLoaded();
    checkoutPage.proceedToNextCheckoutStep();
  }

  @And("I validate errors on the Checkout Page")
  public void validateErrorsOnTheCheckoutPage() {
    checkoutPage.validateAllErrors();
  }

  @And("I proceed with valid data on the Checkout Page")
  public void proceedWithValidDataOnTheCheckoutPage() {
    checkoutPage.removeErrors();
    checkoutPage.fillInformationWithValidData();
  }
}
