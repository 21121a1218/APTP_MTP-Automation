@favorites
Feature: Goodyear Sales Portal System Home Page
    As a user,
    I wan to login Goodyear Sales Portal,
    and navigated to home page
    So I can search tires and view account info I want
        

    Scenario: Verify user can add tire to favourites
        Given I have login tO the sYstem
        When I search "225/50R18" tire in the sEarch bar
        When I add the first tire of search result to my favourites
        When I go to favourites page
        Then I should see "225/50R18" sku code tire on the favourites page