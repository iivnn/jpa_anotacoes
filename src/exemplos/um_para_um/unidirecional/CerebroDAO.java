package exemplos.um_para_um.unidirecional;

import CONNECTION.ConnectionFactory;
import javax.persistence.EntityManager;

/**
 *
 * @author iivnn
 */
public class CerebroDAO {
    
    private static final ConnectionFactory cf = new ConnectionFactory();
    private static EntityManager em;
    
    
    public static Cerebro save(Cerebro cerebro){
        em = cf.getConnection();
        em.getTransaction().begin();
        
        try{
            if (cerebro.getId() == null) {
                em.persist(cerebro);
            } else {
                em.merge(cerebro);
            }
            em.getTransaction().commit();
        }catch(Exception ex){
            System.err.println("///erro: " + ex);
            em.getTransaction().rollback();
        }finally{
            em.close();
            close();
        }
        
      return cerebro;
      
    }
    
    
    private static void close(){
        
        cf.closeConnection();
        
    }
}
