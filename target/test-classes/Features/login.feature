Feature: Goodyear Sales Portal Web Login
  As a web user,
  I want to login to Goodyear Sales Portal,
  So I can search info of tires I want

  Scenario Outline: Verify user can login in successfully with multiple credentials
    Given I have navigated to the "<portalUrl>" Sales Portal login Page
    When I enter "<mobileNumber>" as test mobile number
    And I enter "<otp>" as test OTP
    Then I can see the homepage

    Examples:
      | portalUrl                                                             | mobileNumber  | otp    |
      | https://test.mysalesportal.ap.goodyear.com/in/en/INR/signin           | 9632119292    | 123456 |