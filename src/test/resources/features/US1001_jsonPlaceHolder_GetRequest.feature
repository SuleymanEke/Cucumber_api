Feature: JsonPlaceHolder endpoint'inde GET request test yapar
  @Api1
  Scenario: TC01 44 nolu endpoint'e GET request gonderip testleri yapar
    Given Kullanici "jPHBaseUrl" base Url'ine gider
    Then Path parametreleri icin "posts/44" kullanir
    And jPH server'a GET request gonderir ve testleri yapmak icin response degerini kaydeder
    Then jPH response'da status degerinin 200
    And jPH response'da content Type degerinin "application/json; charset=utf-8"
    Then jPH GET response body'sinde "userId" degerinin Integer 5
    And jPH GET response body'sinde "title" degerinin String "optio dolor molestias sit"

