Feature: Reporting Manager feature

Scenario:Login to Reporting Manager Dashboard Page
    Given  user is on Login to Admin Panel Page
    When  Enter valid username and password for user Role as "ReportingManager"
    Then  Logged into Dashboard as "ReportingManager"


    Scenario: Reporting Manager should be able to see Shopping Cart- Product in carts Report
      Given Logged into Dashboard as "ReportingManager"
      When User clicks on Reports followed by clicks on Shopping Cart followed by clicks on Products in carts
      Then Shopping Cart- Product in carts Report Should be displayed


Scenario:  Reporting Manager should be able to see Shopping Cart - Abandoned carts Report
  Given Logged into Dashboard as "ReportingManager"
  When  User clicks on Reports followed by clicks on Shopping Cart followed by clicks on Abandoned carts
  Then  Shopping Cart - Abandoned carts Report Should be displayed



  Scenario Outline: Reporting Manager should be able to see Products - Products Ordered Report
    Given Logged into Dashboard as "ReportingManager"
    When User clicks on Reports followed by clicks on Products and followed by clicks on Bestsellers
    Then Products Bestsellers Report Page should be displayed
    When  user selects Show Report For as "<websiteName>" and enter From field as "<fromDate>" To field as "<toDate>" and click on submit button
    Then   Products Bestsellers Report data table should be displayed

    Examples:
      | websiteName   | fromDate   |  toDate    |
      | All Websites  | 06/28/2023 | 12/28/2023 |

   Scenario:  Logout
     Given Logged into Dashboard as "ReportingManager"
     When User Clicks on logout button
     Then user should logged out from dashboard Page to Login to Admin Panel Page



