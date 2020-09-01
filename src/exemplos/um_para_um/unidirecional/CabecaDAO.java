package exemplos.um_para_um.unidirecional;

import CONNECTION.ConnectionFactory;
import javax.persistence.EntityManager;

/**
 *
 * @author iivnn
 */
public class CabecaDAO {
    private static final ConnectionFactory cf = new ConnectionFactory();
    private static EntityManager em;
    
    
    public static Cabeca save(Cabeca cabeca){
        em = cf.getConnection();
        em.getTransaction().begin();
        
        try{
            if (cabeca.getId() == null) {
                em.persist(cabeca);
            } else {
                em.merge(cabeca);
            }
            em.getTransaction().commit();
        }catch(Exception ex){
            System.err.println("///erro: " + ex);
            em.getTransaction().rollback();
        }finally{
            em.close();
            close();
        }
        
      return cabeca;
      
    }
    
    
    private static void close(){
        
        cf.closeConnection();
        
    }
}
