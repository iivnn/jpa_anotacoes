package exemplos.muitos_para_um;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author iivnn
 */
@Entity
public class Filho implements Serializable {
    
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)        
    private Integer id;
    
    private final String nome = "Esta é a classe filho";
    
    /**
     * 
     * A anotação @ManyToOne define a mais comum associação nos bancos de dados
     * estabelecendo uma relação de entidade pai e filho;
     * 
     */
    @ManyToOne
    private Pai pai;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Pai getPai() {
        return pai;
    }

    public void setPai(Pai pai) {
        this.pai = pai;
    }
    
    
}
