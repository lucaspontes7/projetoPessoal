
package com.projeto.armazem.model;

/**
 *
 * @author lucas
 */
public class VolumeTotalPorTipo {

    private int tipoProduto;
    private Double volumeTotal;

    public VolumeTotalPorTipo() {
    }

    public VolumeTotalPorTipo(int tipoProduto, Double volumeTotal) {
        this.tipoProduto = tipoProduto;
        this.volumeTotal = volumeTotal;
    }

    public int getTipoProduto() {
        return tipoProduto;
    }

    public void setTipoProduto(int tipoProduto) {
        this.tipoProduto = tipoProduto;
    }

    public Double getVolumeTotal() {
        return volumeTotal;
    }

    public void setVolumeTotal(Double volumeTotal) {
        this.volumeTotal = volumeTotal;
    }

}
