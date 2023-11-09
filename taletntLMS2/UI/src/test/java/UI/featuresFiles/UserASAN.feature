@CD
Feature: User Page Test

  Background: Given Admin Login User Page
    Given admin into the system
  Scenario: User div test
    When Admin click on Users div button
    Then Admin should see "Home/Users" header text
  Then Admin test API