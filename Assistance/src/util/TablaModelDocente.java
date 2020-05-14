package util;
 
import entity.Turnod;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
 
/**
 *
 * @author Bel Walter
 */
public class TablaModelDocente extends AbstractTableModel {
 
    private final String[] columnNames = {"Fecha y Hora", "Tipo", "Carrera", "Cátedra", "Docente"};
    private List<Turnod> turnos = new ArrayList<Turnod>(); 
 
    public void agregarTurno(Turnod turno) {
        turnos.add(turno);
        fireTableDataChanged();
    }
    
    public List<Turnod> obtenerLista(){
        return turnos;
    }
 
    public void eliminarTurno(int rowIndex) {
        turnos.remove(rowIndex);
        fireTableDataChanged();
    }
     
    public void limpiarTurnos() {
        turnos.clear();
        fireTableDataChanged();
    }
    
    public List<Turnod> getTurnos(){
        return turnos;
    }
 
    @Override
    public String getColumnName(int columnIndex) {
        return columnNames[columnIndex];
    }
 
    @Override
    public int getRowCount() {
        return turnos.size();
    }
 
    @Override
    public int getColumnCount() {
        return 5;
    }
 
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:{
                String fecha = new SimpleDateFormat("dd-MM-yy").format(turnos.get(rowIndex).getFecha());
                String hora = new SimpleDateFormat("HH:mm:ss").format(turnos.get(rowIndex).getHora());
                return fecha+" - "+hora;}
            case 1:{
                String opc=null;
                if(turnos.get(rowIndex).getTipo()=='E'){opc="#E";}
                else{opc="&S";}
                return opc;}
            case 2:String nombre = String.valueOf(turnos.get(rowIndex).getDocente().getCatedra().getCarrera().getId());
                 return nombre;
            case 3:
                return turnos.get(rowIndex).getDocente().getCatedra().getNombre();
            case 4:{
                String opc=null;
                if(turnos.get(rowIndex).getDocente().getPersona().getSexo()=='M'){opc="#";}
                else{opc="&";}
                return opc+turnos.get(rowIndex).getDocente().getPersona().getApellido()+" "+turnos.get(rowIndex).getDocente().getPersona().getNombre();}
            default:
                return null;
        }
    }
 
    @Override
    public Class<String> getColumnClass(int columnIndex) {
//        return getValueAt(0, columnIndex).getClass();
        return String.class;
    }
 
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }
 
    @Override
    public void setValueAt(Object value, int rowIndex, int columnIndex) {
        //Turno turno = turnos.get(rowIndex);
        switch (columnIndex) {}
        fireTableCellUpdated(rowIndex, columnIndex);
    }
}