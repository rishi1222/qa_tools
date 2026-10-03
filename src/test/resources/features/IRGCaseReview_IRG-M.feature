Feature: Test IRG Case Review Workflow as IRG-M Actor

  As a IRG-M user
  I want to create a fully segmented case
  So that I can analyse it further in Case Review State

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

  @web
  Scenario:Use a fully segmented case and change state from IRG Case Review to Escalated FOS case Review as IRG-M user
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
    When user selects destination as "FOS - Upgrade"
    And IRG assignee as "irg-a.test"
    And MO reviewers as "Test MO Group"
    And add Comment "Move state from Segment Preparation to FOS-Upgrade"
    Then save new segment button gets enabled
    When user click save new segment button
    Then user sees submit segment button
    When user clicks on submit segment button
    Then user returns to dashboard page
    And selects an actor "irg-m.test@db.com"
    When user clicks case "2019-1153138" under FOS-Upgrade
    Then Fos Upgrade page opens
    When user clicks on Change IRG and MO reviewers link in FOS Upgrade
    And user selects "irg-m.test" as new assignee in FOS Upgrade
    And checks new MO reviewers "MO Review" in FOS Upgrade
    And selects "FOS Segment Review" as destination from FOS Upgrade
    And disable Email Notification
    And adds the description "Move case from FOS Upgrade to FOS Segment Review State" in FOS Upgrade
    Then the submit button is enables in FOS Upgrade
    When user clicks on submit button in FOS Upgrade
    Then user returns to dashboard page
    And selects an actor "irg-a.test@db.com"
    When user clicks case "2019-1153138" under Case Review
    Then the Case Review Page Opens
    When user selects destination as "IRG Case Review" under Case Review
#    And selects fos "foco.test"
#    And selects fos-s "fos-s.test"
    And CF code from dropdown as "Escalation" under Case Review
    And add Comment "Move case state from Case Review to IRG Case Review" under Case Review
    And the user uploads file
    And user clicks on submit button in Case Review
    Then user returns to dashboard page
    And selects an actor "irg-m.2.test@db.com"
    When user clicks case "2019-1153138" under IRG Case Review
    Then the IRG Case Review Page Opens
    When user selects destination as "Escalated FOS Case Review" under IRG Case Review
#    And CF code from dropdown as "Escalation" under IRG Case Review
    And add Comment "Move case state from IRG Case Review to Escalated Fos Case Review" under IRG Case Review
    And user clicks on submit button in IRG Case Review
    Then user returns to dashboard page
    And user checks case "2019-1153138" case state changed to "9" and segment state changed to "3"

  @web
  Scenario:Use a fully segmented case and change state from IRG Case Review to Case Closed as IRG-M user
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
    And selects an actor "irg-m.test@db.com"
    When user clicks case "2019-1152727" under FOS-Upgrade
    Then Fos Upgrade page opens
    When user clicks on Change IRG and MO reviewers link in FOS Upgrade
    And user selects "irg-m.test" as new assignee in FOS Upgrade
    And checks new MO reviewers "MO Review" in FOS Upgrade
    And selects "FOS Segment Review" as destination from FOS Upgrade
    And disable Email Notification
    And adds the description "Move case from FOS Upgrade to FOS Segment Review State" in FOS Upgrade
    Then the submit button is enables in FOS Upgrade
    When user clicks on submit button in FOS Upgrade
    Then user returns to dashboard page
    And selects an actor "irg-a.test@db.com"
    When user clicks case "2019-1152727" under Case Review
    Then the Case Review Page Opens
    When user selects destination as "IRG Case Review" under Case Review
#    And selects fos "foco.test"
#    And selects fos-s "fos-s.test"
    And CF code from dropdown as "Escalation" under Case Review
    And add Comment "Move case state from Case Review to IRG Case Review" under Case Review
    And the user uploads file
    And user clicks on submit button in Case Review
    Then user returns to dashboard page
    And selects an actor "irg-m.2.test@db.com"
    When user clicks case "2019-1152727" under IRG Case Review
    Then the IRG Case Review Page Opens
    When user selects destination as "Escalated FOS Case Review" under IRG Case Review
#    And CF code from dropdown as "Escalation" under IRG Case Review
    And add Comment "Move case state from IRG Case Review to Case Closed" under IRG Case Review
    And user clicks on submit button in IRG Case Review
    Then user returns to dashboard page
    And user checks case "2019-1152727" case state changed to "9" and segment state changed to "3"


