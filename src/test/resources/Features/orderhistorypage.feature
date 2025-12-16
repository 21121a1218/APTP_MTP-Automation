@history
Feature: Goodyear Sales Portal Web
    As a web user,
    I wan to login Goodyear Sales Portal,
    So I can search info of tires I want
        

    Scenario: Verify user can view order page successfully
        Given I HaVe logIn to the system
        When click order page link
        Then I should be directed to the order page
    
    Scenario: Verify user view order details successfully
        When I click By Order Number to check byorder number
        Then I should view orderdeatils for by ordernumber "1032230948"
        When I click By Product to check byproduct number
        Then I should view orderdeatils for  by prodct "1032230948"
        When I click By Backorder to check 
        Then I should view orderdeatils under bybackorder number
        