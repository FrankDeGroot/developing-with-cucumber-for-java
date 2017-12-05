Feature: Shopping Basket

  Background:
    Given A 'banana' is in stock
    Given A 'blood orange' is in stock
    Given A 'banana' is 1 euro
    Given A 'blood orange' is 2 euros

  @HappyFlow
  Scenario Outline: Adding an item
    Given My basket is empty
    When I add a '<product>' to my basket
    Then My basket contains a '<product>'
  Examples:
    | product |
    | banana |
    | blood orange |

  @HappyFlow
  Scenario: Removing an item
    Given My basket is empty
    When I add a 'banana' to my basket
    And I remove a 'banana' from my basket
    Then My basket does NOT contain a 'banana'

  @UnhappyFlow
  Scenario: Adding an empty item
    Given My basket is empty
    When I add a '' to my basket
    Then I get an Empty Product error
    And My basket does NOT contain a ''

  @HappyFlow
  Scenario: Adding the same item twice
    Given My basket is empty
    When I add a 'banana' to my basket
    And I add a 'banana' to my basket
    Then I should have 2 'banana's in my basket

  Scenario: Adding an out-of-stock product
    Given My basket is empty
    Given A 'banana' is out of stock
    When I add a 'banana' to my basket
    Then My basket does NOT contain a 'banana'

  Scenario: Calculate total
    Given My basket is empty
    When I add a 'banana' to my basket
    And I add a 'blood orange' to my basket
    Then The total of my basket is 3 euros

  Scenario: Calculate total with same item twice
    Given My basket is empty
    When I add a 'banana' to my basket
    And I add a 'banana' to my basket
    And I add a 'blood orange' to my basket
    Then The total of my basket is 4 euros
