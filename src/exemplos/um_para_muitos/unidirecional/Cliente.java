package exemplos.um_para_muitos.unidirecional;

import java.io.Serializable;
import java.util.List;
import javax.naming.SizeLimitExceededException;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author iivnn
 */

@Entity
@Access(AccessType.PROPERTY)
public class Cliente implements Serializable {
    //ver metódos;
    private Long id;
    private String name;
    private List<Pedido> pedidos;
    
    

    public Cliente() {
    }

    public Cliente(String name, List<Pedido> pedidos) throws SizeLimitExceededException {
        
        try {
            setName(name);
        }catch(SizeLimitExceededException ex){
            throw ex;
        }
        this.pedidos = pedidos;
        
    }
    
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    @Column(nullable = false, length = 80)
    public String getName() {
        return name;
    }

    public void setName(String name) throws SizeLimitExceededException {
        if(name.length() < 80){
            this.name = name.trim().toUpperCase();
        }else{
            throw new SizeLimitExceededException("Nome muito grande, deve conter"
                    + " no máximo 80 caracteres");
        }
    }
    
    
    /**
     * 
     * A anotação @OneToMany faz a associação entre uma entidade filha e uma 
     * entidade pai. Neste exemplo caso uma entidade pai for excluída as entidades
     * filhos não serão excluídas ("orphanRemoval = false");
     * https://docs.jboss.org/hibernate/orm/5.3/userguide/html_single/Hibernate_User_Guide.html#associations-one-to-many
     * obs: neste caso é criado uma terceira tabela chamada "cliente_pedido"
     * guardando as chaves do relacionamento;
     * 
     */

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = false)
    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }
    
    
    
    
    
    
    
    
    
    
}
