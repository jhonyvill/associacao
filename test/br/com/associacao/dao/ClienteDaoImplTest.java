/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.associacao.dao;

import br.com.associacao.entidade.Cliente;
import br.com.associacao.entidade.Endereco;
import br.com.utilitario.UtilGerador;
import java.util.List;
import org.junit.Test;


/**
 *
 * @author Administrador
 */
public class ClienteDaoImplTest {
    
    private Cliente cliente;
    private ClienteDaoImpl clienteDaoImpl;
    
    public ClienteDaoImplTest() {
        clienteDaoImpl = new ClienteDaoImpl();
    }

    @Test
    public void testSalvar() throws Exception {
        System.out.println("Salvar");
        cliente = new Cliente(
                null, 
                UtilGerador.gerarCaracter(10), 
                UtilGerador.gerarEmail(), 
                UtilGerador.gerarTelefoneFixo(), 
                Double.parseDouble(UtilGerador.gerarNumero(3))
        );
        
        Endereco endereco = new Endereco(
                null, 
                "Rua " + UtilGerador.gerarCaracter(10), 
                UtilGerador.gerarNumero(3), 
                UtilGerador.gerarCaracter(10), 
                UtilGerador.gerarCaracter(10), 
                UtilGerador.gerarCaracter(2), 
                UtilGerador.gerarNumero(5) + "-" + UtilGerador.gerarNumero(3)
        );
        cliente.setEndereco(endereco);
        clienteDaoImpl.salvar(cliente);
    }

//    @Test
    public void testAlterar() throws Exception {
        System.out.println("Alterar");
        
        cliente = clienteDaoImpl.pesquisarPorId(7);
        cliente.setNome("Nome alterado: " + UtilGerador.gerarCaracter(10));
        cliente.getEndereco().setLogradouro("Logradouro alterado");
        clienteDaoImpl.alterar(cliente);
    }

//    @Test
    public void testExcluir() throws Exception {
        System.out.println("Excluir");
        clienteDaoImpl.excluir(6);
    }
    
//    @Test
    public void testPesquisarPorId() throws Exception {
        System.out.println("Pesquisar por id:");
        cliente = clienteDaoImpl.pesquisarPorId(7);
        System.out.println("id: " + cliente.getId());
        System.out.println("Nome: " + cliente.getNome());
        System.out.println("E-mail: " + cliente.getEmail());
        System.out.println("Telefone: " + cliente.getTelefone());
        System.out.println("Salário: " + cliente.getSalario());
        System.out.println("");
        System.out.println("IDEndereco: " + cliente.getEndereco().getId());
        System.out.println("Logradouro: " + cliente.getEndereco().getLogradouro());
        System.out.println("Número: " + cliente.getEndereco().getNumero());
        System.out.println("Bairro: " + cliente.getEndereco().getBairro());
        System.out.println("Cidade: " + cliente.getEndereco().getCidade());
        System.out.println("CEP: " + cliente.getEndereco().getCep());
        System.out.println("Estado: " + cliente.getEndereco().getEstado());
    }

//    @Test
    public void testPesquisarNome() throws Exception {
        System.out.println("Pesquisar por nome:");
        List<Cliente> clientes = clienteDaoImpl.pesquisarNome("e");
        for (Cliente cli : clientes) {
            System.out.println("id: " + cli.getId());
            System.out.println("Nome: " + cli.getNome());
            System.out.println("E-mail: " + cli.getEmail());
            System.out.println("Telefone: " + cli.getTelefone());
            System.out.println("Salário: " + cli.getSalario());
            System.out.println("");
        }
    }
    
    
    
}
