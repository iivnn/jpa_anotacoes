package exemplos.um_para_muitos.unidirecional;

import CONNECTION.ConnectionFactory;
import javax.persistence.EntityManager;


public class ClienteDAO {
    private static final ConnectionFactory cf = new ConnectionFactory();
    private static EntityManager em;
    
    
    public static Cliente save(Cliente cliente){
        em = cf.getConnection();
        em.getTransaction().begin();
        
        try{
            if (cliente.getId() == null) {
                em.persist(cliente);
            } else {
                em.merge(cliente);
            }
            em.getTransaction().commit();
        }catch(Exception ex){
            System.err.println("///erro: " + ex);
            em.getTransaction().rollback();
        }finally{
            em.close();
            close();
        }
        
      return cliente;
      
    }
    
    
    private static void close(){
        
        cf.closeConnection();
        
    }
    
}
