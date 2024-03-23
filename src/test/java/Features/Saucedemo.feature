@regression
Feature: Test Saucedemo

  Scenario: Verify successfully purchase of products
    Given I navigate to Saucedemo main page
    When I log in with standard_user
    Then I add two products to the Cart
    And I verify products are added to the Cart
    And I remove products from the Cart
    And I verify products are removed from the Cart
    And I add two products 2 and 4 to the Cart
    And I verify products are added to the Cart
    And I verify correct products are displayed in the Cart
    And I proceed with Checkout Cart without valid data
    And I validate errors on the Checkout Page
    And I proceed with valid data on the Checkout Page
    And I verify Items data on the Overview Page
    And I finish purchase and verify messages
