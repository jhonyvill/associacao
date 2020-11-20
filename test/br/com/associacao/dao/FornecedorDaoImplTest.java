/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.associacao.dao;

import br.com.associacao.entidade.Endereco;
import br.com.associacao.entidade.Fornecedor;
import br.com.utilitario.UtilGerador;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Administrador
 */
public class FornecedorDaoImplTest {

    private Fornecedor fornecedor;
    private FornecedorDaoImpl fornecedorDaoImpl;

    public FornecedorDaoImplTest() {
        fornecedorDaoImpl = new FornecedorDaoImpl();
    }

    @Test
    public void testSalvar() throws Exception {
        System.out.println("salvar");
        List<Endereco> enderecos = new ArrayList<>();
        //(Integer id, String nome, String email, String telefone, String cnpj, String inscricaoEstadual)
        fornecedor = new Fornecedor(
                null,
                "Nome" + UtilGerador.gerarCaracter(10),
                UtilGerador.gerarEmail(),
                UtilGerador.gerarTelefoneFixo(),
                UtilGerador.gerarNumero(10),
                UtilGerador.gerarNumero(5)
        );

        for (int i = 0; i < 2; i++) {
            enderecos.add(gerarEndereco());
        }
        fornecedor.setEnderecos(enderecos);
        fornecedorDaoImpl.salvar(fornecedor);
    }

    private Endereco gerarEndereco() {
        Endereco endereco = new Endereco(
                null,
                "Rua " + UtilGerador.gerarCaracter(10),
                UtilGerador.gerarNumero(3),
                UtilGerador.gerarCaracter(10),
                UtilGerador.gerarCaracter(10),
                UtilGerador.gerarCaracter(2),
                UtilGerador.gerarNumero(5) + "-" + UtilGerador.gerarNumero(3)
        );

        return endereco;
    }
}
