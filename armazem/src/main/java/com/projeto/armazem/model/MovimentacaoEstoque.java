package com.projeto.armazem.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author lucas
 */
@Entity
@Table(name = "MovimentacaoEstoque")
public class MovimentacaoEstoque implements Serializable {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;
    @Column(name = "idsecao")
    private int idSecao;
    @Column(name = "idproduto")
    private int idProduto;
    @Column(name = "volume")
    private Double volume;
    @Column(name = "responsavel")
    private String responsavel;

    public MovimentacaoEstoque() {
    }

    public MovimentacaoEstoque(Long id, int idSecao, int idProduto, Double volume, String responsavel) {
        this.id = id;
        this.idSecao = idSecao;
        this.idProduto = idProduto;
        this.volume = volume;
        this.responsavel = responsavel;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getIdDecao() {
        return idSecao;
    }

    public void setIdDecao(int idSecao) {
        this.idSecao = idSecao;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public Double getVolume() {
        return volume;
    }

    public void setVolume(Double volume) {
        this.volume = volume;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }

}
