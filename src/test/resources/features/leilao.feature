@leilao
Feature: Cadastrando um leilao

  Background:
    Given um usuario logado

  Scenario: Um usuario logado pode cadastrar um leilao
    When acessa a pagina de novo leilao
      And preenche o formulario com dados validos
    Then volta para a pagina de leiloes
      And o novo leilao aparece na tabela
