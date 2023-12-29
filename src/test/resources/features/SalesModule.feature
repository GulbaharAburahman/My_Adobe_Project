@SalesModuleTest
  Feature: Sales Module Feature

    @createOrder


    Scenario Outline: Sales Manager should be able to create a new order
      Given  on the dashboard page logged in as Role Sales Manager
      When    Click on Orders Link under the Sales then click on create new order button
      And    select the target customer from customer data table as "<email>"
      When   select a store by name as "<store>"
      Then   create a new order from selected store page displays
      When   Account information part select group as "<groupName>"
      And    click on Add products button, search product as "<productId>" and fill quantity as "<quantity>" , custom price as "<custom price>" atc
      And    click on radio button of payment method as "<paymentMethod>"
      And    click on submit order button
      Then   confirmation message should display to confirm order created with order number

      Examples:
      |email              | store |  groupName    | productId | custom price | quantity  |   paymentMethod   |
      |timthomas@gmail.com|Treat  |Team4 - Sweden |   1188    |80            |     2     | Cash on delivery|


