@g5_uiListTests

Feature: Trello Board Tests
  @g5_smoke
  @g5_regression
  Scenario: User creates a board on  trello webpage
    Given The user navigates to: https://support.atlassian.com/trello/docs/creating-a-list/
    And The user clicks the “Add another list” button on the right side of the board
    And The user enters a valid list name in the text field (e.g., “Today’s Tasks”).
    And The user clicks on the “Add” button.
    Then A new list is added to the board, becomes visible, and a “List successfully created” message is displayed.




