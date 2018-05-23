package com.projeto.armazem.service;

import com.projeto.armazem.model.MovimentacaoEstoque;
import com.projeto.armazem.model.TipoProdutoSecao;
import com.projeto.armazem.model.VolumeDisponivelPorSecao;
import com.projeto.armazem.model.VolumeTotalPorTipo;
import com.projeto.armazem.repository.MovimentacaoEstoqueRepository;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
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

    private void validarMovimentacao(MovimentacaoEstoque mE) throws Exception {
        TipoProdutoSecao result = repository.buscarTipoProdutoSecao(mE.getIdSecao(), mE.getIdTipoProduto());
        if (result == null) {
            throw new Exception("Nenhuma seção foi localizada");
        } else if (result.getVolume() < mE.getVolume()) {
            throw new Exception("Volume excedido!!!!!!!!!!!!!");
        }

        Date data = repository.buscarData(mE.getIdSecao(), mE.getIdTipoProduto());
        if (data != null) {

            Long dias = TimeUnit.MILLISECONDS.toDays(new Date().getTime() - data.getTime());
            if (dias < 1) {
                throw new Exception("Seção já utilizada por outro tipo no dia de hoje");
            }
        }

    }

    public void salvarMovimentacoes(MovimentacaoEstoque mE) throws Exception {
        validarMovimentacao(mE);
        repository.salvar(mE);

    }

    public List<VolumeDisponivelPorSecao> buscarSecoesDisponiveisArmazenamento() {
        return repository.buscarSecoesDisponiveisArmazenamento();
    }

    public List<VolumeDisponivelPorSecao> buscarSecoesDisponiveisVenda() {
        return repository.buscarSecoesDisponiveisVenda();
    }

}
