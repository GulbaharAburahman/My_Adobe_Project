@StoreManagerFeatures
Feature: Store Module feature
Background:
  Given Login to Admin Panel Page
  When  enter Valid username and password for Store Manager Role String "StoreManager"
  Then  Logged into Dashboard


  @CreateNewOrder
  Scenario: Store Manager should be able to create a new order
    When user clicks on create order and follow the steps pick the store and add products and related information
    Then new order should be created
    And  user should logout and close the browser

    @UpdateOrder
    Scenario: Store Manager should be able to Edit An Existing Order
      When user finds specific order from data table and edit by following steps and save
      Then success confirmation message should displays
      And user should logout and close the browser

      @CancelOrder
      Scenario: Store Manager should be able to cancel an order
        When user find the specific order from data table and click on cancel button and accept alert
        Then confirmation message should displays for cancellation
        And user should logout and close the browser



