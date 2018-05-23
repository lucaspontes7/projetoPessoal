package com.projeto.armazem.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.projeto.armazem.model.MovimentacaoEstoque;
import com.projeto.armazem.service.MovimentacaoEstoqueService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

/**
 *
 * @author Lucas
 */
@RunWith(SpringRunner.class)
@WebMvcTest(value = MovimentacaoEstoqueController.class, secure = false)
public class MovimentacaoEstoqueControllerTest {

    private ObjectMapper json;

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MovimentacaoEstoqueService service;

    public MovimentacaoEstoqueControllerTest() {
    }

    @Before
    public void setUp() {
        json = new ObjectMapper();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testInserirBebidaEstoque() throws Exception {
        MovimentacaoEstoque movEstoque = new MovimentacaoEstoque();
        movEstoque.setIdSecao(1);
        movEstoque.setIdTipoProduto(1);
        movEstoque.setResponsavel("Lucas");
        movEstoque.setProduto("Produto");
        movEstoque.setVolume(10.0);

        String movEstoqueJson = json.writeValueAsString(movEstoque);

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/estoque/inserir")
                .accept(MediaType.APPLICATION_JSON).content(movEstoqueJson)
                .contentType(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = result.getResponse();
        assertEquals(HttpStatus.OK.value(), response.getStatus());
    }

    @Test
    public void testListarEstoque() throws Exception {

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/estoque/lista")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = result.getResponse();
        assertEquals(HttpStatus.OK.value(), response.getStatus());
    }

    @Test
    public void testListarVolumePorTipo() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/estoque/listaVolumePorTipo")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = result.getResponse();
        assertEquals(HttpStatus.OK.value(), response.getStatus());
    }

    @Test
    public void testListarSecoesDisponiveisArmazenamento() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/estoque/listaSecoesDisponiveisArmazenamento")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = result.getResponse();
        assertEquals(HttpStatus.OK.value(), response.getStatus());
    }

    @Test
    public void testListarSecoesDisponiveisVenda() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/estoque/listaSecoesDisponiveisVenda")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = result.getResponse();
        assertEquals(HttpStatus.OK.value(), response.getStatus());
    }

}
