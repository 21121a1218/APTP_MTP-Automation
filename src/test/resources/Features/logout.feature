Feature: Goodyear Sales Portal Web Login
  As a web user,
  I want to login to Goodyear Sales Portal,
  So I can search info of tires I want

  Scenario Outline: Verify user can login in successfully with multiple credentials
    Given I HaVe navigAted to the "<portalUrl>" Sales Portal login Page
    When I entEr "<mobileNumber>" as test mobile number
    When I enter "<otp>" as tESt OTP
    Then I can see the hOmepage
    When I Click logout
    Then I can see the signin page

    Examples:
      | portalUrl                                                             | mobileNumber  | otp    |
      | https://test.mysalesportal.ap.goodyear.com/in/en/INR/signin           | 9632119292    | 123456 |