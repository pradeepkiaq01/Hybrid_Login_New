Feature: Login Page Functionality

  Background:
    Given user open url of the application
    When user click on myAccount
    And user click on Login in dd

  Scenario Outline: validate login with diffrent credentials
    When user enters Email filed "<Email>"
    And user enters password in field "<Password>"
    And user click Login button
    Then validate with result "<Results>"

    Examples:
      | Email                       | Password         | Results    |
      | bharathkumargmail.com       | q12345           | Invalid    |
      | a487@4gmail.com             | Bharath02112001@ | Invalid    |
      | bharathkumar.kiaq@gmail.com | dw364s           | Invalid    |
      |                             |                  |            |
      |                             | Bharath02112001@ | Invalid    |
      | bharathkumar.kiaq@gmail.com |                  | Invalid    |
      | bharathkumar.kiaq@gmail.com | Bharath02112001@ | My Account |

  Scenario: Navigate to Forgot password
    Given user open url of the application
    When user click on myAccount
    And user click on Login in dd
    Then validate "Forgotten Password" is present
    When user click on forgot password
    Then validate user is on "Forgot Your Password?" page

  Scenario: verify keyboard navigation
    When user press tab key until the email field focused
    When user enters Email filed "bharathkumar.kiaq@gmail.com"
    And user press tab key untill it focus password
    And user enters password in field "Bharath02112001@"
    And user press tab key until the login button focus
    And user press enter key
    Then validate with result "My Account"

  Scenario: validate placeholder text
    Then user should see correct placholder text in email box "E-Mail Address"
    Then user should see correct placholder text in password box "Password"

  Scenario: validate user remains logged in after click back
    When user enters Email filed "bharathkumar.kiaq@gmail.com"
    And user enters password in field "Bharath02112001@"
    And user click Login button
    And user click on back button
    Then validate with result "My Account"

  Scenario: validate user not logged in agin after click back
    When user enters Email filed "bharathkumar.kiaq@gmail.com"
    And user enters password in field "Bharath02112001@"
    And user click Login button
    And user click on back button
    Then Validate user is on Login Page "Account Login"

  Scenario: validate login with inactive acount
    When user enters Email filed "pradeepkiaqkiaq@gmail.com"
    And user enters password in field "Abcd@123"
    And user click Login button
    Then validate with result "Invalid"

  Scenario: validate login after multiple failed attempts
    When user enters Email filed "pradeepkiaqkiaq@gmail.com"
    And user enters password in field "Abcd@123"
    And user click Login button five times
    Then validate with result "Invalid"

  Scenario: validate password filed hides entered value
    And user enters password in field "Abcd@123"
    Then validate password filed is should be hide "password"

  Scenario: validate user can login with changerd password
    When user enters Email filed "testing.field@gmail.com"
    And user enters password in field "abcd@123"
    And user click Login button
    When user click change password
    And enter "abcd@123" and confirm "abcd@123"
    And click continue button on cho page
    Then validate successfully changed
    When user click on myAccount
    And user click on logout
    And click continue button
    When user click on myAccount
    And user click on Login in dd
    When user enters Email filed "testing.field@gmail.com"
    And user enters password in field "abcd@123"
    And user click Login button
    Then validate with result "My Account"

  Scenario: validate user session is maintained after closed browser
    When user enters Email filed "bharathkumar.kiaq@gmail.com"
    And user enters password in field "Bharath02112001@"
    And user click Login button
    When user close the browser
    Given user open url of the application
    When user click on myAccount
    Then user remain looged in

  Scenario: validate user can navigate back to login page
    When user click on continue button on new user
    And user click on back button
    Then Validate user is on Login Page "Account Login"

  Scenario: validate right column option navigate to login page
    When user click on Register accnt
    And user click on back button
    Then Validate user is on Login Page "Account Login"
    When user click on forgot password from right column
    And user click on back button
    Then Validate user is on Login Page "Account Login"

  Scenario: Validate login page breadcrumb,heading,url,and title
    Then user validate breadcrump is displayed
    Then user validate title of login page "Account Login"
    And user validate url of the login page "https://tutorialsninja.com/demo/index.php?route=account/login"
    And user validate header on login page "Qafox.com"
