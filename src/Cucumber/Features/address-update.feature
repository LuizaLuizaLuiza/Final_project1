Feature: Change user address

  Scenario Outline: user can update their address
    Given I'm logged in to My Store shop
    When I go to UserAddressPage
    And I click create new address
    And I enter "<alias>" alias "<address>" address "<city>" city "<postalCode>" postalCode "<phone>" phone
    And I save all data
    Then I can see success message "Address successfully added!"
    And I delete new address
    And I can see delete success message "Address successfully deleted!"
    And close browser

    Examples:
      | alias  | address    | city      | postalCode | phone     |
      | Mak    | Old Street | Liverpool | CH415LH    | 521123321 |
