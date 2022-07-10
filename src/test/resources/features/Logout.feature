@PERF-1524
Feature: Logout


  Background:
    Given  user is on the Dashboard page

@PERF-1520
Scenario: logout by clicking logout button
    When user clicks on profile dropdown
    And user clicks on logout button
    Then user is on the login page


@PERF-1521
Scenario: can not step back after logout
    When user clicks on profile dropdown
    And user clicks on logout button
    Then user clicks on step back button on the browser
    Then user should be still on the login page

  @wip
@PERF-1522
  Scenario: user must be logout if close the browser
      When user copied current url
      And user close the browser
      Then user open new page with copied url
      Then user should be still on the login page

  @PERF-1523
    Scenario: away from keyboard for 3 minutes
      When user away from keyboard for 3 minutes
      Then user should be logout automatically