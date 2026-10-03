#Feature: Test FoS-Upgrade Workflow as IRG-M Actor
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
#
#  @web
#  Scenario: Change state from Segment Preparation to FOS - Upgrade as IRG-A user then change to IRG-A Close State as IRG-M user
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
#    And IRG assignee as "irg-a.test"
#    And MO reviewers as "Test MO Group"
#    And add Comment "Move state from Segment Preparation to FOS-Upgrade"
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
#    And user checks case "2019-1153138" case state changed to "6" and segment state changed to "18"
#
#  @web
#  Scenario: Change state from Segment Preparation to FOS - Upgrade as IRG-A user then change to FOS Segment Review State as IRG-M user
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
#    And IRG assignee as "irg-a.test"
#    And MO reviewers as "Test MO Group"
#    And add Comment "Move state from Segment Preparation to FOS-Upgrade"
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
#    And selects "FOS Segment Review" as destination from FOS Upgrade
#    And disable Email Notification
#    And adds the description "Move case from FOS Upgrade to FOS Segment Review State" in FOS Upgrade
#    Then the submit button is enables in FOS Upgrade
#    When user clicks on submit button in FOS Upgrade
#    Then user returns to dashboard page
#    And user checks case "2019-1152727" case state changed to "6" and segment state changed to "3"