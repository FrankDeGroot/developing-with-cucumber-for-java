Feature: Shopping Basket
  Scenario: Adding an item
    Given My basket is empty
    When I add a banana to my basket
    Then My basket contains a banana

  Scenario: Adding a different item
    Given My basket is empty
    When I add a 'blood orange' to my basket
    Then My basket contains a 'blood orange'
