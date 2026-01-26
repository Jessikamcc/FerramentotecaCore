package br.com.ferramentoteca.main;

import br.com.ferramentoteca.model.Ferramenta;
import br.com.ferramentoteca.service.FerramentaService;
import java.util.List;

public class MainTeste {

    public static void main(String[] args) {

        FerramentaService service = new FerramentaService();

        /* ===================== TESTE 1 - CADASTRO ===================== */
        Ferramenta ferramenta = new Ferramenta();
        ferramenta.setNome("Martelo");
        ferramenta.setDescricao("Martelo de aço reforçado");
        ferramenta.setLocalizacao("Almoxarifado");
        ferramenta.setStatus("ATIVO");
        ferramenta.setMotivoDesativacao(null);

        service.cadastrar(ferramenta);
        System.out.println("✔ Ferramenta cadastrada");

        /* ===================== TESTE 2 - BUSCA ===================== */
        Ferramenta buscada = service.buscar("Martelo");

        if (buscada != null) {
            System.out.println("✔ Ferramenta encontrada: " + buscada.getNome());
        } else {
            System.out.println("✖ Ferramenta não encontrada");
        }

        /* ===================== TESTE 3 - LISTAGEM ===================== */
        List<Ferramenta> lista = service.listar();

        System.out.println("✔ Lista de ferramentas:");
        for (Ferramenta f : lista) {
            System.out.println(
                    f.getId() + " - "
                    + f.getNome() + " | "
                    + f.getStatus() + " | "
                    + f.getLocalizacao()
            );
        }

        System.out.println("✔ Testes finalizados com sucesso");
    }

}
