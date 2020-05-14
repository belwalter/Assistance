package personalassistance;

import com.mxrck.autocompleter.AutoCompleterCallback;
import com.mxrck.autocompleter.TextAutoCompleter;
import entity.Persona;
import entityDAO.PersonaDAO;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import reporte.ReporteTurno;

/**
 *
 * @author walter
 */
public class MReporte extends javax.swing.JDialog {
    
    private int tipo;
    private String selected = null;
    private TextAutoCompleter textAutoAcompleter;

    public MReporte(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        Deshabilitar();
        //dateChooserCombo1.setCalendarPreferredSize(new Dimension(350, 200));
        //dateChooserCombo2.setCalendarPreferredSize(new Dimension(350, 200));
        textAutoAcompleter = new TextAutoCompleter( jTextField1, new AutoCompleterCallback() {
            @Override
            public void callback(Object selectedItem) {
                //String cadena = selectedItem.toString();
                Habilitar();
                
            }
        });
        textAutoAcompleter.setMode(0);
        textAutoAcompleter.setCaseSensitive(false);
        List<Persona> lp = new PersonaDAO().buscarTodo();
        if (lp!=null && lp.size()>0){
            for(Persona p : lp){
                textAutoAcompleter.addItem(p.getApellido()+" "+p.getNombre()+" "+p.getDni());
            }
        }
    }
    
    public void Deshabilitar(){
        jRadioButton3.setEnabled(false);
        jRadioButton4.setEnabled(false);
        jCheckBox1.setEnabled(false);jCheckBox1.setSelected(false);
        jCheckBox2.setEnabled(false);jCheckBox2.setSelected(false);
        jCheckBox3.setEnabled(false);jCheckBox3.setSelected(false);
    }

