Feature: Test FOS Segment Review Workflow as FOS-Test Actor



  As a Fos-Test user
  I want to analyse the segment
  So that I can identify anomalies is trade

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
##      |AutoQA-case-0002|
##      |AutoQA-case-0003|
##      |AutoQA-case-0004|
##      |AutoQA-case-0005|
##      |AutoQA-case-0015|
##
#  @web
#  Scenario: Change state from Segment Preparation to FOS Segment Review as IRG-M user and then from  FOS Segment Review to IRG-A Close as FOS user
#    Given the user opens the webpage
#    And sets the state of "2019-1153138" to Segment Preparation State
#    When user clicks on user dropDown
#    And selects an actor "irg-m.test@db.com"
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
#    And add Comment "Move state from Segment Preparation to FOS Upgrade"
##    And disable Email Notification
#    Then save new segment button gets enabled
#    When user click save new segment button
#    Then user sees submit segment button
#    When user clicks on submit segment button
#    Then user returns to dashboard page
#    And selects an actor "irg-m.2.test@db.com"
#    When user clicks case "2019-1153138" under FOS-Upgrade
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
#    When user clicks case "2019-1153138" in FosSegmentReviewPage
#    Then the Case Review Page Opens
#    Then user see FOS drop down to re-assign the case
#    When user selects "fos.test" from FOS drop down
#    And user selects "fos-s.test" from FOS-S drop down
#    And add Comment "This case is being re-assigned to fos.test"
#    And the user uploads file
#    And user clicks on submit button
#     #Then the case gets assigned to FOS user
#    Then user returns to dashboard page
#    And selects an actor "irg-m.test@db.com"
#    When user clicks case "2019-1153138" under Case Review
#    Then the Case Review Page Opens
#    When the irg-m approves
#    And add Comment "Re-assining the case to fos user" under Case Review
#    And user clicks on submit button in Case Review
#    Then user returns to dashboard page
#    And selects an actor "fos.test@db.com"
#    When user clicks case "2019-1153138" under FOS Segment Review
#    Then the FOS Segment Review Page opens
#    When user selects destination as "Propose Segment Close" under FosSegmentReviewPage
#    And add Comment "Move state from  FOS Segment Review to IRG-A Close" under FosSegmentReviewPage
#    And user clicks on submit button
#    Then user returns to dashboard page
#    And user checks case "2019-1153138" case state changed to "6" and segment state changed to "18"
