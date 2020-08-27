package basico;

import CONNECTION.ConnectionFactory;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author iivnn
 */

public class PessoaDAO {
    

    private static final ConnectionFactory cf = new ConnectionFactory();
    private static EntityManager em;
    
    
    public static Pessoa save(Pessoa pessoa){
        em = cf.getConnection();
        em.getTransaction().begin();
        
        try{
            if (pessoa.getId() == null) {
                em.persist(pessoa);
            } else {
                em.merge(pessoa);
            }
            em.getTransaction().commit();
        }catch(Exception ex){
            System.err.println("///erro: " + ex);
            em.getTransaction().rollback();
        }finally{
            em.close();
            close();
        }
        
      return pessoa;
      
    }
    
    public static Pessoa find(Integer id){
        
        Pessoa pessoa = null;
        em = cf.getConnection();
        try{
            pessoa = em.find(Pessoa.class, id);
        }catch(Exception ex){
            System.err.println("////erro : " + ex);
        }finally{
            em.close();
            close();
        }
        
        return pessoa;
        
    }
    
    private static void close(){
        
        cf.closeConnection();
        
    }
    
    
}
