package util;
 
import java.awt.Color;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;
 
/**
 *
 * @author Bel Walter
 */
public class Tabulacion implements TableCellRenderer {
 
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        JLabel etiqueta = new JLabel();
        etiqueta.setOpaque(true);
        if (row % 2 == 0) {
            etiqueta.setBackground(new Color(169, 226, 243));
        } else {
            etiqueta.setBackground(Color.white);
        }
  
            if ((column == 4)||((column==3)&&(table.getColumnCount()<5))) {
                String nombre = (String) value;
                etiqueta.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
                if (nombre.startsWith("#")) { //Hombre
                    etiqueta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/user2.png"))); //
                } else /*if (nombre.startsWith("&"))*/ { //Mujer
                    etiqueta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/user1.png"))); //
                }
                etiqueta.setText(value.toString().substring(1, nombre.length()));}
            
            if ((column == 3)&&(table.getColumnCount()==5)) {
                etiqueta.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
                etiqueta.setText(value.toString());}
            if (column == 2) {
            	if(table.getColumnCount()==5){
                    etiqueta.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                    try{
                        etiqueta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/"+ value.toString()+".png")));}
                    catch(Exception e){}
                    etiqueta.setText(""/*value.toString()*/);
                }
                else{
                    etiqueta.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
                    etiqueta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/admin.png")));
                    etiqueta.setText(value.toString());}
                }
            
            if (column == 1) {
                String nombre = (String) value;
                etiqueta.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                if (nombre.startsWith("#")) { //Entrada
                    etiqueta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/on.png")));} 
                else if (nombre.startsWith("&")) { //Salida
                        etiqueta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/of.png")));}
                etiqueta.setText(/*value.toString().substring(1, nombre.length())*/"");}
            if (column == 0) {
                etiqueta.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
                etiqueta.setText(value.toString());}

        if (isSelected) {
            etiqueta.setBackground(new Color(151, 193, 215));
        }
        return etiqueta;
    }
}