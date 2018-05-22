package com.projeto.armazem.model;

/**
 *
 * @author lucas
 */
public class VolumeDisponivelPorSecao {

    private String secao;
    private String tipoProduto;
    private Double volumeRestante;

    public VolumeDisponivelPorSecao() {
    }

    public VolumeDisponivelPorSecao(String secao, String tipoProduto, Double volumeRestante) {
        this.secao = secao;
        this.tipoProduto = tipoProduto;
        this.volumeRestante = volumeRestante;
    }

    public String getSecao() {
        return secao;
    }

    public void setSecao(String secao) {
        this.secao = secao;
    }

    public String getTipoProduto() {
        return tipoProduto;
    }

    public void setTipoProduto(String tipoProduto) {
        this.tipoProduto = tipoProduto;
    }

    public Double getVolumeRestante() {
        return volumeRestante;
    }

    public void setVolumeRestante(Double volumeRestante) {
        this.volumeRestante = volumeRestante;
    }

}
