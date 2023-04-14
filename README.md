# BDD e Java: Behavior Driven Development com Cucumber
## AULA 01. Introdução ao BDD


Nessa aula aprendemos:

- O que é BDD (o _Behaviour Driven Development_)
  - BDD tenta melhorar a comunicação e colaboração
  - BDD tenta aproximar o negócio e criar um entendimento melhor como a aplicação deveria funcionar
- Existem vários tipos e níveis de testes, como por exemplo:
  - testes de unidade
  - testes de integração
  - testes ponta a ponta (_end-to-end_)

## AULA 02. Escrevendo Features com Cucumber
Como vimos na aula, os métodos de testes precisam ser semânticos. Em muitos casos, os testes são utilizados como a documentação do código no projeto.

Existem algumas formas de nomeação, contudo, em muitos casos os times definem qual padrão utilizar. O importante é que o nome dos métodos sejam expressivos e que o padrão escolhido seja seguido.

Caso queiram conhecer outras formas comuns de nomear os testes, neste link https://dzone.com/articles/7-popular-unit-test-naming de um artigo em inglês mostra algumas formas de nomeação.

Sobre Assert
Neste vídeo vimos uma particularidade interessante: Apesar de ser uma ferramenta de testes, o Cucumber não fornece nenhuma ferramenta para efetivamente verificar condições.

Para isso devemos utilizar o Junit que traz inúmeros métodos interessantes de verificação, a partir da classe `org.junit.Assert`

Essa classe fornece métodos estáticos muito simples que verificam se o parâmetro é verdadeiro, se há igualdade etc, como por exemplo:

    Assert.assertEquals(Object expected, Object actual);

Para saber mais sobre essa função você pode conferir a documentação oficial:

https://junit.org/junit4/javadoc/4.8/org/junit/Assert.html

e a documentação do Cucumber:

https://cucumber.io/docs/cucumber/checking-assertions/

Nessa aula aprendemos:

- Como integrar a biblioteca _Cucumber_ na aplicação
- _Cucumber_ pode ser inicializado a partir do junit4 (`@RunWith`)
- os arquivos `.feature` são analisados pelo _Gherkin_ e _Cucumber_
  - Gerkin é uma linguagem para definir os `.feature`
  - _Cucumber_ gera e roda os passos (_steps_) associados ao `.feature`
- dentro do `.feature` escrevemos a funcionalidade e os critérios de aceitação
- um critério de aceitação segue a estrutura de um teste (passos ou _steps_)
  - os passos são _Given-When-Then_ ou _Dado-Quando-Entao_
- cada passo será implementado por um método anotado (_step_)