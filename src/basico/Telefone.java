package basico;

import java.io.Serializable;
import javax.persistence.Embeddable;

/**
 *
 * @author iivnn
 */

@Embeddable
public class Telefone implements Serializable {
    
    private String tipo;
    private int numero;

    public Telefone() {
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    @Override
    public String toString() {
        return "Telefone{" + "tipo=" + tipo + ", numero=" + numero + '}';
    }
    
    
    
    
}
