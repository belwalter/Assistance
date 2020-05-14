package util;
 
import entity.Turnoa;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
 
/**
 *
 * @author Bel Walter
 */
public class TablaModelAdmin extends AbstractTableModel {
 	
    private final String[] columnNames = {"Fecha y Hora", "Tipo", "Cargo/Departamento", "Administrativo"};
    private List<Turnoa> turnos = new ArrayList<Turnoa>(); 
 
    public void agregarTurno(Turnoa turno) {
        turnos.add(turno);
        fireTableDataChanged();
    }
 
    public void eliminarTurno(int rowIndex) {
        turnos.remove(rowIndex);
        fireTableDataChanged();
    }
     
    public void limpiarTurnos() {
        turnos.clear();
        fireTableDataChanged();
    }
    
    public List<Turnoa> getTurnos(){
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
        return 4;
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
                if(turnos.get(rowIndex).getTipo()=='E'){opc="#Entrada";}
                else{opc="&Salida";}
                return opc;}
            case 2:
                return turnos.get(rowIndex).getAdministrativo().getCargo();
            case 3:{
                String opc=null;
                if(turnos.get(rowIndex).getAdministrativo().getPersona().getSexo()=='M'){opc="#";}
                else{opc="&";}
                return opc+turnos.get(rowIndex).getAdministrativo().getPersona().getApellido()+" "+turnos.get(rowIndex).getAdministrativo().getPersona().getNombre();}
            default:
                return null;
        }
    }
 
    @Override
    public Class<String> getColumnClass(int columnIndex) {
        return String.class;
    }
 
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }
 
    @Override
    public void setValueAt(Object value, int rowIndex, int columnIndex) {
        switch (columnIndex) {}
        fireTableCellUpdated(rowIndex, columnIndex);
    }
}