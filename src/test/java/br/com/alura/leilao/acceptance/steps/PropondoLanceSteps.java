package br.com.alura.leilao.acceptance.steps;

import br.com.alura.leilao.model.Lance;
import br.com.alura.leilao.model.Leilao;
import br.com.alura.leilao.model.Usuario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

import java.math.BigDecimal;

public class PropondoLanceSteps {

    private Lance lance;
    private Leilao leilao;
    @Given("Dado um lance valido")
    public void dado_um_lance_valido() {
        Usuario usuario = new Usuario("fulano");
        lance = new Lance(usuario, BigDecimal.TEN);
    }

    @When("Quando propoe o lance")
    public void quando_propoe_o_lance() {
        leilao = new Leilao("Table XPTO");
        leilao.propoe(lance);
    }
    @Then("Entao o lance eh aceito")
    public void entao_o_lance_eh_aceito() {
        Assertions.assertEquals(1, leilao.getLances().size());
        Assertions.assertEquals(BigDecimal.TEN, leilao.getLances().get(0).getValor());
    }

}