package exemplos.um_para_um.bidirecional;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

/**
 *
 * @author iivnn
 */
@Entity
class PaisDetalhes implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Integer id;
    
    private String capital;
    
    private BigInteger pib;
    
    private String clima;
    
    private double idh;
    
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pais_id")
    private Pais pais;

    public PaisDetalhes() {
    }

    public PaisDetalhes(String capital, BigInteger pib, String clima, int idh, Pais pais) {
        this.capital = capital;
        this.pib = pib;
        this.clima = clima;
        this.idh = idh;
        this.pais = pais;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public BigInteger getPib() {
        return pib;
    }

    public void setPib(BigInteger pib) {
        this.pib = pib;
    }

    public String getClima() {
        return clima;
    }

    public void setClima(String clima) {
        this.clima = clima;
    }

    public double getIdh() {
        return idh;
    }

    public void setIdh(double idh) {
        this.idh = idh;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }
    
    
    
}
