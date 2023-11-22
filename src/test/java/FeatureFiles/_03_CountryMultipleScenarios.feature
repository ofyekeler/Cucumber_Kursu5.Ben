Feature: Country Multi Scenario

  Background:  # before senaryo, her iki senaryona ortak kullanılacaklar
    Given Navigate to Campus
    When Enter username and password and click login button
    Then User should login succesfully
    And Navigate to country page

  Scenario: Create country
    When Create a country
    Then Success message should be displayed

  Scenario: Create a country 2
    When Create a country name as "i1sm11Ul" code as "1i1s1"
    Then Success message should be displayed