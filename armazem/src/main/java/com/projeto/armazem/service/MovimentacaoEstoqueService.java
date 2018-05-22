package com.projeto.armazem.service;

import com.projeto.armazem.model.MovimentacaoEstoque;
import com.projeto.armazem.model.VolumeDisponivelPorSecao;
import com.projeto.armazem.model.VolumeTotalPorTipo;
import com.projeto.armazem.repository.MovimentacaoEstoqueRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author lucas
 */
@Service
public class MovimentacaoEstoqueService {

    @Autowired
    MovimentacaoEstoqueRepository repository;

    public List<MovimentacaoEstoque> buscarMovimentacoes() {
        return repository.buscarTodos();
    }

    public List<VolumeTotalPorTipo> buscarVolumeTotalPorTipo() {
        return repository.buscarVolumePorTipo();
    }

    public void salvarMovimentacoes(MovimentacaoEstoque mE) {
        List<VolumeDisponivelPorSecao> lista = repository.buscarSecoesDisponiveisArmazenamento(mE.getIdTipoProduto());
        repository.salvar(mE);
    }

    public List<VolumeDisponivelPorSecao> buscarSecoesDisponiveisArmazenamento() {
        return repository.buscarSecoesDisponiveisArmazenamento();
    }

    public List<VolumeDisponivelPorSecao> buscarSecoesDisponiveisVenda() {
        return repository.buscarSecoesDisponiveisVenda();
    }

}
