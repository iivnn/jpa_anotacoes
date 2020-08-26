
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
 * @Embeddable
 * Essa anotação indica que a classe será do tipo "embutível" e não tem chave primária e
 * assim como uma entidade deve possuir um construtor sem parâmetros e seus getters e setters;
 * Classes do tipo "@Embeddable" podem ser mapeadas como "@ElementCollection";
 * https://docs.jboss.org/hibernate/orm/5.3/userguide/html_single/Hibernate_User_Guide.html#embeddables
 * 
 */
@Access(AccessType.FIELD)
public class Endereco implements Serializable {
    
    private String rua;
    
    private int numero;
    
    private String cidade;
    
    private String pais;

    public Endereco() {
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }
    
    
}
