/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.associacao.dao;

import br.com.associacao.entidade.Professor;
import br.com.associacao.entidade.Telefone;
import br.com.utilitario.UtilGerador;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

/**
 *
 * @author Administrador
 */
public class ProfessorDaoImplTest {
    private Professor professor;
    private ProfessorDaoImpl professorDaoImpl;
    
    public ProfessorDaoImplTest() {
        professorDaoImpl = new ProfessorDaoImpl();
    }

    @Test
    public void testSalvar() throws Exception {
        System.out.println("Salvar");
        
        professor = new Professor(                        
            null, 
            UtilGerador.gerarCaracter(10), 
            UtilGerador.gerarNumero(11), 
            UtilGerador.gerarNumero(5) 
        );
        
        List<Telefone> telefone = new ArrayList<>();
        for (int i = 0; i < 2; i++) {                     
            telefone.add(gerarTelefone());
        }
        
        professor.setTelefone(telefone);
        professorDaoImpl.salvar(professor);
    }    
        
    private Telefone gerarTelefone(){
        Telefone telefone = new Telefone(
                null, 
                UtilGerador.gerarCaracter(10), 
                UtilGerador.gerarNumero(11), 
                UtilGerador.gerarCaracter(5)
        );
        return telefone;
    }
}
