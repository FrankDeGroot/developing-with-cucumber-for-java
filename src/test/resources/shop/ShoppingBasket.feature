Feature: Shopping Basket
  Scenario: Adding an item
    Given My basket is empty
    When I add a banana to my basket
    Then My basket should contain a banana
