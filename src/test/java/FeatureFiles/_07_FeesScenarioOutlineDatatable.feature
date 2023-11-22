#Senaryo:
#  Daha önceki Fee Functionality Senaryosunu
#  name, code, intCode ve priority için 5 farklı kombinasyon için çalıştırınız.

Feature: Fees multiple values functionality

  Background:
    Given Navigate to Campus
    When Enter username and password and click login button
    Then User should login succesfully

  Scenario Outline: Fee Functionality
    And Click on the element in LeftNav
      | setup      |
      | parameters |
      | fees       |

    And Click on the element in Dialog
      | addButton |

    And User sending the keys in Dialog Content
      | nameInput       | <name>     |
      | codeInput       | <code>     |
      | integrationCode | <intCode>  |
      | priorityCode    | <priority> |

    And Click on the element in Dialog
      | toggleBar  |
      | saveButton |

    Then Success message should be displayed

    And User delete item from Dialog Content
      | <name> |

    Then Success message should be displayed

    Examples:
      | name    | code | intCode  | priority |
      | ofyFee1 | 2282 | payPal   | 12834    |
      | ofyFee2 | 2281 | cash     | 12835    |
      | ofyFee3 | 2283 | cheque   | 12836    |
      | ofyFee4 | 2284 | applePay | 12837    |
      | ofyFee5 | 2286 | crypto   | 12838    |






