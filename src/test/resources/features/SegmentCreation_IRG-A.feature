Feature: Test Segment Creation Workflow as IRG-A Actor

  As a IRG-A user
  I want to create segments from cases
  So that I can assign segment to correct state for further investigation

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
#      |AutoQA-case-0004|
#      |AutoQA-case-0005|
#      |AutoQA-case-0015|

  @web
  Scenario: Change state from Segment Preparation to IRG-M Close as IRG-A user using a CF code
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
    And user checks case "2019-1153138" case state changed to "6" and segment state changed to "4"

  @web
  Scenario: Change state from Segment Preparation to FOS - Upgrade as IRG-A user using a CF Code
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
    When user selects destination as "FOS - Upgrade"
    And IRG assignee as "irg-a.test"
    And MO reviewers as "Test MO Group"
    And add Comment "Move state from Segment Preparation to FOS-Upgrade"
    Then save new segment button gets enabled
    When user click save new segment button
    Then user sees submit segment button
    When user clicks on submit segment button
    Then user returns to dashboard page
    And user checks case "2019-1152727" case state changed to "6" and segment state changed to "15"


  @web
  Scenario: Change state from Segment Preparation to MO Segment Review as IRG-A user
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
    When user selects destination as "MO Segment Review"
    And IRG assignee as "irg-a.test"
    And MO reviewers as "Test MO Group"
    And add Comment "Move state from Segment Preparation to MO Segment Review"
    Then save new segment button gets enabled
    When user click save new segment button
    Then user sees submit segment button
    When user clicks on submit segment button
    Then user returns to dashboard page
    And user checks case "2019-1152613" case state changed to "6" and segment state changed to "14"





