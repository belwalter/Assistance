package util;

/**
 *
 * @author walter
 */

import entity.Turnoa;
import entity.Turnod;
import java.util.ArrayList;
import java.util.List;
import java.util.TimerTask;
import javax.swing.JTable;
import personalassistance.MIdentificar;

public class SalidasOlvidadas extends TimerTask{

    private List<Integer> dnis = new ArrayList<>();
    private JTable jTable1;
    private JTable jTable2;
    
    public SalidasOlvidadas(JTable jTable1 , JTable jTable2){
        this.jTable1 = jTable1;
        this.jTable2 = jTable2;
    }
    
    @Override
    public void run() {
        for(Turnod t : ((TablaModelDocente) jTable1.getModel()).getTurnos()){
            Integer dni = t.getDocente().getPersona().getDni();
            if (!dnis.contains(dni)){
                    dnis.add(dni);}
        }
        for(Turnoa t : ((TablaModelAdmin) jTable2.getModel()).getTurnos()){
            Integer dni = t.getAdministrativo().getPersona().getDni();
            if((dni!=14128245)&&(dni!=26612017)){//excepcion serenos
                if (!dnis.contains(dni)){
                        dnis.add(dni);}
            }
        }
        
        
        for(Integer dni : dnis){
            MIdentificar mi = new MIdentificar(null, true, dni);
            Object t = mi.devolverTurno();
            mi.dispose();
            /*if(t instanceof Turnod){
                Turnod tds = (Turnod) t;
                System.out.println(tds.getDocente().getCatedra().getNombre());
            }
            if(t instanceof Turnoa){
                Turnoa tda = (Turnoa) t;
                System.out.println(tda.getAdministrativo().getCargo());
            }*/
        }
        //limpiar tablas
        TablaModelDocente tmd = (TablaModelDocente) jTable1.getModel();
        tmd.limpiarTurnos();
        TablaModelAdmin  tma =  (TablaModelAdmin) jTable2.getModel();
        tma.limpiarTurnos();
    }
	

}
