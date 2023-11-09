Feature: Create max amount users and delete created users

  @CreateAndDelete
  Scenario: Positive scenario
    Given perform POST method to create max amount new users with mock Data
    Then status 5 created users and 200 status code returned
    When perform POST method to delete all users
    Then must be 1 user and 200 status code returned