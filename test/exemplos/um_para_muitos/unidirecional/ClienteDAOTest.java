package exemplos.um_para_muitos.unidirecional;

import exemplos.um_para_muitos.unidirecional.ClienteDAO;
import exemplos.um_para_muitos.unidirecional.Pedido;
import exemplos.um_para_muitos.unidirecional.Cliente;
import java.util.ArrayList;
import java.util.List;
import javax.naming.SizeLimitExceededException;
import org.junit.Test;

/**
 *
 * @author iivnn
 */
public class ClienteDAOTest {
    
    public ClienteDAOTest() {
    }

    @Test
    public void testSave() {
        
        List<Pedido> pedidos = new ArrayList<>();
        
        pedidos.add(new Pedido("Um pedido feito...", 24.90));
        pedidos.add(new Pedido("Mais um pedido feito...", 80.90));
        pedidos.add(new Pedido("Outro pedido feito...", 79.90));
        pedidos.add(new Pedido("E é outro pedido feito...", 900.90));
                        
        try {
            Cliente cliente = new Cliente("GiLmar Dos SaNtos    ", pedidos);
            cliente = ClienteDAO.save(cliente);
            System.out.println("Cliente id -> " + cliente.getId());
        }catch (SizeLimitExceededException ex) {
            System.err.println("////erro: " + ex);;
        }
        
    }
        
  
    
}
