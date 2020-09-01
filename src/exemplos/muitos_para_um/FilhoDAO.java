package exemplos.muitos_para_um;

import CONNECTION.ConnectionFactory;
import javax.persistence.EntityManager;

/**
 *
 * @author iivnn
 */
public class FilhoDAO {
    
    private static final ConnectionFactory cf = new ConnectionFactory();
    private static EntityManager em;
    
    
    public static Filho save(Filho filho){
        em = cf.getConnection();
        em.getTransaction().begin();
        
        try{
            if (filho.getId() == null) {
                em.persist(filho);
            } else {
                em.merge(filho);
            }
            em.getTransaction().commit();
        }catch(Exception ex){
            System.err.println("///erro: " + ex);
            em.getTransaction().rollback();
        }finally{
            em.close();
            close();
        }
        
      return filho;
      
    }
    
    
    private static void close(){
        
        cf.closeConnection();
        
    }
    
}
