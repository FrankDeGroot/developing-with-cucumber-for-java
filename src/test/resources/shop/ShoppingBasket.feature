Feature: Shopping Basket
  Scenario Outline: Adding an item
    Given My basket is empty
    When I add a '<product>' to my basket
    Then My basket contains a '<product>'
    Examples:
      | product |
      | banana |
      | blood orange |
