package br.com.alura.leilao.acceptance.steps;

import br.com.alura.leilao.e2e.pages.Browser;
import br.com.alura.leilao.e2e.pages.LeiloesPage;
import br.com.alura.leilao.e2e.pages.LoginPage;
import br.com.alura.leilao.e2e.pages.NovoLeilaoPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class LeilaoSteps {

    private LoginPage loginPage;
    private LeiloesPage leiloesPage;
    private NovoLeilaoPage novoLeilaoPage;
    private Browser browser;

    @Given("um usuario logado")
    public void um_usuario_logado() {
        this.browser = new Browser();
        this.browser.seed();
        loginPage = this.browser.getLoginPage();
        leiloesPage = loginPage.realizaLoginComoFulano();
    }

    @When("acessa a pagina de novo leilao")
    public void acessa_a_pagina_de_novo_leilao() {
        novoLeilaoPage = this.leiloesPage.visitaPaginaParaCriarUmNovoLeilao();
    }

    @When("preenche o formulario com dados validos")
    public void preenche_o_formulario_com_dados_validos() {
        this.leiloesPage = this.novoLeilaoPage.preencheForm("PC Novo", "1500", "01/11/2023");
    }

    @Then("volta para a pagina de leiloes")
    public void volta_para_a_pagina_de_leiloes() {
        Assertions.assertTrue(this.leiloesPage.estaNaPaginaDeLeiloes());
    }

    @Then("o novo leilao aparece na tabela")
    public void o_novo_leilao_aparece_na_tabela() {
        this.leiloesPage.existe("PC Novo", "1500", "01/11/2023", "fulano");
        this.browser.clean();
    }
}
