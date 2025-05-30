@g5_uicardtests

Feature: Create a new card in a Trello board
  As a user
  I want to create a new card on an existing list
  So that I can track my tasks effectively

  Background:
    Given The user is logged into the application with valid credentials
    And The user has access to a board that contains at least one list
    And The user has permission to create cards on the board

  Scenario: Create a new card on an existing list
    Given The user navigates to "https://trello.com/b/[boardID]/[board-name]"
    When The user clicks on the "Add a card" option under an existing list
    And The user enters a valid card title "Daily standup notes"
    And The user clicks the "Add Card" button
    Then The new card titled "Daily standup notes" should be visible under the selected list