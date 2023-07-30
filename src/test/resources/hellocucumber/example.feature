Feature: Login to a website

  Scenario: Success login to our website
    Given I am on the login page
    When I enter valid username and password
    And I click on login button
    Then I should be logged in

  Scenario: Login as locked user
    Given I am on the login page
    When I enter locked username
    And I enter valid password
    And I click on login button
    Then error message should be shown

  Scenario Outline: Unsuccessful login with different reasons
    Given I am on the login page
    When I enter invalid <username>
    But I enter valid password
    And click on login button
    Then "<error>" should be shown
    And I should NOT be logged in
    Examples:
      | username        | error                                                                     |
      | locked_out_user | Epic sadface: Sorry, this user has been locked out.                       |
      | admin12345      | Epic sadface: Username and password do not match any user in this service |