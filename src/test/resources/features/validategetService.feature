Feature: Validate GET API service request and response

  Background:
    Given Get Request is working

  @FunctionTests
  Scenario: Validate get response
    Then Response should return success with True
    And Failure with empty response

  @FunctionTests
  Scenario Outline: Validate Flight Name with Flight Number
    When Flight number is <flight_number>
     Then the Flight name with respect to flight num is <flightNameVal>

    Examples:
      | flight_number | flightNameVal |
      | 142           | "Türksat 5B"  |

  @FunctionTests_TODO
  Scenario: Validate date response
    Then validate whether date format is correct

  @FunctionTests_TODO
  Scenario: Validate id response
    Then valid id should be generated