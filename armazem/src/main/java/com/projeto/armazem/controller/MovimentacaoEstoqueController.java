package com.projeto.armazem.controller;

import com.projeto.armazem.model.MovimentacaoEstoque;
import com.projeto.armazem.repository.MovimentacaoEstoqueRepository;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Lucas
 */
@RestController
@RequestMapping("/estoque")
public class MovimentacaoEstoqueController {

    @Autowired
    MovimentacaoEstoqueRepository movimentacaoEstoqueRepository;

    @PostMapping("/inserir")
    public MovimentacaoEstoque inserirBebidaEstoque(@Valid @RequestBody MovimentacaoEstoque movEst) {
        return movimentacaoEstoqueRepository.save(movEst);
    }

    @GetMapping("/lista")
    public List<MovimentacaoEstoque> listarEstoque() {
        return movimentacaoEstoqueRepository.findAll();
    }
}
