@PERF-1518
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


  @PERF-1500
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


  @PERF-1501
  Scenario Outline: User should see proper warning messages for invalid credentials
    When the user enters "<username>" and "<password>"
    Then User should see warning message "Please fill out this field." in "<field>"

    Examples:
      | username | password    | field    |
      |          |             | username |
      | user21   |             | password |
      |          | UserUser123 | username |
      | Whatsapp |             | password |


  @PERF-1513
  Scenario:
    When user enters any "password" in password field
    Then user should see the bullet sign in field


  @PERF-1514
  Scenario Outline: User is able to land on Forgot Password page
    When user clicks Forgot your password? link
    And user is on "Forgot Password" page
    Then user enters valid "<username>"
    Then user should be able to change their password
    Examples:
      | username        |
      | user21          |
      | storemanager88  |
      | salesmanager121 |

  @PERF-1515
  Scenario Outline: Remember me function
    When User clicks Remember me on this computer checkbox
    And User enters "<username>" and "<password>"
    Then User closes the page then open it again
    Then User should be able to login on this computer
    Examples:
      | username        | password    |
      | user1           | UserUser123 |
      | storemanager51  | UserUser123 |
      | salesmanager101 | UserUser123 |


  @PERF-1516
  Scenario Outline: User can use "Enter" key to switch between fields
    When user enters the "<username>" and press Enter key
    Then user enters "<password>" and press Enter key
    Then the user should be on the "Dashboard" page
    Examples:
      | username        | password    |
      | user1           | UserUser123 |
      | storemanager51  | UserUser123 |
      | salesmanager101 | UserUser123 |

  @PERF-1517
  Scenario Outline:Users can see their own usernames
    When the user enters "<username>" and "<password>"
    Then user should see their "<username>" in the top right corner
    Examples:
      | username        | password    |
      | user1           | UserUser123 |
      | storemanager51  | UserUser123 |
      | salesmanager101 | UserUser123 |




