Feature: Параметризированные тесты

  Scenario: Параметризация шагов (степов)
    Given открыт браузер
    * страница логина открыта
    When user "atrostyanko@gmail.com" with password "Qwertyu_1" log in
    Then page title is All Projects
    And project ID is 123
    And project ID is "123"
    And project ID equal to 123
    And all elements are visible
    And all elements are not visible
    And all elements "are" visible
    And all elements "are not" visible

  Scenario Outline: Параметризация с использованием таблицы значений
    Given открыт браузер
    * страница логина открыта
    When user "<username>" with password "<password>" log in
    Then project ID is <projectID>

    Examples:
      | username               | password  | projectID |
      | atrostyanko@gmail.com  | Qwertyu_1 | 123       |
      | atrostyanko1@gmail.com | Qwertyu_1 | 124       |
      | atrostyanko2@gmail.com | Qwertyu_1 | 125       |

  Scenario: Параметризация шага с большим количеством данных
    Given открыт браузер
    * страница логина открыта
    When user logged in with
      | username | atrostyanko@gmail.com |
      | password | Qwertyu_1             |
      | age      | 46                    |
      | sex      | M                     |
    Then page title is All Projects
    Then project ID is 123

  Scenario: Параметризация шага с большим количеством данных в обдном шаге
    Given открыт браузер
    * страница логина открыта
    When user logged in with 1
      | username               | password  | age | sex |
      | atrostyanko@gmail.com  | Qwertyu_1 | 46  | M   |
      | atrostyanko1@gmail.com | Qwertyu_2 | 23  | F   |
    Then page title is All Projects
    Then project ID is 123