package basico;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Basic;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

/**
 *
 * @author iivnn
 * Classe para exemplificar o uso das principais anotações do JPA para começar a
 * persistir em banco de dados utilizando framework de ORM;
 * 
 * 
 */

@Entity
/**
 * 
 * @Entity
 * A anotação @Entity é usada para especificar que a classe é do tipo entidade e
 * que será uma tabela no banco de dados; Uma entidade obrigatoriamente precisa
 * de um construtor sem parâmetros, não pode ser final, deve possuir todos
 * getters e setters e ter um identificador "@Id"; 
 * https://docs.jboss.org/hibernate/orm/5.3/userguide/html_single/Hibernate_User_Guide.html#entity
 *
 * 
 */

@Access(AccessType.FIELD)
/**
 *
 * @Access
 * Usado para especificar o tipo de acesso da classe ou atributo: FIELD = por
 * atributo , PROPERTY = pelo método; 
 * https://docs.jboss.org/hibernate/orm/5.3/userguide/html_single/Hibernate_User_Guide.html#access
 *
 * 
 */

public class Pessoa implements Serializable { // Obs: A classe deve implementar a interface "Serializable";
    
    @Id
    /**
     * 
     * @Id
     * Indica que o atributo será chave primária da tabela;
     * https://docs.jboss.org/hibernate/orm/5.3/userguide/html_single/Hibernate_User_Guide.html#identifiers
     * 
     * 
     */
    
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    /**
     * 
     * @GeneratedValue
     * Indica que o valor será gerado automaticamente definindo um tipo de 
     * estratégia como no exemplo;
     * https://docs.jboss.org/hibernate/orm/5.3/userguide/html_single/Hibernate_User_Guide.html#identifiers-simple-generated
     * 
     * 
     */
    
    private Integer id;
    
    @Basic(optional = false)
    /**
     * 
     *  @Basic
     *  Usado para mapear um atributo básico para uma coluna do banco de dados, 
     *  mas pode ser omitido;
     *  o parâmetro “optional” recebendo falso faz com que a coluna no banco de 
     *  dados não seja opcional, por padrão seu valor e verdadeiro; 
     *  https://docs.jboss.org/hibernate/orm/5.3/userguide/html_single/Hibernate_User_Guide.html#basic
     * 
     * 
     */
    
    private String nome;
    
    @Transient
    /**
     * 
     * @Transient
     * Faz com que o atributo seja ignorado ao ser persistido (ver metodo 
     * "get" do atributo);
     * https://docs.jboss.org/hibernate/orm/5.3/userguide/html_single/Hibernate_User_Guide.html#events-jpa-callbacks-example
     * 
     * 
     */
    
    private String descricao;
    
    @ElementCollection
    /**
     * 
     * @ElementCollection
     * Permite persistir elementos de uma coleção de tipo básico, ou embeddable,
     * em uma tabela separada;
     * https://docs.jboss.org/hibernate/orm/5.3/userguide/html_single/Hibernate_User_Guide.html#collections
     * obs: é aconselhável não utilizar o @ElementCollection, criar uma entidade
     * separada neste caso  é melhor por facilitar
     * na hora de criar o DAO "data access object", diminuindo a quantidade de 
     * código  e complexidade do código;
     * 
     */
   
    
    private List<String> apelidos;
    
    @Embedded
    /**
     * 
     * @Embedded
     * Ver classe "Endereco";
     * https://docs.jboss.org/hibernate/orm/5.3/userguide/html_single/Hibernate_User_Guide.html#embeddables
     * 
     * 
     */
    
    private Endereco endereco;
    
    @ElementCollection // Exemplo com @Embeddable;
    private List<Telefone> telefones;
    

    //Métodos da classe;
    
    public Pessoa() { //Construtor sem parâmetros;
        
    }
    
    //Getters e Setters;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Access(AccessType.PROPERTY)
    /**
     * 
     * Agora quando a entidade for persistida ao invés de acessar o atributo vai
     * utilizar o método colocando tudo para maiusculo;
     *
     * 
     */
     
    public String getDescricao() {
        return descricao == null ? "" : descricao.toUpperCase();
        //obs: caso omita o @Transient no atributo "desc" será criado duas colunas para o mesmo valor;
    }

    public void setDescricao(String desc) {
        this.descricao = desc;
    }

    public List<String> getApelidos() {
        return apelidos;
    }

    public void setApelidos(List<String> apelidos) {
        this.apelidos = apelidos;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public List<Telefone> getTelefones() {
        return telefones;
    }

    public void setTelefones(List<Telefone> telefones) {
        this.telefones = telefones;
    } 

    
}
