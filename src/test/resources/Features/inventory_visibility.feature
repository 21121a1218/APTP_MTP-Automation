@inventory
Feature: Goodyear Sales Portal Web
    As a web user,
    I wan to login Goodyear Sales Portal,
    So I can search info of tires I want
        

    Scenario: Verify user can view inventory information on search result page
        Given I havE login to the sysTEm
        When I search "155/70R13" tire in the Search bar
        When  I press ENTER kEy to search
        Then I should see the inventory information of tires either Stock Available or No Stock
    