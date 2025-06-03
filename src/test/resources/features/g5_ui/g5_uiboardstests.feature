@g5_uiboardstests

Feature: CRTB-001 Trello UI Board Tests
#  CRBT:Create Board

  @g5_smoke
  @g5_regression
  Scenario: CRTB-001 TC-001 Create a Board
#   Given The user is directed to the home page
    Then Home page titles such as "Trello, Workspaces, History, Starred, Templates, Create, Boards, Home" appear
    When user Clicks the Create button on the home page
    When the user verify that Background, Board Title, Visibility titles are visible
      | Background  |
      | Board title |
      | Visibility  |
    When the user verify that Background, Visibility and Board Title should be selected. The Create button is clicked
    Then the user verify that the created board appears on the home page
#    And The user close application

  @g5_smoke
  @g5_regression
  Scenario: CRTB-001 TC-002 Board Background Selection
    When user Clicks the Create button on the home page
    Then The user verify that Under the Background heading there are sample images and a ... button to view more images and above the Background heading there is a small board example.
#    And The user close application










#  function turnOnDebugger(a) {
#  setTimeout(() => {
#  debugger;
#  }, 1000); // optional delay
#  }

#  setTimeout(() => { debugger; }, 1000);






