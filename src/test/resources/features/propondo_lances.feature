Feature: Propondo lances ao leilao

  Scenario: Propondo um unico lance valido
    Given um lance valido
    When propoe ao leilao
    Then o lance eh aceito

  Scenario: Propondo vario lance valido
    Given um lance de 10.0 reais do usuario "fulano"
      And um lance de 15.0 reais do usuario "beltrano"
    When propoe varios lances ao leilao
    Then os lances sao aceito

  Scenario Outline: Propondo um lance invalido
    Given um lance invalido de <valor> reais e do usuario '<nomeUsuario>'
    When propoe ao leilao
    Then o lances nao eh aceito

    Examples:
      | valor | nomeUsuario|
      | 0.0   | beltrano   |
      | -1.0  | cigano     |

  Scenario: Propondo uma sequencia de lances
    Given dois lances
      | valor | nomeUsuario|
      | 10.0  | fulano     |
      | 15.0  | fulano     |
    When propoe varios lances ao leilao
    Then o segundo lance nao eh aceito