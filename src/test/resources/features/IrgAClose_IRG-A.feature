#Feature: Test IRG-A Close Workflow as IRG-A Actor
#
#  As a IRG-A user
#  I want to create segments from cases
#
#  @dataBase
#  Scenario Outline: Clean database before loading application
#    Given a list of cases to be used as "<testData>"
#    When user refreshes the dataBase
#      | CAT_TRADES             |
#      | CAT_SEGMENT_VISIBILITY |
#      | CAT_SEGMENT_EMAIL   |
#      | CAT_SEGMENT_COMMENTS   |
#      | CAT_SEGMENT_USER_TAG   |
#      | CAT_CASE_VISIBILITY    |
#      | CAT_ATTACHMENTS    |
#      | CAT_CASE_COMMENTS      |
#      | CAT_SEGMENT_STATUS     |
#    Then user is able to use the testdata again
#
#    Examples:
#      | testData         |
#      | 2019-1153138 |
#      | 2019-1152727 |
#      | 2019-1152613 |
##      |AutoQA-case-0004|
##      |AutoQA-case-0005|
##      |AutoQA-case-0015|
##
#  @web
#  Scenario: Change state from Segment Preparation to  FOS - Upgrade as IRG-A user then change to IRG-A Close State as IRG-M user then change to IRG-M Close as IRG-A user
#    Given the user opens the webpage
#    And sets the state of "2019-1153138" to Segment Preparation State
#    When user clicks on user dropDown
#    And selects an actor "irg-a.test@db.com"
#    Then user checks case "2019-1153138" exits under Segment Preparation
#    When user clicks case "2019-1153138" under Segment Preparation
#    Then segment creation page opens
#    When user checks all trades in a case
#    Then Create Segment Button is enabled
#    When user click on Create Segment
#    Then Create Segment Pop screen comes up
#    When user selects destination as "FOS - Upgrade"
#    And IRG assignee as "irg-m.test"
#    And MO reviewers as "Test MO Group"
#    And add Comment "Move state from Segment Preparation to FOS - Upgrade"
#    Then save new segment button gets enabled
#    When user click save new segment button
#    Then user sees submit segment button
#    When user clicks on submit segment button
#    Then user returns to dashboard page
#    And selects an actor "irg-m.test@db.com"
#    When user clicks case "2019-1153138" under FOS-Upgrade
#    Then Fos Upgrade page opens
#    When user clicks on Change IRG and MO reviewers link in FOS Upgrade
#    And user selects "irg-a.test" as new assignee in FOS Upgrade
#    And checks new MO reviewers "MO Review" in FOS Upgrade
#    And selects "IRG-A Close" as destination from FOS Upgrade
#    And adds the description "Move case from FOS Upgrade to IRG-A Close" in FOS Upgrade
#    Then the submit button is enables in FOS Upgrade
#    When user clicks on submit button in FOS Upgrade
#    Then user returns to dashboard page
#    And selects an actor "irg-a.test@db.com"
#    When user clicks case "2019-1153138" under IRG-A Close
#    Then IRG-A Close page opens
#    When user clicks on Change IRG and MO reviewers link in IRG-A Close
#    And user selects "irg-m.test" as new assignee in IRG-A Close
#    And checks new MO reviewers "MO Review" in IRG-A Close
#    And selects "IRG-M Close" as destination from IRG-A Close
#    And select CFcode under IRG-A Close
#    And adds the description "Move case from IRG-A Close to IRG-M Close" in IRG-A Close
#    Then the submit button is enables in IRG-A Close
#    When user clicks on submit button in IRG-A Close
#    Then user returns to dashboard page
#    And user checks case "2019-1153138" case state changed to "6" and segment state changed to "4"
#
#  @web
#  Scenario: Change state from Segment Preparation to  FOS - Upgrade as IRG-A user then change to IRG-A Close State as IRG-M user then change to FOS - Upgrade as IRG-A user
#    Given the user opens the webpage
#    And sets the state of "2019-1152727" to Segment Preparation State
#    When user clicks on user dropDown
#    And selects an actor "irg-a.test@db.com"
#    Then user checks case "2019-1152727" exits under Segment Preparation
#    When user clicks case "2019-1152727" under Segment Preparation
#    Then segment creation page opens
#    When user checks all trades in a case
#    Then Create Segment Button is enabled
#    When user click on Create Segment
#    Then Create Segment Pop screen comes up
#    When user selects destination as "FOS - Upgrade"
#    And IRG assignee as "irg-m.test"
#    And MO reviewers as "Test MO Group"
#    And add Comment "Move state from Segment Preparation to FOS - Upgrade"
#    Then save new segment button gets enabled
#    When user click save new segment button
#    Then user sees submit segment button
#    When user clicks on submit segment button
#    Then user returns to dashboard page
#    And selects an actor "irg-m.test@db.com"
#    When user clicks case "2019-1152727" under FOS-Upgrade
#    Then Fos Upgrade page opens
#    When user clicks on Change IRG and MO reviewers link in FOS Upgrade
#    And user selects "irg-a.test" as new assignee in FOS Upgrade
#    And checks new MO reviewers "MO Review" in FOS Upgrade
#    And selects "IRG-A Close" as destination from FOS Upgrade
#    And adds the description "Move case from FOS Upgrade to IRG-A Close" in FOS Upgrade
#    Then the submit button is enables in FOS Upgrade
#    When user clicks on submit button in FOS Upgrade
#    Then user returns to dashboard page
#    And selects an actor "irg-a.test@db.com"
#    When user clicks case "2019-1152727" under IRG-A Close
#    Then IRG-A Close page opens
#    When user clicks on Change IRG and MO reviewers link in IRG-A Close
#    And user selects "irg-m.test" as new assignee in IRG-A Close
#    And checks new MO reviewers "MO Review" in IRG-A Close
#    And selects "FOS - Upgrade" as destination from IRG-A Close
#    And adds the description "Move case from IRG-A Close to FOS - Upgrade" in IRG-A Close
#    Then the submit button is enables in IRG-A Close
#    When user clicks on submit button in IRG-A Close
#    Then user returns to dashboard page
#    And user checks case "2019-1152727" case state changed to "6" and segment state changed to "15"
#
#  @web
#  Scenario: Change state from Segment Preparation to  FOS - Upgrade as IRG-A user then change to IRG-A Close State as IRG-M user then change to Mo Segment Review as IRG-A user
#    Given the user opens the webpage
#    And sets the state of "2019-1152613" to Segment Preparation State
#    When user clicks on user dropDown
#    And selects an actor "irg-a.test@db.com"
#    Then user checks case "2019-1152613" exits under Segment Preparation
#    When user clicks case "2019-1152613" under Segment Preparation
#    Then segment creation page opens
#    When user checks all trades in a case
#    Then Create Segment Button is enabled
#    When user click on Create Segment
#    Then Create Segment Pop screen comes up
#    When user selects destination as "FOS - Upgrade"
#    And IRG assignee as "irg-m.test"
#    And MO reviewers as "Test MO Group"
#    And add Comment "Move state from Segment Preparation to FOS - Upgrade"
#    Then save new segment button gets enabled
#    When user click save new segment button
#    Then user sees submit segment button
#    When user clicks on submit segment button
#    Then user returns to dashboard page
#    And selects an actor "irg-m.test@db.com"
#    When user clicks case "2019-1152613" under FOS-Upgrade
#    Then Fos Upgrade page opens
#    When user clicks on Change IRG and MO reviewers link in FOS Upgrade
#    And user selects "irg-a.test" as new assignee in FOS Upgrade
#    And checks new MO reviewers "MO Review" in FOS Upgrade
#    And selects "IRG-A Close" as destination from FOS Upgrade
#    And adds the description "Move case from FOS Upgrade to IRG-A Close" in FOS Upgrade
#    Then the submit button is enables in FOS Upgrade
#    When user clicks on submit button in FOS Upgrade
#    Then user returns to dashboard page
#    And selects an actor "irg-a.test@db.com"
#    When user clicks case "2019-1152613" under IRG-A Close
#    Then IRG-A Close page opens
#    When user clicks on Change IRG and MO reviewers link in IRG-A Close
#    And user selects "irg-a.test" as new assignee in IRG-A Close
#    And checks new MO reviewers "MO Review" in IRG-A Close
#    And selects "MO Segment Review" as destination from IRG-A Close
#    And adds the description "Move case from IRG-A Close to MO Segment Review" in IRG-A Close
#    Then the submit button is enables in IRG-A Close
#    When user clicks on submit button in IRG-A Close
#    Then user returns to dashboard page
#    And user checks case "2019-1152613" case state changed to "6" and segment state changed to "14"