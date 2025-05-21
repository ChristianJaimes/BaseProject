Feature: Búsqueda en Google
  Scenario: Buscar "Python documentation" en Google
    Given que abro Google
    When busco "Python documentation"
    Then veo resultados relacionados
