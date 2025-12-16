@payment
Feature: Goodyear Sales Portal Web
    As a web user,
    I wan to login Goodyear Sales Portal,
    So I can search info of tires I want
        

    Scenario: Verify user can view payment history page successfully
        Given I hAve login tO the system
        When click payment history page link
        Then I should be directed to the payment history page