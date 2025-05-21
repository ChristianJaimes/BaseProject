# google_search.feature
# Búsqueda básica en Google usando Cucumber.
# Autor: ChristianJaimes

Feature: Búsqueda en Google

  Scenario: Buscar "selenium" y verificar primer resultado
    Given abro Google
    When busco "selenium"
    Then el primer resultado contiene "selenium.dev"
