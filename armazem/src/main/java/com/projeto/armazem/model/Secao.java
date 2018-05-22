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
@Table(name = "Secao")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Secao implements Serializable {

    @Id
    private int id;
    @Column(name = "descricao")
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
