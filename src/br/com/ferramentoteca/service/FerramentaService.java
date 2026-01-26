package br.com.ferramentoteca.service;

import br.com.ferramentoteca.dao.FerramentaDAO;
import br.com.ferramentoteca.model.Ferramenta;
import java.util.List;

public class FerramentaService {

    private final FerramentaDAO dao = new FerramentaDAO();

    /* ===================== CADASTRAR ===================== */
    public void cadastrar(Ferramenta ferramenta) {

        validarFerramenta(ferramenta);
        dao.cadastrar(ferramenta);
    }

    /* ===================== BUSCAR ===================== */
    public Ferramenta buscar(String criterio) {

        if (criterio == null || criterio.isBlank()) {
            throw new IllegalArgumentException("Critério de busca não pode ser vazio");
        }

        return dao.buscarPorIdOuNome(criterio);
    }

    /* ===================== ATUALIZAR ===================== */
    public void atualizar(Ferramenta ferramenta) {

        if (ferramenta.getId() <= 0) {
            throw new IllegalArgumentException("ID inválido para atualização");
        }

        validarFerramenta(ferramenta);
        dao.atualizar(ferramenta);
    }

    /* ===================== LISTAR ===================== */
    public List<Ferramenta> listar() {
        return dao.listarTodos();
    }

    /* ===================== REGRAS DE NEGÓCIO ===================== */
    private void validarFerramenta(Ferramenta f) {

        if (f.getNome() == null || f.getNome().isBlank()) {
            throw new IllegalArgumentException("Nome da ferramenta é obrigatório");
        }

        if (f.getLocalizacao() == null || f.getLocalizacao().isBlank()) {
            throw new IllegalArgumentException("Localização da ferramenta é obrigatória");
        }

        if (f.getStatus() == null || f.getStatus().isBlank()) {
            throw new IllegalArgumentException("Status da ferramenta é obrigatório");
        }
    }
}
