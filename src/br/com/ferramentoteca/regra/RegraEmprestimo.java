
package br.com.ferramentoteca.regra;

public class RegraEmprestimo {
    
    public boolean podeEmprestar(int quantidadeEmprestada, int limite) {
        return quantidadeEmprestada < limite;
    }
    
}
