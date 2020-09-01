package exemplos.um_para_um.bidirecional;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 *
 * @author iivnn
 */
@Entity
public class Pais implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Integer id;
    
    private String nome;
    
    private String linguaOficial;
    
    private String continente;
    
    private long populacao;
    
    private boolean litoraneo;
    
    @OneToOne(
        mappedBy = "pais",
	cascade = CascadeType.ALL,
	orphanRemoval = true,
	fetch = FetchType.LAZY
	)
    
     /**
     * 
     * Neste exemplo "PaisDetalhes" é a entidade dominante, o id de "Pais" vai 
     * para uma tabela de "PaisDetalhes" e caso a mesma seja removida também 
     * exclui esta entidade se estiverem relacionadas;
     * 
     * 
     */

    private PaisDetalhes detalhes;// ver método setter;

    public Pais() {
    }

    public Pais(String nome, String linguaOficial, String continente, long populacao, boolean litoraneo, PaisDetalhes detalhes) {
        this.nome = nome;
        this.linguaOficial = linguaOficial;
        this.continente = continente;
        this.populacao = populacao;
        this.litoraneo = litoraneo;
        this.detalhes = detalhes;
    }

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

    public String getLinguaOficial() {
        return linguaOficial;
    }

    public void setLinguaOficial(String linguaOficial) {
        this.linguaOficial = linguaOficial;
    }

    public String getContinente() {
        return continente;
    }

    public void setContinente(String continente) {
        this.continente = continente;
    }

    public long getPopulacao() {
        return populacao;
    }

    public void setPopulacao(long populacao) {
        this.populacao = populacao;
    }

    public boolean isLitoraneo() {
        return litoraneo;
    }

    public void setLitoraneo(boolean litoraneo) {
        this.litoraneo = litoraneo;
    }

    public PaisDetalhes getDetalhes() {
        return detalhes;
    }

    public void setDetalhes(PaisDetalhes detalhes) {
        detalhes.setPais(this);
        this.detalhes = detalhes;
    }
    
    public void removeDetalhes(){
        this.detalhes = null;
    }
    
}
