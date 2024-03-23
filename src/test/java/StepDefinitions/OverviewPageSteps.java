package StepDefinitions;

import Pages.CompletePage;
import Pages.OverviewPage;
import io.cucumber.java.en.And;


public class OverviewPageSteps {
  OverviewPage overviewPage = new OverviewPage();
  CompletePage completePage = new CompletePage();


  @And("I verify Items data on the Overview Page")
  public void verifyItemsDataOnTheOverviewPage() {
    overviewPage.verifyPageIsLoaded();
    overviewPage.verifyCorrectItemsInTheCart();
    overviewPage.verifyPrices();
    overviewPage.verifyButtons();
  }

  @And("I finish purchase and verify messages")
  public void finishPurchaseAndVerifyMessages() {
    overviewPage.clickFinish();
    completePage.verifyPageIsLoaded();
    completePage.verifySuccessMessage();
    completePage.logout();
  }
}
