
package br.senac.ferramentoteca;

import org.junit.Test;
import static org.junit.Assert.*;

public class RegraEmprestimoTest {

    @Test
    public void devePermitirEmprestimoQuandoQuantidadeAtualMenorQueLimite() {
        RegraEmprestimo regra = new RegraEmprestimo();

        boolean resultado = regra.podeEmprestar(2, 5);

        assertTrue(resultado);
    }

    @Test
    public void deveBloquearEmprestimoQuandoQuantidadeAtualIgualAoLimite() {
        RegraEmprestimo regra = new RegraEmprestimo();

        boolean resultado = regra.podeEmprestar(5, 5);

        assertFalse(resultado);
    }

    @Test
    public void deveBloquearEmprestimoQuandoQuantidadeAtualMaiorQueLimite() {
        RegraEmprestimo regra = new RegraEmprestimo();

        boolean resultado = regra.podeEmprestar(6, 5);

        assertFalse(resultado);
    }
}

