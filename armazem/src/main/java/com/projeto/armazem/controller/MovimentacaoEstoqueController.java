package com.projeto.armazem.controller;

import com.projeto.armazem.model.MovimentacaoEstoque;
import com.projeto.armazem.model.VolumeDisponivelPorSecao;
import com.projeto.armazem.model.VolumeTotalPorTipo;
import com.projeto.armazem.service.MovimentacaoEstoqueService;
import java.util.List;
import javax.transaction.Transactional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Lucas
 */
@Transactional
@RestController
@RequestMapping("/estoque")
public class MovimentacaoEstoqueController {

    @Autowired
    MovimentacaoEstoqueService service;

    @PostMapping("/inserir")
    public ResponseEntity inserirBebidaEstoque(@Valid @RequestBody MovimentacaoEstoque movEst) throws Exception {
        service.salvarMovimentacoes(movEst);
        return new ResponseEntity<>(Boolean.TRUE, HttpStatus.OK);
    }

    @GetMapping("/lista")
    public List<MovimentacaoEstoque> listarEstoque() {
        return service.buscarMovimentacoes();
    }

    @GetMapping("/listaVolumePorTipo")
    public List<VolumeTotalPorTipo> listarVolumePorTipo() {
        return service.buscarVolumeTotalPorTipo();
    }

    @GetMapping("/listaSecoesDisponiveisArmazenamento")
    public List<VolumeDisponivelPorSecao> listarSecoesDisponiveisArmazenamento() {
        return service.buscarSecoesDisponiveisArmazenamento();
    }

    @GetMapping("/listaSecoesDisponiveisVenda")
    public List<VolumeDisponivelPorSecao> listarSecoesDisponiveisVenda() {
        return service.buscarSecoesDisponiveisVenda();
    }

}
