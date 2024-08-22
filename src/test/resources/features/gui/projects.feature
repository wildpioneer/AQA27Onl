@gui
Feature: Validation login functionality

  Background:
    Given open login page
    * login with username atrostyanko@gmail.com and password Qwertyu_1

  Scenario: Check Add Project page
    When user clicks add project button
    Then add project page is displayed
