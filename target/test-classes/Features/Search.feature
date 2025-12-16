@search
Feature: Goodyear Sales Portal System Home Page
  As a user,
  I want to login to Goodyear Sales Portal
  and navigate to the home page
  So I can search tires and view account info

  Scenario: Verify user can search tires by SKU 155/70R13
    Given I have login to the System
    When I search "155/70R13" in the search bar
    And I press ENTER key
    Then the first tire sku should be "155/70R13"

  Scenario: Verify user can search tires by SKU 175/65R14
    When I search "175/65R14" in the search bar
    And I press ENTER key
    Then the first tire sku should be "175/65R14"

  Scenario: Verify user can search tires by SKU 205/60R16
    When I search "205/60R16" in the search bar
    And I press ENTER key
    Then the first tire sku should be "205/60R16"

  Scenario: Verify user can search tires by 13 inch rim size
    When I search "R13" in the search bar
    And I press ENTER key
    Then the first tire name should contain "R13"

  Scenario: Verify user can search tires by 16 inch rim size
    When I search "R15" in the search bar
    And I press ENTER key
    Then the first tire name should contain "R15"

  Scenario: Verify user can search tires by 18 inch rim size
    When I search "R18" in the search bar
    And I press ENTER key
    Then the first tire name should contain "R18"

  Scenario: Verify user can search tires by vehicle type: SUV
    When I search "SUV" in the search bar
    And I press ENTER key
    Then the first tire name should contain "SUV"

  Scenario: Verify user can search tires by vehicle type: Passenger
    When I search "Passenger" in the search bar
    And I press ENTER key
    Then results should be displayed

  Scenario: Verify user can search tires by pattern: EFFICIENT GRIP
    When I search "EFFICIENT GRIP" in the search bar
    And I press ENTER key
    Then the first tire name should contain "EFFICIENTGRIP"

  Scenario: Verify user can search tires by pattern: GPS
    When I search "GPS" in the search bar
    And I press ENTER key
    Then the first tire name should contain "GPS"

  Scenario: Verify user can search tires by pattern: DURAPLUS
    When I search "DURAPLUS" in the search bar
    And I press ENTER key
    Then the first tire name should contain "DURAPLUS"

  Scenario: Verify user view search results by grid view
    When I click grid view button
    Then the search results should be in grid view
