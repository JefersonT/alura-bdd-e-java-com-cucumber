package br.com.alura.leilao.acceptance.steps;

import br.com.alura.leilao.model.Lance;
import br.com.alura.leilao.model.Leilao;
import br.com.alura.leilao.model.Usuario;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

import java.math.BigDecimal;
import java.util.ArrayList;

public class PropondoLanceSteps {

    private Lance lance;
    private Leilao leilao;
    private ArrayList<Lance> lista;

    @Before
    public void setup(){
        this.lista = new ArrayList<Lance>();
        leilao = new Leilao("Table XPTO");
    }
    @Given("um lance valido")
    public void um_lance_valido() {
        Usuario usuario = new Usuario("fulano");
        lance = new Lance(usuario, BigDecimal.TEN);
    }

    @When("propoe ao lance")
    public void propoe_o_lance() {
        leilao.propoe(lance);
    }
    @Then("o lance eh aceito")
    public void o_lance_eh_aceito() {
        Assertions.assertEquals(1, leilao.getLances().size());
        Assertions.assertEquals(BigDecimal.TEN, leilao.getLances().get(0).getValor());
    }

//    @Given("varios lance valido")
//    public void varios_lance_valido() {
//        Usuario usuario = new Usuario("fulano");
//        lance10 = new Lance(usuario, BigDecimal.TEN);
//        Usuario usuario2 = new Usuario("beltrano");
//        lance15 = new Lance(usuario2, new BigDecimal("15.0"));
//        leilao = new Leilao("Table XPTO");
//    }

    @Given("um lance de {double} reais do usuario {string}")
    public void um_lance_de_reais_do_usuario(Double double1, String nomeUsuario) {
        Usuario usuario = new Usuario(nomeUsuario);
        Lance lance = new Lance(usuario, new BigDecimal(double1));
        this.lista.add(lance);
    }

    @When("propoe varios lances")
    public void propoe_varios_lances() {
        this.lista.forEach(lance1 -> leilao.propoe(lance1));
    }

    @Then("os lances sao aceito")
    public void os_lances_sao_aceito() {
        Assertions.assertEquals(this.lista.size(), leilao.getLances().size());
        Assertions.assertEquals(this.lista.get(0).getValor(), leilao.getLances().get(0).getValor());
        Assertions.assertEquals(this.lista.get(1).getValor(), leilao.getLances().get(1).getValor());
    }

}
