package br.com.ferramentoteca.dao;

import br.com.ferramentoteca.util.ConexaoDB;
import br.com.ferramentoteca.model.Ferramenta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class FerramentaDAO {

    public void cadastrar(Ferramenta ferramenta) {

        String sql = "INSERT INTO ferramenta "
                + "(nome, descricao, localizacao, status, motivoDesativacao) "
                + "VALUES (?, ?, ?, ?, ?)";

        try (Connection con = ConexaoDB.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, ferramenta.getNome());
            ps.setString(2, ferramenta.getDescricao());
            ps.setString(3, ferramenta.getLocalizacao());
            ps.setString(4, ferramenta.getStatus());
            ps.setString(5, ferramenta.getMotivoDesativacao());

            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao cadastrar ferramenta", e);
        }
    }

    public Ferramenta buscarPorIdOuNome(String criterio) {

        String sql = "SELECT * FROM ferramenta WHERE id = ? OR nome LIKE ?";

        try (Connection con = ConexaoDB.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

            try {
                ps.setInt(1, Integer.parseInt(criterio));
            } catch (NumberFormatException e) {
                ps.setInt(1, -1);
            }

            ps.setString(2, "%" + criterio + "%");

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Ferramenta f = new Ferramenta();
                    f.setId(rs.getInt("id"));
                    f.setNome(rs.getString("nome"));
                    f.setDescricao(rs.getString("descricao"));
                    f.setLocalizacao(rs.getString("localizacao"));
                    f.setStatus(rs.getString("status"));
                    f.setMotivoDesativacao(rs.getString("motivoDesativacao"));
                    return f;
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar ferramenta", e);
        }

        return null;
    }

    public void atualizar(Ferramenta ferramenta) {

        String sql = "UPDATE ferramenta SET nome = ?, descricao = ?, localizacao = ?, "
                + "status = ?, motivoDesativacao = ? WHERE id = ?";

        try (Connection con = ConexaoDB.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, ferramenta.getNome());
            ps.setString(2, ferramenta.getDescricao());
            ps.setString(3, ferramenta.getLocalizacao());
            ps.setString(4, ferramenta.getStatus());
            ps.setString(5, ferramenta.getMotivoDesativacao());
            ps.setInt(6, ferramenta.getId());

            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar ferramenta", e);
        }
    }

    public Ferramenta buscarParaEmprestimo(String criterio) {

        String sql = "SELECT * FROM ferramenta WHERE id = ? OR nome LIKE ?";

        try (Connection con = ConexaoDB.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

            try {
                ps.setInt(1, Integer.parseInt(criterio));
            } catch (NumberFormatException e) {
                ps.setInt(1, -1);
            }

            ps.setString(2, "%" + criterio + "%");

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Ferramenta f = new Ferramenta();
                    f.setId(rs.getInt("id"));
                    f.setNome(rs.getString("nome"));
                    f.setDescricao(rs.getString("descricao"));
                    f.setLocalizacao(rs.getString("localizacao"));
                    f.setStatus(rs.getString("status"));
                    return f;
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar ferramenta para empréstimo", e);
        }

        return null;
    }

    public List<Ferramenta> listarTodos() {

        List<Ferramenta> lista = new ArrayList<>();
        String sql = "SELECT * FROM ferramenta";

        try (Connection con = ConexaoDB.getConnection(); PreparedStatement ps = con.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Ferramenta f = new Ferramenta();
                f.setId(rs.getInt("id"));
                f.setNome(rs.getString("nome"));
                f.setStatus(rs.getString("status"));
                f.setLocalizacao(rs.getString("localizacao"));
                f.setMotivoDesativacao(rs.getString("motivoDesativacao"));
                lista.add(f);
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar ferramentas", e);
        }

        return lista;
    }

}
