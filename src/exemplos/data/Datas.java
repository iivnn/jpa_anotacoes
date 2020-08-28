package exemplos.data;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
/**
 * 
 * Classe para dar exemplos de como mapear data para serem persistidas 
 * no banco de dados;
 * https://docs.jboss.org/hibernate/orm/5.3/userguide/html_single/Hibernate_User_Guide.html#basic-datetime
 * @author iivnn
 */
@Entity
public class Datas implements Serializable {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY )
    private Integer id;

    
    @Temporal(TemporalType.DATE)
    /**
     * 
     * A anotação @Temporal é usada para especificar o "tipo de tempo" do 
     * atributo java.util.Date ou java.util.Calendar;
     * 
     * TemporalType.TIME = horas;
     * TemporalType.DATE = data;
     * TemporalType.TIMESTAMP = data e horas;
     * 
     * obs: datas do tipo java.sql.Date ou datas do pacote java.time
     * não precisam ser mapeadas. Exemplo das datas sendo instanciadas no pacote
     * de testes em test/exemplos/data/DatasDAOTest.java;
     * 
     * obs: talvez seja mais inteligente salvar uma data como um atributo do 
     * tipo "Long" no banco de dados e mudar para "Date" na aplicação que 
     * estiver tratando com este dado;
     * 
     */
    private java.util.Date dateUtil;
    
    @Temporal(TemporalType.TIME)
    private java.util.Date timeUtil;
    
    @Temporal(TemporalType.TIMESTAMP)
    private java.util.Date timestampUtil;
    
    private java.sql.Date dateSQL;
    
    private java.time.LocalDate timeDate;
    
    private java.time.LocalTime timeTime;
    
    private java.time.LocalDateTime timestampTime;

    public Datas(){
        
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public java.sql.Date getDateSQL() {
        return dateSQL;
    }

    public void setDateSQL(java.sql.Date dateSQL) {
        this.dateSQL = dateSQL;
    }

    public java.util.Date getDateUtil() {
        return dateUtil;
    }

    public void setDateUtil(java.util.Date dateUtil) {
        this.dateUtil = dateUtil;
    }

    public java.util.Date getTimeUtil() {
        return timeUtil;
    }

    public void setTimeUtil(java.util.Date timeUtil) {
        this.timeUtil = timeUtil;
    }

    public java.util.Date getTimestampUtil() {
        return timestampUtil;
    }

    public void setTimestampUtil(java.util.Date timestampUtil) {
        this.timestampUtil = timestampUtil;
    }

    public LocalDate getTimeDate() {
        return timeDate;
    }

    public void setTimeDate(LocalDate timeDate) {
        this.timeDate = timeDate;
    }

    public LocalTime getTimeTime() {
        return timeTime;
    }

    public void setTimeTime(LocalTime timeTime) {
        this.timeTime = timeTime;
    }

    public LocalDateTime getTimestampTime() {
        return timestampTime;
    }

    public void setTimestampTime(LocalDateTime timestampTime) {
        this.timestampTime = timestampTime;
    }

    @Override
    public String toString() {
        return "Datas{" + "id=" + id + ", dateUtil=" + dateUtil.toString() + 
                ", timeUtil=" + timeUtil.toString() + ", timestampUtil=" + 
                timestampUtil.toString() + ", dateSQL=" + dateSQL.toString() + 
                ", timeDate=" + timeDate.toString() + ", timeTime=" + 
                timeTime.toString() + ", timestampTime=" + 
                timestampTime.toString() + '}';
    }

}
