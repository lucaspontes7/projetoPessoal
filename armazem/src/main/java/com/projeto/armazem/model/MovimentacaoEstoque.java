package com.projeto.armazem.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

/**
 *
 * @author lucas
 */
@Entity
@Table(name = "MovimentacaoEstoque")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"dataLancamento"},
        allowGetters = true)
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
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    @Column(name = "datalancamento")
    private Date dataLancamento;
    @Column(name = "responsavel")
    private String responsavel;

    public MovimentacaoEstoque() {
    }

    public MovimentacaoEstoque(Long id, int idSecao, int idProduto, Double volume, Date dataLancamento, String responsavel) {
        this.id = id;
        this.idSecao = idSecao;
        this.idProduto = idProduto;
        this.volume = volume;
        this.dataLancamento = dataLancamento;
        this.responsavel = responsavel;
    }

    public Date getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(Date dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getIdSecao() {
        return idSecao;
    }

    public void setISecao(int idSecao) {
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
