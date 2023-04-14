Feature: Propondo lances ao leilao

  Scenario: Propondo um unico lance valido
    Given um lance valido
    When propoe ao lance
    Then o lance eh aceito

  Scenario: Propondo vario lance valido
    Given um lance de 10.0 reais do usuario "fulano"
      And um lance de 15.0 reais do usuario "beltrano"
    When propoe varios lances
    Then os lances sao aceito