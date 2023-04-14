package br.com.alura.leilao.acceptance.steps;

import br.com.alura.leilao.model.Lance;
import br.com.alura.leilao.model.Leilao;
import br.com.alura.leilao.model.Usuario;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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

    @When("propoe ao leilao")
    public void propoe_ao_leilao() {
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

    @When("propoe varios lances ao leilao")
    public void propoe_varios_lances_ao_leilao() {
        this.lista.forEach(lance1 -> leilao.propoe(lance1));
    }

    @Then("os lances sao aceito")
    public void os_lances_sao_aceito() {
        Assertions.assertEquals(this.lista.size(), leilao.getLances().size());
        Assertions.assertEquals(this.lista.get(0).getValor(), leilao.getLances().get(0).getValor());
        Assertions.assertEquals(this.lista.get(1).getValor(), leilao.getLances().get(1).getValor());
    }

    @Given("um lance invalido de {double} reais e do usuario {string}")
    public void um_lance_invalido_de_reais_e_do_usuario(Double valor, String nomeUsuario) {
        this.lance = new Lance(new BigDecimal(valor));
    }

    @Then("o lances nao eh aceito")
    public void o_lances_nao_eh_aceito() {
        Assertions.assertEquals(0, leilao.getLances().size());
    }

    @Then("o segundo lance nao eh aceito")
    public void o_segundo_lance_nao_eh_aceito() {
        Assertions.assertEquals(1, leilao.getLances().size());
        Assertions.assertEquals(this.lista.get(0).getValor(), leilao.getLances().get(0).getValor());
    }

    @Given("dois lances")
    public void dois_lances(DataTable dataTable) {
        List<Map<String, String>> valores = dataTable.asMaps();
        for (Map<String, String> mapa : valores) {
            String valor = mapa.get("valor");
            String usuario = mapa.get("nomeUsuario");
            Lance lance = new Lance(new Usuario(usuario), new BigDecimal(valor));
            this.lista.add(lance);
        }
    }

}
