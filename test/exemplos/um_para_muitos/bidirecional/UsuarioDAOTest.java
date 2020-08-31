/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exemplos.um_para_muitos.bidirecional;

import exemplos.um_para_muitos.bidirecional.Usuario;
import exemplos.um_para_muitos.bidirecional.UsuarioDAO;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

/**
 *
 * @author ivan
 */
public class UsuarioDAOTest {
    
    public UsuarioDAOTest() {
    }

    @Test
    public void testSave() {
        
        Usuario usuario = new Usuario("João da Silva");
        
        List<Reclamacao> reclamacoes = new ArrayList<>();
        
        reclamacoes.add(new Reclamacao("teste 1", usuario));
        reclamacoes.add(new Reclamacao("teste 2", usuario));
        reclamacoes.add(new Reclamacao("teste 3", usuario));
        reclamacoes.add(new Reclamacao("teste 4", usuario));
        
        usuario.setReclamacoes(reclamacoes);
        
        usuario = UsuarioDAO.save(usuario);
        
        System.out.println("id usuario ->" + usuario.getId());
        
        
    }
    
}
