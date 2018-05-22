package com.projeto.armazem.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@JsonIgnoreProperties(value = {"dataLancamento", "hibernateLazyInitializer", "handler"},
        allowGetters = true)
public class MovimentacaoEstoque implements Serializable {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;
    @Column(name = "idSecao")
    private int idSecao;
    @Column(name = "produto")
    private String produto;
    @Column(name = "idTipoProduto")
    private int idTipoProduto;
    @Column(name = "volume")
    private Double volume;
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    @Column(name = "dataLancamento")
    private Date dataLancamento;
    @Column(name = "responsavel")
    private String responsavel;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "idTipoProduto", referencedColumnName = "id", nullable = true, insertable = false, updatable = false)
    private TipoProduto tipoProduto;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "idSecao", referencedColumnName = "id", nullable = true, insertable = false, updatable = false)
    private Secao secao;

    public MovimentacaoEstoque() {
    }

    public MovimentacaoEstoque(Long id, int idSecao, String produto, int idTipoProduto, Double volume, Date dataLancamento, String responsavel, TipoProduto tipoProduto, Secao secao) {
        this.id = id;
        this.idSecao = idSecao;
        this.produto = produto;
        this.idTipoProduto = idTipoProduto;
        this.volume = volume;
        this.dataLancamento = dataLancamento;
        this.responsavel = responsavel;
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

    public void setIdSecao(int idSecao) {
        this.idSecao = idSecao;
    }

    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

    public int getIdTipoProduto() {
        return idTipoProduto;
    }

    public void setIdTipoProduto(int idTipoProduto) {
        this.idTipoProduto = idTipoProduto;
    }

    public Double getVolume() {
        return volume;
    }

    public void setVolume(Double volume) {
        this.volume = volume;
    }

    public Date getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(Date dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }

    public TipoProduto getTipoProduto() {
        return tipoProduto;
    }

    public void setTipoProduto(TipoProduto tipoProduto) {
        this.tipoProduto = tipoProduto;
    }

    public Secao getSecao() {
        return secao;
    }

    public void setSecao(Secao secao) {
        this.secao = secao;
    }

}
