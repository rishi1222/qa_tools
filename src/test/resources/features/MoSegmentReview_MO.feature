Feature: Test MO Segment Review Workflow as MO Actor

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
#      | AutoQA-case-0002 |

  @web
  Scenario: Change state from Segment Preparation to MO Segment Review as IRG-A user and then change it to IRG-A close as MO Test User
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
    When user selects destination as "MO Segment Review"
    And IRG assignee as "irg-a.test"
    And MO reviewers as "Test MO Group"
    And add Comment "Move state from Segment Preparation to MO Segment Review"
    Then save new segment button gets enabled
    When user click save new segment button
    Then user sees submit segment button
    When user clicks on submit segment button
    Then user returns to dashboard page
    And selects an actor "mo.test@db.com"
    When user clicks case "2019-1153138" under MO Segment Review
    Then the MO Segment Review Page opens
    And user selects destination as "Propose Segment Close" under MoSegmentReviewPage
    And select CFcode under MoSegmentReview
    And add Comment "Move state from  MO Segment Review to IRG-M Close" under MoSegmentReviewPage
    And user clicks on submit button in MoSegmentReviewPage
    Then user returns to dashboard page
    And user checks case "2019-1153138" case state changed to "6" and segment state changed to "18"