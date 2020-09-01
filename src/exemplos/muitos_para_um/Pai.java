package exemplos.muitos_para_um;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author iivnn
 */
@Entity
public class Pai implements Serializable {
    
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)        
    private Integer id;
    
    private final String nome = "Esta é a classe pai";

    public Pai() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}
