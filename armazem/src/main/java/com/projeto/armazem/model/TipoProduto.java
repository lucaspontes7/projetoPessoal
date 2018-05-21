package com.projeto.armazem.model;

/**
 *
 * @author lucas
 */
public class TipoProduto {

    private int id;
    private String descricao;
    private Double volumeMaximoPermitido;

    public TipoProduto() {
    }

    public TipoProduto(int id, String descricao, Double volumeMaximoPermitido) {
        this.id = id;
        this.descricao = descricao;
        this.volumeMaximoPermitido = volumeMaximoPermitido;
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

    public Double getVolumeMaximoPermitido() {
        return volumeMaximoPermitido;
    }

    public void setVolumeMaximoPermitido(Double volumeMaximoPermitido) {
        this.volumeMaximoPermitido = volumeMaximoPermitido;
    }

}
