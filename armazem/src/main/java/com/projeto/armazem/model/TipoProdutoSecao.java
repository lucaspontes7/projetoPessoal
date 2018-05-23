package com.projeto.armazem.model;

import java.util.Date;

/**
 *
 * @author Lucas
 */
public class TipoProdutoSecao {

    private String secao;
    private Double volume;

    public TipoProdutoSecao() {
    }

    public TipoProdutoSecao(String secao, Double volume) {
        this.secao = secao;
        this.volume = volume;
    }

    public String getSecao() {
        return secao;
    }

    public void setSecao(String secao) {
        this.secao = secao;
    }

    public Double getVolume() {
        return volume;
    }

    public void setVolume(Double volume) {
        this.volume = volume;
    }

}
