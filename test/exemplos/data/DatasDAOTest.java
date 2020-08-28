package exemplos.data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.GregorianCalendar;
import org.junit.Test;


public class DatasDAOTest {
    
    public DatasDAOTest() {
    }

    @Test
    public void testSave() {
        
        Datas data = new Datas();
        
        //java.sql.Date;
        data.setDateSQL(new java.sql.Date(System.currentTimeMillis()));
        
        //java.util.Date;
        data.setDateUtil(new java.util.Date(new GregorianCalendar().getTimeInMillis()));
        
        data.setTimeUtil(new java.util.Date(System.currentTimeMillis()));
        
        //Exemplo onde a data pode ser editada;
        GregorianCalendar gc = new GregorianCalendar();
        gc.set(2000, 0, 2, 2, 2, 2);
        //ano, mes, dia, horas, min, seg;
        data.setTimestampUtil(new java.util.Date(gc.getTimeInMillis()));
        
        //java.time
        data.setTimeDate(LocalDate.now());
        
        data.setTimestampTime(LocalDateTime.now());
        
        data.setTimeTime(LocalTime.now(ZoneId.of("UTC+9")));//horario do japão;
        
        data = DatasDAO.save(data);
        
        try{
            System.out.println(data.toString());
        }catch(NullPointerException npex){
            System.err.println("////erro: " + npex);
        }
          
    }
    
}
