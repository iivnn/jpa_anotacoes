package exemplos.muitos_para_um;

import org.junit.Test;

/**
 *
 * @author iivnn
 */
public class PaiDAOTest {
    
    public PaiDAOTest() {
    }

    @Test
    public void testSave() {
        
        Pai pai = new Pai();
        
        pai = PaiDAO.save(pai);
        
        Filho filho = new Filho();
        filho.setPai(pai);
        
        filho = FilhoDAO.save(filho);
        
        
        
    }
    
}
