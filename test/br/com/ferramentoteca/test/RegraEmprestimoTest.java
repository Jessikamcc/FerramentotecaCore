package br.com.ferramentoteca.test;

import br.com.ferramentoteca.regra.RegraEmprestimo;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RegraEmprestimoTest {

    @Test
    public void devePermitirEmprestimoQuandoQuantidadeMenorQueLimite() {

        RegraEmprestimo regra = new RegraEmprestimo();

        boolean resultado = regra.podeEmprestar(2, 5);

        assertTrue(resultado);
    }

}