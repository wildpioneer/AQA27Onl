@gui
Feature: Validation login functionality

  Background:
    Given open login page

  @smoke
  Scenario: Successful login
    When login with username atrostyanko@gmail.com and password Qwertyu_1
    Then dashboard page is displayed

  Scenario: Login with incorrect password
    When set username "atrostyanko@gmail.com"
    * set password "Qwertyu_2"
    * user clicks login button
    Then error message "Email/Login or Password is incorrect. Please try again." is displayed

  Scenario: Login with incorrect username
    When set username "atrostyanko1@gmail.com"
    * set password "Qwertyu_1"
    * user clicks login button
    Then error message "Email/Login or Password is incorrect. Please try again." is displayed
