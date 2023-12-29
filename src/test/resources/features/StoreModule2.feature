@StoreModule
Feature: Store Module feature

  @CreateNewOrder
  Scenario: Store Manager should be able to create a new order
    When user clicks on create order and follow the steps pick the store and add products and related information
    Then new order should be created

  @UpdateOrder
  Scenario: Store Manager should be able to Edit An Existing Order
    When user finds specific order from data table and edit by following steps and save
    Then success confirmation message should displays

  @CancelOrder
  Scenario: Store Manager should be able to cancel an order
    When user find the specific order from data table and click on cancel button and accept alert
    Then confirmation message should displays for cancellation

