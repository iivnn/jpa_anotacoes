/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basico;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author ivan
 */
public class PessoaDAOTest {
    
    public PessoaDAOTest() {
    }

    @Ignore
    public void testSave() {
        
        Pessoa pessoa = new Pessoa();
        Endereco endereco = new Endereco();
        List<Telefone> telefones = new ArrayList<>();
        List<String> apelidos = new ArrayList<>();
        
        endereco.setCidade("Belo Horizonte");
        endereco.setNumero(345);
        endereco.setPais("Brasil");
        endereco.setRua("Rua exemplo");
        
        telefones.add(new Telefone());
        telefones.get(0).setNumero(33333333);
        telefones.get(0).setTipo("fixo");
        
        telefones.add(new Telefone());
        telefones.get(1).setNumero(993333333);
        telefones.get(1).setTipo("movel");
        
        telefones.add(new Telefone());
        telefones.get(2).setNumero(999998888);
        telefones.get(2).setTipo("movel");
        
        apelidos.add("zé");
        apelidos.add("dumbo");
        apelidos.add("nareba");
        
        pessoa.setEndereco(endereco);
        pessoa.setTelefones(telefones);
        pessoa.setApelidos(apelidos);
        pessoa.setNome("José Roberto da Silva");
        pessoa.setDescricao("Apenas mais uma pessoa");
        
        
        
        try{
            pessoa = PessoaDAO.save(pessoa);
            System.out.println("Id ->" + pessoa.getId());
        }catch(Exception ex){
            System.err.println("////erro: " + ex);
        }
    
    }
    
    @Test
    public void testFind(){
        
        Pessoa pessoa = new Pessoa();
        pessoa = PessoaDAO.find(1);
        System.out.println("id => " + pessoa.getId());    
        System.out.println("nome => " + pessoa.getNome()); 
        System.out.println("desc => " + pessoa.getDescricao()); 
        System.out.print("endereco => ");
        System.out.print(pessoa.getEndereco().getPais() + " - ");
        System.out.print(pessoa.getEndereco().getCidade() + " - ");
        System.out.print(pessoa.getEndereco().getRua()+ " - ");
        System.out.print(pessoa.getEndereco().getNumero()+ "\n");
    }
    
}