    public void Habilitar(){
        jRadioButton3.setEnabled(true);
        jRadioButton4.setEnabled(true);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        dateChooserCombo1 = new datechooser.beans.DateChooserCombo();
        dateChooserCombo2 = new datechooser.beans.DateChooserCombo();
        jLayeredPane2 = new javax.swing.JLayeredPane();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        jCheckBox1 = new javax.swing.JCheckBox();
        jCheckBox2 = new javax.swing.JCheckBox();
        jCheckBox3 = new javax.swing.JCheckBox();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Menú Reportes");
        setMaximumSize(new java.awt.Dimension(780, 400));
        setMinimumSize(new java.awt.Dimension(780, 400));
        setPreferredSize(new java.awt.Dimension(780, 400));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel3.setText("Desde");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 90, -1, -1));

        jLabel4.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel4.setText("Hasta");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 90, -1, -1));

        dateChooserCombo1.setCurrentView(new datechooser.view.appearance.AppearancesList("Swing",
            new datechooser.view.appearance.ViewAppearance("custom",
                new datechooser.view.appearance.swing.SwingCellAppearance(new java.awt.Font("Ubuntu", java.awt.Font.PLAIN, 15),
                    new java.awt.Color(85, 85, 85),
                    new java.awt.Color(0, 0, 255),
                    false,
                    true,
                    new datechooser.view.appearance.swing.ButtonPainter()),
                new datechooser.view.appearance.swing.SwingCellAppearance(new java.awt.Font("Ubuntu", java.awt.Font.PLAIN, 15),
                    new java.awt.Color(85, 85, 85),
                    new java.awt.Color(0, 0, 255),
                    true,
                    true,
                    new datechooser.view.appearance.swing.ButtonPainter()),
                new datechooser.view.appearance.swing.SwingCellAppearance(new java.awt.Font("Ubuntu", java.awt.Font.PLAIN, 15),
                    new java.awt.Color(0, 0, 255),
                    new java.awt.Color(0, 0, 255),
                    false,
                    true,
                    new datechooser.view.appearance.swing.ButtonPainter()),
                new datechooser.view.appearance.swing.SwingCellAppearance(new java.awt.Font("Ubuntu", java.awt.Font.PLAIN, 15),
                    new java.awt.Color(128, 128, 128),
                    new java.awt.Color(0, 0, 255),
                    false,
                    true,
                    new datechooser.view.appearance.swing.LabelPainter()),
                new datechooser.view.appearance.swing.SwingCellAppearance(new java.awt.Font("Ubuntu", java.awt.Font.PLAIN, 15),
                    new java.awt.Color(85, 85, 85),
                    new java.awt.Color(0, 0, 255),
                    false,
                    true,
                    new datechooser.view.appearance.swing.LabelPainter()),
                new datechooser.view.appearance.swing.SwingCellAppearance(new java.awt.Font("Ubuntu", java.awt.Font.PLAIN, 15),
                    new java.awt.Color(85, 85, 85),
                    new java.awt.Color(255, 0, 0),
                    false,
                    false,
                    new datechooser.view.appearance.swing.ButtonPainter()),
                (datechooser.view.BackRenderer)null,
                false,
                true)));
    dateChooserCombo1.setNothingAllowed(false);
    dateChooserCombo1.setWeekStyle(datechooser.view.WeekDaysStyle.SHORT);
    dateChooserCombo1.setBehavior(datechooser.model.multiple.MultyModelBehavior.SELECT_SINGLE);
    getContentPane().add(dateChooserCombo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 90, 250, -1));

    dateChooserCombo2.setCurrentView(new datechooser.view.appearance.AppearancesList("Swing",
        new datechooser.view.appearance.ViewAppearance("custom",
            new datechooser.view.appearance.swing.SwingCellAppearance(new java.awt.Font("Ubuntu", java.awt.Font.PLAIN, 15),
                new java.awt.Color(85, 85, 85),
                new java.awt.Color(0, 0, 255),
                false,
                true,
                new datechooser.view.appearance.swing.ButtonPainter()),
            new datechooser.view.appearance.swing.SwingCellAppearance(new java.awt.Font("Ubuntu", java.awt.Font.PLAIN, 15),
                new java.awt.Color(85, 85, 85),
                new java.awt.Color(0, 0, 255),
                true,
                true,
                new datechooser.view.appearance.swing.ButtonPainter()),
            new datechooser.view.appearance.swing.SwingCellAppearance(new java.awt.Font("Ubuntu", java.awt.Font.PLAIN, 15),
                new java.awt.Color(0, 0, 255),
                new java.awt.Color(0, 0, 255),
                false,
                true,
                new datechooser.view.appearance.swing.ButtonPainter()),
            new datechooser.view.appearance.swing.SwingCellAppearance(new java.awt.Font("Ubuntu", java.awt.Font.PLAIN, 15),
                new java.awt.Color(128, 128, 128),
                new java.awt.Color(0, 0, 255),
                false,
                true,
                new datechooser.view.appearance.swing.LabelPainter()),
            new datechooser.view.appearance.swing.SwingCellAppearance(new java.awt.Font("Ubuntu", java.awt.Font.PLAIN, 15),
                new java.awt.Color(85, 85, 85),
                new java.awt.Color(0, 0, 255),
                false,
                true,
                new datechooser.view.appearance.swing.LabelPainter()),
            new datechooser.view.appearance.swing.SwingCellAppearance(new java.awt.Font("Ubuntu", java.awt.Font.PLAIN, 15),
                new java.awt.Color(85, 85, 85),
                new java.awt.Color(255, 0, 0),
                false,
                false,
                new datechooser.view.appearance.swing.ButtonPainter()),
            (datechooser.view.BackRenderer)null,
            false,
            true)));
dateChooserCombo2.setNothingAllowed(false);
dateChooserCombo2.setWeekStyle(datechooser.view.WeekDaysStyle.SHORT);
dateChooserCombo2.setBehavior(datechooser.model.multiple.MultyModelBehavior.SELECT_SINGLE);
getContentPane().add(dateChooserCombo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 90, 250, -1));

jLayeredPane2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Filtro", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 14))); // NOI18N
jLayeredPane2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

