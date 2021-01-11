Feature: DifferentElements page
  In order to adjust elements into checkBox, radioBtn, dropDown
  As a user
  I want to receive log with selected elements

  Background:
    Given I open JDI GitHub site
    And I login as user 'Roman' with password 'Jdi1234'
    Then  User name in the left-top side of screen should be 'ROMAN IOVLEV'

  Scenario: Elements Page opening test
    When I click on 'Service' button in Header
    And I click on 'Different Elements' button in Service dropdown
    Then 'Different Elements' page should be opened

  Scenario: Relevant Log on Different Elements page
    Given I click on 'Service' button in Header
    And I click on 'Different Elements' button in Service dropdown
    When I select 'Water' checkboxes
    * I select 'Wind' checkboxes
    * I select 'Selen' radio
    * I select 'Yellow' from dropDown
    Then Log rows are displayed with relevant history
      | Water  | cbox  |
      | Wind   | cbox  |
      | Selen  | radio |
      | Yellow | dd    |





