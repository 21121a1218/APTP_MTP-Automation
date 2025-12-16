@credit
Feature: Goodyear Sales Portal Web
    
    Scenario: Verify user can view credits page successfully
        Given I Have login to THE system
        When click my credits page link
        Then I should be directed to the credits page
    

    Scenario: Verify user can add funds on credits page successfully
        When I am on the credits page and enter "10000" to the payment amount input bar
        When I enter "10" to the TDS amount input bar
        When I click ADD FUNDS button
        Then I should be directed to transaction page