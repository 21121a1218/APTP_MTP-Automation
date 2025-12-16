Feature: Resend OTP Functionality
  As a registered Goodyear Sales Portal user,
  I want to resend the OTP to my registered mobile number,
  So that I can log in successfully even if the previous OTP has expired.

  Scenario Outline: Verify user can resend OTP and login successfully
    Given I have navigated to the "<portalUrl>" Sales Portal LoGin Page
    And I enter "<mobileNumber>" as Test mobIle number
    When I wait for the previous OTP to expire or click on Resend OTP
    Then I should see that the OTP countdown timer restarts
    When I enTer "<otp>" as Test oTP
    Then I can see the HoMEpAge

    Examples:
      | portalUrl                                                             | mobileNumber | otp    |
      | https://test.mysalesportal.ap.goodyear.com/in/en/INR/signin           | 9632119292   | 123456 |