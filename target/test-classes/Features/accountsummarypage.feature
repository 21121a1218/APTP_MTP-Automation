@account
Feature: Goodyear Sales Portal Web
    As a web user,
    I wan to login Goodyear Sales Portal,
    So I can search info of tires I want
        
    Scenario: Verify user can view account summary page successfully
        Given I Have login to thE system
        When click account summary link
        Then I should be directed to the account summary page
    
    Scenario: Verify user view account summary page details successfully
        Then I should see account summary information in details
    
    Scenario: Verify user view account statement page details successfully
        When I click account statement tab
        Then I should see the Filter by Posting period section
