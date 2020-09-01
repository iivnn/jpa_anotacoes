
package exemplos.um_para_um.unidirecional;

import org.junit.Test;

/**
 *
 * @author iivnn
 */
public class CabecaDAOTest {
    
    public CabecaDAOTest() {
    }

    @Test
    public void testSave() {
        
        Cabeca cabeca = new Cabeca();
        
        Cerebro cerebro = new Cerebro();
        
        cabeca = CabecaDAO.save(cabeca);
  
        cerebro.setCabeca(cabeca);
        
        cerebro = CerebroDAO.save(cerebro);
        
        
    }
    
}