jRadioButton3.setText("Único (agrupado)");
jRadioButton3.setEnabled(false);
jRadioButton3.addActionListener(new java.awt.event.ActionListener() {
    public void actionPerformed(java.awt.event.ActionEvent evt) {
        jRadioButton3ActionPerformed(evt);
    }
    });
    jLayeredPane2.add(jRadioButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, -1, -1));

    jRadioButton4.setSelected(true);
    jRadioButton4.setText("Individual (separado docente y administrativo)");
    jRadioButton4.setEnabled(false);
    jRadioButton4.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jRadioButton4ActionPerformed(evt);
        }
    });
    jLayeredPane2.add(jRadioButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 30, -1, -1));

    jCheckBox1.setText("por cargo");
    jLayeredPane2.add(jCheckBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 60, -1, -1));

    jCheckBox2.setText("por carrera");
    jCheckBox2.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jCheckBox2ActionPerformed(evt);
        }
    });
    jLayeredPane2.add(jCheckBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 95, -1, -1));

    jCheckBox3.setText("por cátedra");
    jCheckBox3.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jCheckBox3ActionPerformed(evt);
        }
    });
    jLayeredPane2.add(jCheckBox3, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 120, -1, -1));

    getContentPane().add(jLayeredPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 130, 660, 170));

    jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/informe.png"))); // NOI18N
    jButton1.setText("Generar Reporte");
    jButton1.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton1ActionPerformed(evt);
        }
    });
    getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 310, -1, -1));

    jLabel1.setText("Buscar Persona");
    getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 30, -1, -1));
    getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 30, 370, -1));

    pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jRadioButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton3ActionPerformed
        // TODO add your handling code here:
        jRadioButton3.setSelected(true);
        jRadioButton4.setSelected(false);
        jCheckBox1.setEnabled(false);jCheckBox1.setSelected(false);
        jCheckBox2.setEnabled(false);jCheckBox2.setSelected(false);
        jCheckBox3.setEnabled(false);jCheckBox3.setSelected(false);
    }//GEN-LAST:event_jRadioButton3ActionPerformed

    private void jRadioButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton4ActionPerformed
        // TODO add your handling code here:
        jRadioButton4.setSelected(true);
        jRadioButton3.setSelected(false);
        jCheckBox1.setEnabled(true);
        jCheckBox2.setEnabled(true);
        jCheckBox3.setEnabled(true);
    }//GEN-LAST:event_jRadioButton4ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if(true /*jRadioButton3.isSelected() || jRadioButton4.isSelected()*/){
	    if (jRadioButton3.isSelected()){tipo=1;}else{tipo=2;}
            if (dateChooserCombo1.getSelectedDate().before(dateChooserCombo2.getSelectedDate())){
                boolean opc1 = jCheckBox1.isSelected(); 
                boolean opc2 = jCheckBox2.isSelected();
                boolean opc3 = jCheckBox3.isSelected();
                String sdni = "";
                try{
                    sdni = textAutoAcompleter.getItemSelected().toString();
                }catch(Exception e){}
                sdni = sdni.substring(sdni.lastIndexOf(" ")+1);
                int dni = 0;
                try{
                    dni = Integer.parseInt(sdni);
                }catch(Exception e){}
                if(dni!=0 && new PersonaDAO().ExisteDni(sdni)){
                    Date f1 = dateChooserCombo1.getSelectedDate().getTime();
                    Date f2 = dateChooserCombo2.getSelectedDate().getTime();
                    ReporteTurno rc = new ReporteTurno(tipo,opc1,opc2,opc3,dni,f1,f2);
                    rc.generarReporte();
                }else{
                    JOptionPane.showMessageDialog(this, "Debe Seleccionar una Persona para Hacer el Informe");}
            }else{JOptionPane.showMessageDialog(this, "La Fecha Desde debe ser Mayor o Igual a la Fecha Hasta!");}
        }else{JOptionPane.showMessageDialog(this, "Debe Seleccionar el Tipo de Informe Único o Individual!");}
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jCheckBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox2ActionPerformed
        // TODO add your handling code here:
        jCheckBox2.setSelected(true);
        jCheckBox3.setSelected(false);
    }//GEN-LAST:event_jCheckBox2ActionPerformed

    private void jCheckBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox3ActionPerformed
        // TODO add your handling code here:
        jCheckBox3.setSelected(true);
        jCheckBox2.setSelected(false);
    }//GEN-LAST:event_jCheckBox3ActionPerformed

    public static void main(String args[]) {
        try {
            javax.swing.UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MReporte.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MReporte.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MReporte.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MReporte.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                MReporte dialog = new MReporte(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private datechooser.beans.DateChooserCombo dateChooserCombo1;
    private datechooser.beans.DateChooserCombo dateChooserCombo2;
    private javax.swing.JButton jButton1;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLayeredPane jLayeredPane2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
