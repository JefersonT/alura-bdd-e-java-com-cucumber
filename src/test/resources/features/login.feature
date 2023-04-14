Feature: Apenas usuarios cadastrados podem se logar

  Scenario: Um usuario valido consegue se logar
    Given o usuario valido
    When realiza login
    Then eh redirecionado para a pagina de leiloe

  Scenario: Um usuario invalido não consegue se logar
    Given o usuario invalido
    When tanta se logar
    Then continua napagina de login