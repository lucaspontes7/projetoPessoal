package com.projeto.armazem.model;

/**
 *
 * @author lucas
 */
public class Produto {

    private int id;
    private int idTipo;
    private String descricao;
    private Double volume;

    public Produto() {
    }

    public Produto(int id, int idTipo, String descricao, Double volume) {
        this.id = id;
        this.idTipo = idTipo;
        this.descricao = descricao;
        this.volume = volume;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(int idTipo) {
        this.idTipo = idTipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getVolume() {
        return volume;
    }

    public void setVolume(Double volume) {
        this.volume = volume;
    }

}
