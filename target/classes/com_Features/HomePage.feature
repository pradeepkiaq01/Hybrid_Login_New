Feature: Home Page functinality

  Scenario: Navigate to Login page
    Given user open url of the application
    Then validate the Url of the application "Your Store"
    When user click on myAccount
    And user click on Login in dd
    Then Validate user is on Login Page "Account Login"

 
