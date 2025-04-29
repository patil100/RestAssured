Feature: API Automation using REST Assured

  Scenario: Verify GET API request
    Given I perform GET request on "/users/1"
    Then I should get response code 200



  Scenario: Verify POST API request
    Given I perform POST request on "/users"
    And I send request payload from pay_body

    Then I should get response code 201
    And response should contain "job" as "Senior Engineer"



