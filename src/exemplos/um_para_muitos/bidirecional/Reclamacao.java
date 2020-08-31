package exemplos.um_para_muitos.bidirecional;

import java.io.Serializable;
import javax.persistence.Column;
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
class Reclamacao implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    int id;
    
    @Column(columnDefinition="TEXT")
    String texto;
    
   /**
     * 
     * Com a anotação @ManyToOne agora é possível navegar por essa relação por
     * ambos os lados;
     * obs: neste exemplo a chave primária de "Usuario" vai para uma coluna em
     * "Reclamacao" não criando uma terceira tabela como no exemplo de um
     * para muito unidirecional;
     * 
     */

    @ManyToOne
    Usuario autor;

    public Reclamacao() {
        
    }

    public Reclamacao(String texto, Usuario autor) {
        this.texto = texto;
        this.autor = autor;
    }
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Usuario getAutor() {
        return autor;
    }

    public void setAutor(Usuario autor) {
        this.autor = autor;
    }
 
    
}
