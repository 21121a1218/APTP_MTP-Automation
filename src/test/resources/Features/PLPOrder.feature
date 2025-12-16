Feature: Verify Complete Order Placement Flow from PLP to Order Confirmation in Goodyear Sales Portal
  As a registered Goodyear Sales Portal user,
  I want to verify that the product listing, cart, checkout, and order confirmation process works correctly
  So that I can ensure a seamless end-to-end ordering experience.

  Scenario Outline: Validate all steps in the PLP to Order Confirmation journey
    Given User launches the "<portalUrl>" Sales Portal Login Page
    And User provides "<mobileNumber>" as login mobile number
    And User provides "<otp>" as login OTP
    When I navigate to the Product Listing Page (PLP)
    Then I should see all product images and product names displayed correctly
    And I should see the correct price displayed for each product
    When I enter a quantity "<quantity>" for a selected product
    And I click on the Add to Cart button
    Then I should see the product image, name, quantity, and pricing correctly displayed in the Add to Cart popup
    When I see the View Cart button displayed and I click on the View Cart button
    Then I should be navigated to the Cart page
    And I should see the credit limit and cart total displayed
    And the credit balance should be greater than the cart total
    And I should see the correct product image, name, quantity, and pricing on the cart page
    And I should see the correct Order Totals and Total Taxes displayed on the cart page
    When I select a delivery date from the date picker
    Then I should see the selected delivery date reflected correctly
    When I click on the Proceed to Checkout button
    Then I should be navigated to the Checkout page
    And I should see the correct shipping and payer address details
    And I should see the correct product image, name, quantity, and pricing on the checkout page
    And I should see the correct Order Totals and Total Taxes displayed on the checkout page
    When I place the order
    Then I should see the "Thank You" message displayed on the order confirmation page
    And I should see the correct product image, name, quantity, and pricing on the order confirmation page
    And I should see the correct Order Totals and Total Taxes displayed on the order confirmation page
    And I should see the correct shipping address displayed on the order confirmation page

    Examples:
      | portalUrl                                                           | mobileNumber | otp     | quantity |
      | https://test.mysalesportal.ap.goodyear.com/in/en/INR/signin         | 9632119292   | 123456  | 2        |
