
package br.senac.ferramentoteca;

public class RegraEmprestimo {
    
    public boolean podeEmprestar(int quantidadeEmprestada, int limite) {
        return quantidadeEmprestada < limite;
    }
}
