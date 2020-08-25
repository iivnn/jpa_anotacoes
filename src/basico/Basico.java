package basico;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Basic;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

/**
 *
 * @author ivan Classe para exemplificar o uso das principais anotações do JPA.
 * Fonte: https://dzone.com/articles/all-jpa-annotations-mapping-annotations
 * https://strn.com.br/artigos/2018/12/11/todas-as-anota%C3%A7%C3%B5es-do-jpa-anota%C3%A7%C3%B5es-de-mapeamento/
 * https://docs.jboss.org/hibernate/orm/5.3/userguide/html_single/Hibernate_User_Guide.html#entity
 * 
 */

@Entity

/**
 *
 * A anotação @Entity e usada para especificar que a classe é do tipo entidade e
 * que sera uma tabela no banco de dados; Uma entidade obrigatóriamente precisa
 * de um construtor sem parametros, não pode ser final, deve possuir todos
 * getters e setters e ter um identificador (@Id); 
 * https://docs.jboss.org/hibernate/orm/5.3/userguide/html_single/Hibernate_User_Guide.html#entity
 *
 */

@Access(AccessType.FIELD)

/**
 *
 * Usado para especificar o tipo de acesso da classe ou atributo: FIELD = por
 * atributo , PROPERTY = pelo metodo; 
 * https://docs.jboss.org/hibernate/orm/5.3/userguide/html_single/Hibernate_User_Guide.html#access
 *
 */

public class Basico implements Serializable {
    
    @Id //Indica que o atributo sera chave primária da tabela; https://docs.jboss.org/hibernate/orm/5.3/userguide/html_single/Hibernate_User_Guide.html#identifiers
    @GeneratedValue (strategy = GenerationType.IDENTITY) //Indica que o valor sera gerado automaticamente; https://docs.jboss.org/hibernate/orm/5.3/userguide/html_single/Hibernate_User_Guide.html#identifiers-simple-generated
    private Integer chavePrimaria;
    
    @Basic(optional = false)//Usado para mapear um atributo basico para uma coluna do BD, pode ser omitido; https://docs.jboss.org/hibernate/orm/5.3/userguide/html_single/Hibernate_User_Guide.html#basic
    private String nao_Opcional;//Por não poder ser opcional não podera ser persistido como valor nulo;
    
    @Transient//Faz com que o atributo seja ignorado ao ser persistido (ver metodo "get" do atributo);
    private String ignorado;
    
    @ElementCollection //Permite persistir elementos de uma coleção de tipo básico em uma tabela separada; https://docs.jboss.org/hibernate/orm/5.3/userguide/html_single/Hibernate_User_Guide.html#collections
    @CollectionTable(name="lista") // Permite alterar o nome da nova tabela;
    @Column(name="lista_basico") // Permite alterar o nome da coluna;
    private List<String> lista;
    
    @Embedded //Ver classe "Embutido"; https://docs.jboss.org/hibernate/orm/5.3/userguide/html_single/Hibernate_User_Guide.html#embeddables
    private Embutido embutido;
    //Agora os atributos de "Embutibo" vão para tabela do "Basico;
    
    @ElementCollection
    private List<Embutido> tabelaEmbutido; // Agora sera persistido em uma tabela a parte; 
    
  
    
    public Basico() {
    }

    public Integer getChavePrimaria() {
        return chavePrimaria;
    }

    public void setChavePrimaria(Integer chavePrimaria) {
        this.chavePrimaria = chavePrimaria;
    }

    public String getNao_Opcional() {
        return nao_Opcional;
    }

    public void setNao_Opcional(String nao_Opcional) {
        this.nao_Opcional = nao_Opcional;
    }
    
    @Access(AccessType.PROPERTY) //Agora quando a entidade for persistida ao inves de acessar o atributo utilizara o metodo colocando tudo pra maiusculo; 
    public String getIgnorado() {
        return ignorado == null ? "" : ignorado.toUpperCase();
        //obs: caso omita o @Transient no atributo "ignorado" será criado duas colunas para o mesmo valor;
    }

    public void setIgnorado(String ignorado) {
        this.ignorado = ignorado;
    }

    public List<String> getLista() {
        return lista;
    }

    public void setLista(List<String> lista) {
        this.lista = lista;
    }

    public Embutido getEmbutido() {
        return embutido;
    }

    public void setEmbutido(Embutido embutido) {
        this.embutido = embutido;
    }

    public List<Embutido> getTabelaEmbutido() {
        return tabelaEmbutido;
    }

    public void setTabelaEmbutido(List<Embutido> tabelaEmbutido) {
        this.tabelaEmbutido = tabelaEmbutido;
    }
   
    
}

