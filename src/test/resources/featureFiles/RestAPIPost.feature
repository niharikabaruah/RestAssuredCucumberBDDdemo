Feature: Dummy Rest API Functionality Scenarios

  Scenario Outline: Dummy Rest Api GET Students
    Given Get Call to "<url>"
    Then Response Code "<responseMessage>" is validated

    Examples:
      | url      | responseMessage |
      | /users | 200             |
      |/users  | 400             |

  Scenario Outline:  Verify Code
    Given Get Call to "<url>"
    Then Response  is array total "<total>"

    Examples:
      | url      | total |
      | /users | 3    |

  Scenario Outline: Rest Api GET Students by id
    Given Get Call to "<url>" with id
    Then Response Code "<responseMessage>" is validated for the id
    Examples:
      | url | responseMessage |
      | /users/a3b9 | 200     |
