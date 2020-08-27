package CONNECTION;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ConnectionFactory {

    private  EntityManagerFactory emf;

    public ConnectionFactory() {
        
        emf = Persistence.createEntityManagerFactory("xmlPU");
        
    }
    
    public EntityManager getConnection(){
        
        return emf.createEntityManager();
        
    }
    
    public void closeConnection(){
        
        emf.close();
        
    }

}
