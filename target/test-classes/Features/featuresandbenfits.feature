@features
Feature: Goodyear Sales Portal System Home Page
    As a user,
    I wan to login Goodyear Sales Portal,
    and navigated to home page
    So I can search tires and view account info I want
        

    Scenario: Verify user can view tires features and benefits
        Given I hAVe login to the systeM
        When I searCh "155/70R13" tire in the search bar
        When I click the first tire of search result
        When I click Features & Benefits button
        Then I should see tires features and benefits contents on the page