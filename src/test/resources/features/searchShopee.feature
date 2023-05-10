@All
Feature: Search Kaos Polos

  @Test_kaos_polos
  Scenario: Search
  Given User is on homepage
  When User search kaos polos
  And User click search button
  Then result kaos polos appear