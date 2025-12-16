Feature: Verify Order Details in Goodyear Sales Portal
  As a registered Goodyear Sales Portal user,
  I want to verify that the order details are displayed correctly
  So that I can ensure order data accuracy and completeness.

  Scenario Outline: Validate all fields in the Order Details page
    Given I have navigated to the "<portalUrl>" Sales Portal login page
    And I enter "<mobileNumber>" as test mobile Number
    And I enter "<otp>" As test OTP
    When I navigate to the Order page from the main menu
    And I click on one order from the order list to view its details
    Then I should see the correct Order Number displayed
    And I should see the correct Order Status displayed
    And I should see the correct My Order Reference displayed
    And I should see the correct Date and Time of the order displayed
    And I should see the correct Sold To information displayed
    And I should see the correct Ship To address displayed
    And I should see the correct Total Tyres Ordered count displayed
    And I should see the correct Total Tyres Confirmed count displayed
    And I should see the correct Total Tyres Shipped count displayed
    And I should see the correct Total Tyres Backorder count displayed
    And I should see the correct Material Code for each product
    And I should see the correct Product Description for each Material Code
    And I should see the correct Order Creation Date displayed
    And I should see the correct Ordered Quantity for each product
    And I should see the correct Shipped Quantity for each product
    And I should see the correct Balance Quantity for each product
    And I should see the correct Requested Delivery Date (RDD) displayed

    Examples:
      | portalUrl                                                             | mobileNumber | otp    |
      #| https://test.mysalesportal.ap.goodyear.com/in/en/INR/signin           | 9632119292   | 123456 |
      #| https://test.mysalesportal.ap.goodyear.com/my/en/MYR/signin           | 168600292    | 123456 |
      |https://test.mysalesportal.ap.goodyear.com/tw/en/TWD/signin            |937617706      |123456|
