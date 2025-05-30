
@createaboard
Feature: Create Trello Board using API

  Scenario: Create a new Trello board with API
    Given I have valid API credentials
    When I create a new Trello board named "TestBoard"
#    Then the board should be created successfully
