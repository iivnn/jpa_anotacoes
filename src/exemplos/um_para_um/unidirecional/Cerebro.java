package exemplos.um_para_um.unidirecional;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 *
 * @author iivnn
 */
@Entity
public class Cerebro implements Serializable {
    
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;
    
    private final String nome = "e um cerebro perstence a uma baceça";
    
    @OneToOne(optional = false)
  
    /**
     * 
     * Neste exemplo "PaisDetalhes" é a entidade dominante, o id de "Pais" vai 
     * para uma tabela de "PaisDetalhes" e caso a mesma seja removida também 
     * exclui esta entidade se estiverem relacionadas;
     * 
     * 
     */

    private Cabeca cabeca;
    

    public Cerebro() {
    }

    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Cabeca getCabeca() {
        return cabeca;
    }

    public void setCabeca(Cabeca cabeca) {
        this.cabeca = cabeca;
    }
    
    
}
