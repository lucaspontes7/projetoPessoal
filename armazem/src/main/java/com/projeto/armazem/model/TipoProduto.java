package com.projeto.armazem.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author lucas
 */
@Entity
@Table(name = "TipoProduto")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class TipoProduto implements Serializable {

    @Id
    private int id;
    @Column(name = "descricao")
    private String descricao;
    @Column(name = "volumeTotalPermitido")
    private Double volumeTotalPermitido;

    public TipoProduto() {
    }

    public TipoProduto(int id, String descricao, Double volumeTotalPermitido) {
        this.id = id;
        this.descricao = descricao;
        this.volumeTotalPermitido = volumeTotalPermitido;
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

    public Double getVolumeTotalPermitido() {
        return volumeTotalPermitido;
    }

    public void setVolumeTotalPermitido(Double volumeTotalPermitido) {
        this.volumeTotalPermitido = volumeTotalPermitido;
    }

}
