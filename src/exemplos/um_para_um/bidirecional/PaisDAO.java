package exemplos.um_para_um.bidirecional;

import CONNECTION.ConnectionFactory;
import javax.persistence.EntityManager;

/**
 *
 * @author iivnn
 */
public class PaisDAO {
    private static ConnectionFactory cf;
    private static EntityManager em;
    
    
    public static Pais save(Pais pais){
        cf = new ConnectionFactory(); 
        em = cf.getConnection();
        em.getTransaction().begin();
        
        try{
            if (pais.getId() == null) {
                em.persist(pais);
            } else {
                em.merge(pais);
            }
            em.getTransaction().commit();
        }catch(Exception ex){
            System.err.println("///erro: " + ex);
            em.getTransaction().rollback();
        }finally{
            em.close();
            close();
        }
        
      return pais;
      
    }
    
    
    private static void close(){
        
        cf.closeConnection();
        
    }   
}
