package com.projeto.armazem.repository;

import com.projeto.armazem.model.MovimentacaoEstoque;
import com.projeto.armazem.model.VolumeDisponivelPorSecao;
import com.projeto.armazem.model.VolumeTotalPorTipo;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;

@Repository
public class MovimentacaoEstoqueRepository {

    @PersistenceContext
    private EntityManager em;

    final Long volumeTotalAlcoolico = 500L;
    final Long volumeTotalNaoAlcoolico = 450L;

    public void salvar(MovimentacaoEstoque mE) {
        em.persist(mE);
        em.flush();
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

    public List<VolumeDisponivelPorSecao> buscarSecoesDisponiveisArmazenamento(int tipoProduto) {
        List<VolumeDisponivelPorSecao> resultado = new ArrayList<>();
        StringBuilder hql = new StringBuilder();

        hql.append("\n  SELECT s.id, s.descricao, t.descricao, m.idTipoProduto, t.volumeTotalPermitido - SUM(m.volume)");
        hql.append("\n  FROM MovimentacaoEstoque m");
        hql.append("\n  INNER JOIN TipoProduto t");
        hql.append("\n  ON m.idTipoProduto = t.id");
        hql.append("\n  RIGHT OUTER JOIN Secao s");
        hql.append("\n  ON m.idSecao = s.id");
        hql.append("\n  GROUP BY s.id,  m.idTipoProduto, s.descricao, t.descricao, t.volumeTotalPermitido");
        hql.append("\n  WHERE m.idTipoProduto = :tipo");

        Query query = (Query) em.createQuery(hql.toString()).getResultList();
        query.setParameter("tipo", tipoProduto);

        List<Object[]> lista = (List<Object[]>) query;

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