#  @web
#  Scenario:Use a fully segmented case and change state from IRG Case Review to Case BPM Closed as IRG-M user
#    Given the user opens the webpage
#    And sets the state of "2019-1152613" to Segment Preparation State
#    When user clicks on user dropDown
#    And selects an actor "irg-m.test@db.com"
#    Then user checks case "2019-1152613" exits under Segment Preparation
#    When user clicks case "2019-1152613" under Segment Preparation
#    Then segment creation page opens
#    When user checks all trades in a case
#    Then Create Segment Button is enabled
#    When user click on Create Segment
#    Then Create Segment Pop screen comes up
#    When user selects destination as "FOS Segment Review"
#    And IRG assignee as "irg-m.test"
#    And MO reviewers as "Test MO Group"
#    And add Comment "Move state from Segment Preparation to FOS Segment Review"
#    Then save new segment button gets enabled
#    When user click save new segment button
#    Then user sees submit segment button
#    When user clicks on submit segment button
#    Then user returns to dashboard page
#    And selects an actor "irg-m.test@db.com"
#    When user clicks case "2019-1152613" under Case Review
#    Then the Case Review Page Opens
#    When user selects destination as "IRG Case Review" under Case Review
#    And CF code from dropdown as "Escalation" under Case Review
#    And add Comment "Move case state from Case Review to IRG Case Review" under Case Review
#    And user clicks on submit button in Case Review
#    Then user returns to dashboard page
#    And selects an actor "irg-m.2.test@db.com"
#    When user clicks case "2019-1152613" under IRG Case Review
#    Then the IRG Case Review Page Opens
#    When user selects destination as "Case BPM Closed" under IRG Case Review
#    And CF code from dropdown as "Escalation" under IRG Case Review
#    And add Comment "Move case state from IRG Case Review to Case BPM Closed" under IRG Case Review
#    And user clicks on submit button in IRG Case Review
#    Then user returns to dashboard page
#    And user checks case "2019-1152613" case state changed to "17" and segment state changed to "3"

#  @web
#  Scenario:Use a fully segmented case and change state from IRG Case Review to Case Review as IRG-M user
#    Given the user opens the webpage
#    And sets the state of "2019-1152538" to Segment Preparation State
#    When user clicks on user dropDown
#    And selects an actor "irg-m.test@db.com"
#    Then user checks case "2019-1152538" exits under Segment Preparation
#    When user clicks case "2019-1152538" under Segment Preparation
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
#    When user clicks case "2019-1152538" under FOS-Upgrade
#    Then Fos Upgrade page opens
#    When user clicks on Change IRG and MO reviewers link in FOS Upgrade
#    And user selects "irg-m.test" as new assignee in FOS Upgrade
#    And checks new MO reviewers "MO Review" in FOS Upgrade
#    And selects "FOS Segment Review" as destination from FOS Upgrade
#    And disable Email Notification
#    And adds the description "Move case from FOS Upgrade to FOS Segment Review State" in FOS Upgrade
#    Then the submit button is enables in FOS Upgrade
#    When user clicks on submit button in FOS Upgrade
#    Then user returns to dashboard page
#    And selects an actor "irg-m.test@db.com"
#    When user clicks case "2019-1152538" under Case Review
#    Then the Case Review Page Opens
#    When user selects destination as "IRG Case Review" under Case Review
##    And selects fos "foco.test"
##    And selects fos-s "fos-s.test"
#    And CF code from dropdown as "Escalation" under Case Review
#    And add Comment "Move case state from Case Review to IRG Case Review" under Case Review
#    And user clicks on submit button in Case Review
#    Then user returns to dashboard page
#    And selects an actor "irg-m.2.test@db.com"
#    When user clicks case "2019-1152538" under IRG Case Review
#    Then the IRG Case Review Page Opens
#    When user selects destination as "Case Review" under IRG Case Review
##    And CF code from dropdown as "Escalation" under IRG Case Review
#    And add Comment "Move case state from IRG Case Review to Case Review" under IRG Case Review
#    And user clicks on submit button in IRG Case Review
#    Then user returns to dashboard page
#    And user checks case "2019-1152538" case state changed to "6" and segment state changed to "3"