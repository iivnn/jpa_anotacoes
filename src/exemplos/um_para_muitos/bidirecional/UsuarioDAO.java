package exemplos.um_para_muitos.bidirecional;

import CONNECTION.ConnectionFactory;
import javax.persistence.EntityManager;

/**
 *
 * @author iivnn
 */

public class UsuarioDAO {
        private static final ConnectionFactory cf = new ConnectionFactory();
    private static EntityManager em;
    
    
    public static Usuario save(Usuario user){
        em = cf.getConnection();
        em.getTransaction().begin();
        
        try{
            if (user.getId() == null) {
                em.persist(user);
            } else {
                em.merge(user);
            }
            em.getTransaction().commit();
        }catch(Exception ex){
            System.err.println("///erro: " + ex);
            em.getTransaction().rollback();
        }finally{
            em.close();
            close();
        }
        
      return user;
      
    }
    
    
    private static void close(){
        
        cf.closeConnection();
        
    }
}
