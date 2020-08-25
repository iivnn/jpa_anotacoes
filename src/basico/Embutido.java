
package basico;

import java.io.Serializable;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Embeddable;

/**
 *
 * @author ivan
 */

@Embeddable
/**
 * 
 * Essa anotação indica que a classe sera do tipo "embutivel" e não tera chave primária e
 * assim como uma entidade deve possuir um contrutor sem parametros e seus getters e setters;
 * https://docs.jboss.org/hibernate/orm/5.3/userguide/html_single/Hibernate_User_Guide.html#embeddables
 * Classes do tipo "@Embeddable" podem ser mapeadas como "@ElementCollection";
 * 
 */

@Access(AccessType.FIELD)
public class Embutido implements Serializable {
    
    private int inteiroEmbutido;
    
    private String stringEmbutida;

    public Embutido() {
    }

    public int getInteiroEmbutido() {
        return inteiroEmbutido;
    }

    public void setInteiroEmbutido(int inteiroEmbutido) {
        this.inteiroEmbutido = inteiroEmbutido;
    }

    public String getStringEmbutida() {
        return stringEmbutida;
    }

    public void setStringEmbutida(String stringEmbutida) {
        this.stringEmbutida = stringEmbutida;
    }
    
}
