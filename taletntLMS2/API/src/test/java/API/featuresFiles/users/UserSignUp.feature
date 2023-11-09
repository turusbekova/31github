
@SignUp
Feature: User Signup


  Scenario: User SignUp Positive Scenario

    Given performe POST method to create new User with mock data
    Then status code 201 is returned

  Scenario: Create new User with mandatory fields
    Given performe POST method to create new User only without mandatory fields
    Then following error message is returned
      | "error": {"type": "invalid_request_error","message": "Invalid arguments provided"} |
    Then negative status code 400 is returned

  Scenario: Create new User with mandatory fields
    Given performe POST method to create new User only with mandatory fields without first_name field
    Then following error message is returned
      | "error": {"type": "invalid_request_error","message": "Invalid arguments provided"} |
    Then negative status code 400 is returned

  Scenario: Create new User with mandatory fields
    Given performe POST method to create new User only with mandatory fields without last_name field
    Then following error message is returned
      | "error": {"type": "invalid_request_error","message": "Invalid arguments provided"} |
    Then negative status code 400 is returned

  Scenario: Create new User with mandatory fields
    Given performe POST method to create new User only with mandatory fields without email field
    Then following error message is returned
      | "error": {"type": "invalid_request_error","message": "Invalid arguments provided"} |
    Then negative status code 400 is returned

  Scenario: Create new User with mandatory fields
    Given performe POST method to create new User only with mandatory fields without login field
    Then following error message is returned
      | "error": {"type": "invalid_request_error","message": "Invalid arguments provided"} |
    Then negative status code 400 is returned

  Scenario: Create new User with mandatory fields
    Given performe POST method to create new User only with mandatory fields without password field
    Then following error message is returned
      | "error": {"type": "invalid_request_error","message": "Invalid arguments provided"} |
    Then negative status code 400 is returned