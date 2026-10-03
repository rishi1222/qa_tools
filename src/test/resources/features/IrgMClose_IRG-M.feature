Feature: Test IRG-M Close Workflow as IRG-M Actor

  As a IRG-A user
  I want to create segments from cases

  @dataBase
  Scenario Outline: Clean database before loading application
    Given a list of cases to be used as "<testData>"
    When user refreshes the dataBase
      | CAT_TRADES             |
      | CAT_SEGMENT_VISIBILITY |
      | CAT_SEGMENT_EMAIL   |
      | CAT_SEGMENT_COMMENTS   |
      | CAT_SEGMENT_USER_TAG   |
      | CAT_CASE_VISIBILITY    |
      | CAT_ATTACHMENTS    |
      | CAT_CASE_COMMENTS      |
      | CAT_SEGMENT_STATUS     |
    Then user is able to use the testdata again

    Examples:
      | testData         |
      | 2019-1153138 |
      | 2019-1152727 |
      | 2019-1152613 |
      | 2019-1152538 |
###      |AutoQA-case-0015|

  @web
  Scenario: Change state from Segment Preparation to IRG-M Close as IRG-A user and then change the state from IRG-M Close to FOS Segment Review as IRG-M user
    Given the user opens the webpage
    And sets the state of "2019-1153138" to Segment Preparation State
    When user clicks on user dropDown
    And selects an actor "irg-a.test@db.com"
    Then user checks case "2019-1153138" exits under Segment Preparation
    When user clicks case "2019-1153138" under Segment Preparation
    Then segment creation page opens
    When user checks all trades in a case
    Then Create Segment Button is enabled
    When user click on Create Segment
    Then Create Segment Pop screen comes up
    When user selects destination as "IRG-M Close"
    And CFcode from dropDown "Escalation"
    And IRG assignee as "irg-m.test"
    And MO reviewers as "Test MO Group"
    And add Comment "Move state from Segment Preparation to IRG-M Close"
    Then save new segment button gets enabled
    When user click save new segment button
    Then user sees submit segment button
    When user clicks on submit segment button
    Then user returns to dashboard page
    When user selects an actor "irg-m.test@db.com"
    Then user checks case "2019-1153138" exits under IRG-M Close
    When user clicks case "2019-1153138" under IRG-M Close
    Then IRG-M Close page opens
    When user clicks on Change IRG and MO reviewers link
    And user selects "irg-m.test" as new assignee
    And checks new MO reviewers "MO Review"
    And selects "FOS Segment Review" as destination
    And adds the description "move case from IRG-M Close to FOS-Segment-Review"
    Then the submit button is enables
    When user clicks on submit button
    Then user returns to dashboard page
    And user checks case "2019-1153138" case state changed to "6" and segment state changed to "3"

  @web
  Scenario: Change state from Segment Preparation to IRG-M Close as IRG-A user using a CF code and then change the state from IRG-M Close to Segment Closed State as IRG-M user
    Given the user opens the webpage
    And sets the state of "2019-1152727" to Segment Preparation State
    When user clicks on user dropDown
    And selects an actor "irg-a.test@db.com"
    Then user checks case "2019-1152727" exits under Segment Preparation
    When user clicks case "2019-1152727" under Segment Preparation
    Then segment creation page opens
    When user checks all trades in a case
    Then Create Segment Button is enabled
    When user click on Create Segment
    Then Create Segment Pop screen comes up
    When user selects destination as "IRG-M Close"
    And CFcode from dropDown "Escalation"
    And IRG assignee as "irg-m.test"
    And MO reviewers as "Test MO Group"
    And add Comment "Move state from Segment Preparation to IRG-M Close"
    Then save new segment button gets enabled
    When user click save new segment button
    Then user sees submit segment button
    When user clicks on submit segment button
    Then user returns to dashboard page
    When user selects an actor "irg-m.test@db.com"
    Then user checks case "2019-1152727" exits under IRG-M Close
    When user clicks case "2019-1152727" under IRG-M Close
    Then IRG-M Close page opens
    When user clicks on Change IRG and MO reviewers link
    And user selects "irg-m.test" as new assignee
    And checks new MO reviewers "MO Review"
    And selects "Segment Closed" as destination
    And select ClientDriven-Cancellation under IRG-M Close
    And adds the description "Move case from IRG-M Close to Segment Closed"
    Then the submit button is enables
    When user clicks on submit button
    Then user returns to dashboard page
    And user checks case "2019-1152727" case state changed to "8" and segment state changed to "5"

  @web
  Scenario: Change state from Segment Preparation to IRG-M Close as IRG-A user and then change the state from IRG-M Close to MO Segment Review State as IRG-M user
    Given the user opens the webpage
    And sets the state of "2019-1152613" to Segment Preparation State
    When user clicks on user dropDown
    And selects an actor "irg-a.test@db.com"
    Then user checks case "2019-1152613" exits under Segment Preparation
    When user clicks case "2019-1152613" under Segment Preparation
    Then segment creation page opens
    When user checks all trades in a case
    Then Create Segment Button is enabled
    When user click on Create Segment
    Then Create Segment Pop screen comes up
    When user selects destination as "IRG-M Close"
    And CFcode from dropDown "Escalation"
    And IRG assignee as "irg-m.test"
    And MO reviewers as "Test MO Group"
    And add Comment "Move state from Segment Preparation to IRG-M Close"
    Then save new segment button gets enabled
    When user click save new segment button
    Then user sees submit segment button
    When user clicks on submit segment button
    Then user returns to dashboard page
    When user selects an actor "irg-m.test@db.com"
    Then user checks case "2019-1152613" exits under IRG-M Close
    When user clicks case "2019-1152613" under IRG-M Close
    Then IRG-M Close page opens
    When user clicks on Change IRG and MO reviewers link
    And user selects "irg-m.test" as new assignee
    And checks new MO reviewers "MO Review"
    And selects "MO Segment Review" as destination
    And adds the description "Move case from IRG-M Close to MO Segment Review"
    Then the submit button is enables
    When user clicks on submit button
    Then user returns to dashboard page
    And user checks case "2019-1152613" case state changed to "6" and segment state changed to "14"


  @web
  Scenario: Change state from Segment Preparation to IRG-M Close as IRG-A user and then change the state from IRG-M Close to IRG-A Close as IRG-M user
    Given the user opens the webpage
    And sets the state of "2019-1152538" to Segment Preparation State
    When user clicks on user dropDown
    And selects an actor "irg-a.test@db.com"
    Then user checks case "2019-1152538" exits under Segment Preparation
    When user clicks case "2019-1152538" under Segment Preparation
    Then segment creation page opens
    When user checks all trades in a case
    Then Create Segment Button is enabled
    When user click on Create Segment
    Then Create Segment Pop screen comes up
    When user selects destination as "IRG-M Close"
    And CFcode from dropDown "Escalation"
    And IRG assignee as "irg-m.test"
    And MO reviewers as "Test MO Group"
    And add Comment "Move state from Segment Preparation to IRG-M Close"
    Then save new segment button gets enabled
    When user click save new segment button
    Then user sees submit segment button
    When user clicks on submit segment button
    Then user returns to dashboard page
    When user selects an actor "irg-m.test@db.com"
    Then user checks case "2019-1152538" exits under IRG-M Close
    When user clicks case "2019-1152538" under IRG-M Close
    Then IRG-M Close page opens
    When user clicks on Change IRG and MO reviewers link
    And user selects "irg-m.test" as new assignee
    And checks new MO reviewers "MO Review"
    And selects "IRG-A Close" as destination
    And adds the description "move case from IRG-M Close to IRG-A Close"
    Then the submit button is enables
    When user clicks on submit button
    Then user returns to dashboard page
    And user checks case "2019-1152538" case state changed to "6" and segment state changed to "18"