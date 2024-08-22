Feature: Use Background and Rules

  Rule: Rule 1
    Background:
      Given открыт браузер
      * страница логина открыта

    Scenario: scenario 1
      When user "atrostyanko@gmail.com" with password "Qwertyu_1" log in
      Then page title is All Projects
      And project ID is 123

    Scenario: scenario 2
      When user "atrostyanko1@gmail.com" with password "Qwertyu_1" log in
      Then error "Error Message" is displayed

  Rule: Rule 2
    Background:
      Given открыт браузер
      * страница логина открыта

    Scenario: scenario 1
      When user "atrostyanko@gmail.com" with password "Qwertyu_1" log in
      Then page title is All Projects
      And project ID is 123

    Scenario: scenario 2
      When user "atrostyanko1@gmail.com" with password "Qwertyu_1" log in
      Then error "Error Message" is displayed