package br.com.ferramentoteca.model;

public class Ferramenta {

    private int id;
    private String nome;
    private String descricao;
    private String localizacao;
    private String status;
    
    private String motivoDesativacao;

    public Ferramenta() {
    }

    public Ferramenta(int id, String nome, String descricao, String localizacao, String status, String motivoDesativacao) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.localizacao = localizacao;
        this.status = status;
        this.motivoDesativacao = motivoDesativacao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMotivoDesativacao() {
        return motivoDesativacao != null ? motivoDesativacao : "";
    }

    public void setMotivoDesativacao(String motivoDesativacao) {
        this.motivoDesativacao = motivoDesativacao;
    }

}
