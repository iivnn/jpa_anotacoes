package exemplos.muitos_para_um;

import CONNECTION.ConnectionFactory;
import javax.persistence.EntityManager;

/**
 *
 * @author iivnn
 */
public class PaiDAO {
    
    private static final ConnectionFactory cf = new ConnectionFactory();
    private static EntityManager em;
    
    
    public static Pai save(Pai pai){
        em = cf.getConnection();
        em.getTransaction().begin();
        
        try{
            if (pai.getId() == null) {
                em.persist(pai);
            } else {
                em.merge(pai);
            }
            em.getTransaction().commit();
        }catch(Exception ex){
            System.err.println("///erro: " + ex);
            em.getTransaction().rollback();
        }finally{
            em.close();
            close();
        }
        
      return pai;
      
    }
    
    
    private static void close(){
        
        cf.closeConnection();
        
    }
    
}
