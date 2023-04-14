package br.com.alura.leilao.acceptance.steps;

import br.com.alura.leilao.e2e.pages.Browser;
import br.com.alura.leilao.e2e.pages.LeiloesPage;
import br.com.alura.leilao.e2e.pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class LoginSteps {
    private Browser browser;
    private LoginPage loginPage;
    private LeiloesPage leiloesPage;

    @Given("o usuario valido")
    public void o_usuario_valido() {
        browser = new Browser();
        browser.seed();
        loginPage = browser.getLoginPage();
    }

    @When("realiza login")
    public void realiza_login() {
        leiloesPage = this.loginPage.realizaLoginComo("fulano", "pass");
    }

    @Then("eh redirecionado para a pagina de leiloe")
    public void eh_redirecionado_para_a_pagina_de_leiloe() {
        Assertions.assertTrue(this.leiloesPage.estaNaPaginaDeLeiloes());
        browser.clean();
    }

    @Given("o usuario invalido")
    public void o_usuario_invalido() {
        browser = new Browser();
        browser.seed();
        loginPage = browser.getLoginPage();
    }

    @When("tanta se logar")
    public void tanta_se_logar() {
        leiloesPage = this.loginPage.realizaLoginComo("beltranoss", "pass659");
    }

    @Then("continua napagina de login")
    public void continua_napagina_de_login() {
        Assertions.assertTrue(this.loginPage.estaNaPaginaDeLoginComErro());
        browser.clean();
    }
}
