#Senaryo
#CitizenShip sayfasına gidiniz.
#Create işlemini parameter yöntemi ile doğrulayınız.
#Daha sonra aynı bilgilerle tekrar Create yapılamadığını doğrulayınız. (negatif test)

Feature: Citizenship Functionality

  Background:  # before senaryo
    Given Navigate to Campus
    When Enter username and password and click login button
    Then User should login succesfully
    And Navigate to CitizenShip page

  Scenario Outline: CitizenShip create
    # Burada "outline" ekleyerek aşağıdaki örnekler gibi çoklu veri girmemize izin verir.
    # "Outline" a sağ click yapıp "create" yapınca aşağıdaki şablon otomatik gelir.
    When User a CitizenShip name as "<name>" short name as "<short>"
    Then Success message should be displayed

    When User a CitizenShip name as "<name>" short name as "<short>"
    Then Already exist message should be displayed

    When User delete the "<name>"
    Then Success message should be displayed

    Examples:
      | name       | short     |
      | i7sa1sdU12 | i73rfs11  |
      | i7sa1sdUl9 | i2rfs112  |
      | i7sa1sdUl0 | i2rfs113  |
      | i7sa1sdUl1 | i2rfs114  |


#testNG dataProvide, burada "Scenario Outline" olarak karşımıza çıkıyor.