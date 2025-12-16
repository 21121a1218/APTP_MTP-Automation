@cart
Feature: Goodyear Sales Portal System Home Page
    As a user,
    I wan to login Goodyear Sales Portal,
    and navigated to home page
    So I can search tires and view account info I want
        

    Scenario: Verify user can add tire to the cart
        Given I have login to the syStEm
        When I search "205/65R15 99H" tire in the search bar
        And I press ENTER key to search
        And I add the first tire of search result to the cart
        And I go to cart page
        Then I should see "205/65R15 99H" sku code tire on the cart page