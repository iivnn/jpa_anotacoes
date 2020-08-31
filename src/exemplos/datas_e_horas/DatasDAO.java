package exemplos.datas_e_horas;

import CONNECTION.ConnectionFactory;
import javax.persistence.EntityManager;


public class DatasDAO {
    
    private static final ConnectionFactory cf = new ConnectionFactory();
    private static EntityManager em;

    public static Datas save(Datas data){
        em = cf.getConnection();
        em.getTransaction().begin();
        try{
            em.persist(data);
            em.getTransaction().commit();
        }catch(Exception ex){
            System.err.println("///// erro: " + ex);
            em.getTransaction().rollback();
        }finally{
            em.close();
            cf.closeConnection();
        }
        
        return data;
        
    }
    
    
}
