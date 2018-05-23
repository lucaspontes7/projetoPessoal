package com.projeto.armazem.repository;

import com.projeto.armazem.model.MovimentacaoEstoque;
import com.projeto.armazem.model.TipoProdutoSecao;
import com.projeto.armazem.model.VolumeDisponivelPorSecao;
import com.projeto.armazem.model.VolumeTotalPorTipo;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaAuditing
public class MovimentacaoEstoqueRepository {

    @PersistenceContext
    private EntityManager em;

    final Long volumeTotalAlcoolico = 500L;
    final Long volumeTotalNaoAlcoolico = 450L;

    public void salvar(MovimentacaoEstoque mE) {
        em.persist(mE);
        em.flush();
    }

    public Date buscarData(int secao, int produto) {
        Query query;
        StringBuilder hql = new StringBuilder();
        hql.append("\n SELECT MAX(dataLancamento) FROM MovimentacaoEstoque");
        hql.append("\n WHERE idSecao = :secao");
        hql.append("\n AND idTipoProduto != :tipoProduto");
        query = em.createQuery(hql.toString());
        query.setParameter("secao", secao);
        query.setParameter("tipoProduto", produto);

        return (Date) query.getSingleResult();
    }

    public TipoProdutoSecao buscarTipoProdutoSecao(int secao, int produto) {
        Query query;
        StringBuilder hql = new StringBuilder();
        hql.append("\n SELECT s.descricao, ");
        hql.append("\n (SELECT volumeTotalPermitido from TipoProduto WHERE id = :tipoproduto) - SUM(COALESCE(m.volume, 0))");
        hql.append("\n FROM Secao s");
        hql.append("\n LEFT JOIN MovimentacaoEstoque m");
        hql.append("\n ON s.id = m.idSecao AND m.idTipoProduto = :tipoproduto");
        hql.append("\n WHERE s.id = :secao");
        hql.append("\n GROUP BY s.descricao, m.idTipoProduto");
        query = em.createQuery(hql.toString());
        query.setParameter("secao", secao);
        query.setParameter("tipoproduto", produto);

        Object[] result = (Object[]) query.getSingleResult();

        TipoProdutoSecao tipoProdutoSecao = new TipoProdutoSecao();
        tipoProdutoSecao.setSecao((String) result[0]);
        tipoProdutoSecao.setVolume((Double) result[1]);

        return tipoProdutoSecao;
    }

    public List<MovimentacaoEstoque> buscarTodos() {
        Query query;
        StringBuilder hql = new StringBuilder();
        hql.append("FROM MovimentacaoEstoque");
        query = em.createQuery(hql.toString(), MovimentacaoEstoque.class);

        return query.getResultList();
    }

    public List<VolumeTotalPorTipo> buscarVolumePorTipo() {

        List<VolumeTotalPorTipo> resultado = new ArrayList<>();
        StringBuilder hql = new StringBuilder();
        hql.append("\n  SELECT idTipoProduto, SUM(volume) FROM MovimentacaoEstoque");
        hql.append("\n  GROUP BY idTipoProduto");
        List<Object[]> lista = em.createQuery(hql.toString()).getResultList();
        for (Object[] objects : lista) {
            VolumeTotalPorTipo volumeTotalPorTipo = new VolumeTotalPorTipo();
            volumeTotalPorTipo.setTipoProduto((int) objects[0]);
            volumeTotalPorTipo.setVolumeTotal((Double) objects[1]);
            resultado.add(volumeTotalPorTipo);
        }

        return resultado;
    }

    public List<VolumeDisponivelPorSecao> buscarSecoesDisponiveisArmazenamento() {
        List<VolumeDisponivelPorSecao> resultado = new ArrayList<>();
        StringBuilder hql = new StringBuilder();

        hql.append("\n  SELECT s.id, s.descricao, t.descricao, m.idTipoProduto, t.volumeTotalPermitido - SUM(m.volume)");
        hql.append("\n  FROM MovimentacaoEstoque m");
        hql.append("\n  INNER JOIN TipoProduto t");
        hql.append("\n  ON m.idTipoProduto = t.id");
        hql.append("\n  RIGHT OUTER JOIN Secao s");
        hql.append("\n  ON m.idSecao = s.id");
        hql.append("\n  GROUP BY s.id,  m.idTipoProduto, s.descricao, t.descricao, t.volumeTotalPermitido");
        List<Object[]> lista = em.createQuery(hql.toString()).getResultList();

        for (Object[] objects : lista) {
            VolumeDisponivelPorSecao volumeDisponivelPorSecao = new VolumeDisponivelPorSecao();
            volumeDisponivelPorSecao.setSecao((String) objects[1]);
            volumeDisponivelPorSecao.setTipoProduto((String) objects[2]);

            volumeDisponivelPorSecao.setVolumeRestante((Double) objects[4]);
            resultado.add(volumeDisponivelPorSecao);
        }

        return resultado;
    }

    public List<VolumeDisponivelPorSecao> buscarSecoesDisponiveisVenda() {
        List<VolumeDisponivelPorSecao> resultado = new ArrayList<>();
        StringBuilder hql = new StringBuilder();
        hql.append("\n  SELECT s.id, s.descricao, t.descricao, m.idTipoProduto, SUM(m.volume)");
        hql.append("\n  FROM MovimentacaoEstoque m");
        hql.append("\n  INNER JOIN TipoProduto t");
        hql.append("\n  ON m.idTipoProduto = t.id");
        hql.append("\n  RIGHT OUTER JOIN Secao s");
        hql.append("\n  ON m.idSecao = s.id");
        hql.append("\n  GROUP BY s.id,  m.idTipoProduto, s.descricao, t.descricao, t.volumeTotalPermitido");
        List<Object[]> lista = em.createQuery(hql.toString()).getResultList();

        for (Object[] objects : lista) {
            VolumeDisponivelPorSecao volumeDisponivelPorSecao = new VolumeDisponivelPorSecao();
            volumeDisponivelPorSecao.setSecao((String) objects[1]);
            volumeDisponivelPorSecao.setTipoProduto((String) objects[2]);

            volumeDisponivelPorSecao.setVolumeRestante((Double) objects[4]);
            resultado.add(volumeDisponivelPorSecao);
        }

        return resultado;
    }
}
