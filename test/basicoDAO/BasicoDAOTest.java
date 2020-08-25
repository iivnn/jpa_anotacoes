package basicoDAO;

import basico.Basico;
import basico.Embutido;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

/**
 *
 * @author ivan
 */
public class BasicoDAOTest {
    
    public BasicoDAOTest() {
    }

    @Test
    public void testSave() {
        
        BasicoDAO dao = new BasicoDAO();
        Basico basico = new Basico();
        Embutido embutido = new Embutido();
        List<Embutido> embutidos = new ArrayList<>();
        List<String> strings = new ArrayList<>();
        
        embutido.setInteiroEmbutido(5354);
        embutido.setStringEmbutida("fui embutido");
        
        embutidos.add(new Embutido());
        embutidos.get(0).setInteiroEmbutido(1);
        embutidos.get(0).setStringEmbutida("Sou o primeiro");
        embutidos.add(new Embutido());
        embutidos.get(1).setInteiroEmbutido(2);
        embutidos.get(1).setStringEmbutida("Sou o segundo");
        embutidos.add(new Embutido());
        embutidos.get(2).setInteiroEmbutido(3);
        embutidos.get(2).setStringEmbutida("Sou o terceiro");
        
        
        strings.add("primeira string");
        strings.add("segunda string");
        strings.add("terceira string");
        strings.add("quarta string");
        
        basico.setIgnorado("TesTe dO iGnOrAdO");
        basico.setNao_Opcional("Não sou opcional");
        basico.setEmbutido(embutido);
        basico.setTabelaEmbutido(embutidos);
        basico.setLista(strings);
        
        basico = dao.save(basico);
        
        try{
            System.out.println("Id do novo Objeto criado -> " + basico.getChavePrimaria());
        }catch(NullPointerException ex){
            System.err.println("////erro: " + ex);
        }finally{
            System.out.println("Verificar o banco de dados!");
            dao.close();
        }
        
    }

    
    
    
}
