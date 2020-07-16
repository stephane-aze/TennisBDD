Feature: Tennis
  Scenario: begin the game
    Given Paul play a match against Sam
    When The game starts
    Then The score should be "love-all"

  Scenario: Paul win the first point
    Given Paul play a match against Sam
    And Paul starts the game
    When Sam wins the point
    Then The score should be "love-fifteen"

  Scenario: Sam win the first two points
    Given Paul play a match against Sam
    And The score is "fifteen-love"
    When Paul wins the point
    Then The score should be "thirty-love"

  Scenario: Sam have three game points
    Given Paul play a match against Sam
    And The score is "love-thirty"
    When Sam wins the point
    Then The score should be "love-forty"
    And Sam should have 3 game points

  Scenario: Paul wins the match four points part
    Given Paul play a match against Sam
    And The score is "forty-love"
    When Paul wins the point
    Then Paul should win the match

  Scenario: Paul win the match three points part
    Given Paul play a match against Sam
    And The score is "forty-fifteen"
    When Paul wins the point
    Then Paul should win the match

  Scenario: Advantage Paul
    Given Paul play a match against Sam
    And The score is "deuce"
    When Paul wins the point
    Then The score should be "AD Paul"
    And Paul should have 1 game points

  Scenario: Paul wins the match after advantage
    Given Paul play a match against Sam
    And The score is "AD Paul"
    When Paul wins the point
    Then Paul should win the match

  Scenario: The score is deuce after a advantage
    Given Paul play a match against Sam
    And The score is "AD Paul"
    When Sam wins the point
    Then The score should be "deuce"

  Scenario:
    Given Paul play a match against Sam
    And The score is "thirty-all"
    When Paul wins the point
    Then The score should be "forty-thirty"