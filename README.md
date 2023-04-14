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

## AULA 03. Mais cenários e parâmetros
### **Cucumber Expression**
Já vimos como definir valores nos passos dentro do cenário, por exemplo:

    Dado um lance de 10.0 reais do usuario "fulano"

No código Java usamos uma expressão delimitado por `{}` para definir o tipo de parâmetro:

    @Dado("um lance de {double} reais do usuario {string}")
    public void um_lance(Double valor, String nomeUsuario) {
    //codigo obtido

Esse forma de definir os parâmetros se chama de **Cucumber Expression**.

Obs: Lembrando que o nome do método não importa.

### **Regex**
Existe uma alternativa ao _Cucumber Expression_, os famosos **expressões regulares**. Em lugar da _Cucumber Expression_ podemos usar uma _regex_, e assim temos todo o poder dessas expressões para definir mais detalhe sobre o formato do parâmetro, por exemplo:

    @Dado("um lance de {double} reais do usuario {string}")
    public void um_lance_de_reais_do_usuario_fulano(Double valor, String nomeUsuario) {
    //resto obtido

Se torna:

    @Dado("^um lance de (\\d+[.]\\d\\d?) reais do usuario (\\w+)$")
    public void um_lance_de_reais_do_usuario_fulano(Double valor, String nomeUsuario) {
      System.out.println(valor);
      System.out.println(nomeUsuario);
    }
Repare que as **expressões regulares** tem a sua própria complexidade. Em alguns momentos ajudam, em outros fica mais complicado como é o caso da definicao de um número decimal `((\\d+[.]\\d\\d?))`.

Se gostaria de dominar os regex, aconselhamos assistir o curso abaixo:

https://cursos.alura.com.br/course/expressoes-regulares

Vimos no vídeo as anotações `@After` e `@Before` usado em métodos nas classes que implementam os passos de um cenário.

Esse métodos também são chamados de _Hooks_ (ganchos) que nada mais são métodos chamados automaticamente quando algum evento acontece. No caso, o evento é a execução de um cenário.

Também existem os _hooks_ `@BeforeStep` e `@AfterStep`. Como o nome já indica, nessas anotações o evento é a execução de um _step_. Ou seja, cada vez que um métodos anotado com `@Dado` `@Quando` ou `@Entao` é chamado, será chamado o hook (antes ou depois, dependendo da anotação).

Em geral, vale a pena alertar que devemos ter cuidado com o uso de hooks pois esses métodos não ficam visíveis para quem lê apenas o arquivo `.feature`.

O que aprendemos nessa aula:

- um arquivo `.feature` pode ter vários cenários e passos (_steps_)
- os métodos associado aos passos são reaproveitados entre cenários
  - podemos passar parâmetros do cenário ao método
- Cucumber possui anotações para inicializar (`@Before`) e finalizar (`@After`) o cenários
  - os métodos anotados com `@Before` e `@After` são chamados de _Hooks_
  - cuidado, pois os _Hooks_ não são visíveis no arquivo `.feature`.

## AULA 04. DataTables e Exemplos
O que aprendemos nessa aula:

- como usar `Exemplos` para alimentar o mesmo teste com dados diferentes
- como usar `DataTables` para passar vários dados ao teste de uma vez só
- usar o plugin do “Cucumber” no Eclipse

## AULA 05. Integração com Selenium
O que aprendemos nessa aula:

- que `PageObject` é um padrão de projeto para encapsular o acesso a uma pagina da aplicação
  - todo o código especifico da interface com Selenium fica dentro do `PageObject`
- não devemos usar Selenium diretamente nas classes de "steps" do Cucumber
- o teste, mesmo com Selenium, deve sempre começar a partir de estado "limpo"
- a melhor estratégia de buscar um elemento na interface é usar a ID