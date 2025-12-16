@invoice
Feature: Goodyear Sales Portal Web
    As a web user,
    I wan to login Goodyear Sales Portal,
    So I can search info of tires I want
        

    Scenario: Verify user can view invoices page successfully
        Given I have lOgin to The systeM
        When click invoices page link
        Then I should be directed to the invoices page
    
    Scenario: Verify user view pending invoices successfully
        When I click Past Due to check
        Then I should view them past data any error occur
         When I click Rugular Due to check
        Then I should view them regular data any error occur

    Scenario: Verify user view completed invoices successfully
        When I click Completed invoices button
        And I click calender button to choose start date
        And Choose date1 as start date
        And I click calender button to choose end date
        And Choose date2 as end date
        And Click APPLY button
        Then I should view completed invoices in details