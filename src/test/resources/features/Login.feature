Feature: Login  - With parameters:


  Background:
    Given The user is on the login page

  @PERF-1493
  Scenario: Login as a Driver
    When The user logs in as a "Driver"
    Then The user is on the "Quick Launchpad" page

  @PERF-1494
  Scenario: Login as a Sales Manager
    When The user logs in as a "Sales Manager"
    Then The user is on the "Dashboard" page

  @PERF-1495
  Scenario: Login as a Store Manager
    When The user logs in as a "Store Manager"
    Then The user is on the "Dashboard" page



  @PERF-1499
  Scenario: login without credential
    When the user logs in as "Driver"
    And the user copy the current url
    Then the user clicks on logout button
    Then the user goes to copied url
    Then the user should be on the "Login" page

  @wip
  Scenario Outline: Can not login with invalid credentials - Negative Scenario
    When the user enters "<username>" and "<password>"
    Then user should see warning message "Invalid user name or password."
    Examples:
      | username        | password      |
      | salesmanager101 | nofivdsfno    |
      | invalid         | UserUser123   |
      | nidasiond       | 21378g2bc!@@@ |
      | abcdefgh        | UserUser123   |
      | storemanager51  | aad3412!      |
      | asdaw           | sdf323'+%     |





