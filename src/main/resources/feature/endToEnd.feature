Feature: Successful Purchase on Demoblaze

  Scenario Outline: User logs in, adds products to cart, and completes a purchase
    Given user open homepage & click on login button
    When user enters username & password & press on login button
    Then user is switched to loginAlert & success message appear

    When the user click on Laptops and adds the first product to the cart
    Then an alert message should contain "Product added"

    When the user click on to Laptops again and adds the second product to the cart
    Then another alert message should contain "Product added"

    When the user goes to the cart page
    Then the cart should contain two products
    And the total price should be the sum of the two product prices

    When the user places the order with name "<name>", country "<country>", city "<city>", credit card "<credit>", month "<month>", and year "<year>"
    Then the user should see a success message "Thank you for your purchase!"
    Examples:
      | name  | country | city       | credit           | month | year |
      | Menna | Egypt   | Alexandria | 1234567890123456 | 12    | 26   |

  Scenario: User logs in, adds products to cart, and completes a purchase
    Given user open homepage & click on login button
    When user enters username & password & press on login button
    Then user is switched to loginAlert & success message appear

    When the user click on Laptops and adds the first product to the cart
    Then an alert message should contain "Product added"

    When the user click on Laptops and adds the first product to the cart
    Then another alert message should contain "Product added"

    When the user goes to the cart page
    Then the cart should contain two products