package br.com.alura.leilao.acceptance;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "classpath:features", tags = "@leilao")// a tag limita os teste a serem feito, neste caso apenas o testes com @leilao será executado.
public class LeilaoCucumberRunner {

}
