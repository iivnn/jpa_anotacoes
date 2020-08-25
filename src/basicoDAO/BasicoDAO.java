package basicoDAO;

import basico.Basico;
import connection.ConnectionFactory;
import javax.persistence.EntityManager;


public class BasicoDAO {
    
    private EntityManager em;
    private ConnectionFactory cf;

    public BasicoDAO() {
        cf = new ConnectionFactory();
        em = cf.getConnection();
    }
    
    public Basico save(Basico basico){
        em.getTransaction().begin();
        try{
            if(basico.getChavePrimaria() == null){
                em.persist(basico);
            }else{
                em.merge(basico);
            }
            em.getTransaction().commit();
        }catch(Exception ex){
            System.err.println("///////erro: " + ex);
            em.getTransaction().rollback();
        }finally{
            close();
        }
        
        return basico;
    }
    
    public void close(){
        cf.closeConnection(em);
    }
}
