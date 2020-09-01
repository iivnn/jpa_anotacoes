package exemplos.um_para_um.bidirecional;

import java.math.BigInteger;
import org.junit.Test;

/**
 *
 * @author iivnn
 */
public class PaisDAOTest {
    
    public PaisDAOTest() {
    }

    @Test
    public void testSave() {
        
        Pais brasil = new Pais();
        PaisDetalhes brasilInfo = new PaisDetalhes();
        
        brasil.setContinente("America");
        brasil.setLinguaOficial("PT-BR");
        brasil.setLitoraneo(true);
        brasil.setNome("Brasil");
        brasil.setPopulacao(210147125);
        
        brasilInfo.setCapital("Brasilia");
        brasilInfo.setClima("	Equatorial, árido, semiárido, subtropical "
                + "oceânico, subtropical de altitude, subtropical úmido, tropical "
                + "savânico e tropical monçônico");
        brasilInfo.setIdh(0.761);
        brasilInfo.setPib(new BigInteger("2141000000000"));
        
        brasil = PaisDAO.save(brasil);
        
        //brasil.setDetalhes(brasilInfo);
        
        //brasil = PaisDAO.save(brasil);
        
       // brasil.removeDetalhes();
        
       //brasil = PaisDAO.save(brasil);
        
        
        
    }
    
}
