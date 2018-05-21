package com.projeto.armazem.model;

/**
 *
 * @author lucas
 */
public class Secao {

    private int id;
    private String descricao;

    public Secao() {
    }

    public Secao(int id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

}
