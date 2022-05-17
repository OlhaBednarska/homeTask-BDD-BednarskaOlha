Feature: Smoke
  As a user
  I want to test all main site functionality
  So that I can be sure that site works correctly


  Scenario Outline: Check total price in cart
    Given User opens '<homePage>' page
    And User checks search field visibility
    When User makes search by keyword '<searchKeyword>'
    And User clicks search button
    And User checks search results page visibility
    When User makes search by brand '<brandKeyword>'
    And User clicks brand button
    And User clicks filter button
    And User clicks expensive button
    And User click on product
    And User checks product page visibility
    And User clicks 'Add to cart' button
    And User checks cart pop-up visibility
    Then User checks that total price in cart is not equals to '<totalPrice>'

    Examples:
      | homePage                   | searchKeyword | brandKeyword | totalPrice |
      | https://rozetka.com.ua/ua/ | Телефон       | Samsung      | 200100     |
