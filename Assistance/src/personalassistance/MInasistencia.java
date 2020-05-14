package personalassistance;

import com.mxrck.autocompleter.AutoCompleterCallback;
import com.mxrck.autocompleter.TextAutoCompleter;
import entity.Actividad;
import entity.Inasistencia;
import entity.Persona;
import entity.Recupera;
import entityDAO.ActividadDAO;
import entityDAO.InasistenciaDAO;
import entityDAO.PersonaDAO;
import entityDAO.RecuperaDAO;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

/**
 *
 * @author walter
 */
public class MInasistencia extends javax.swing.JDialog {
    
    private int tipo;
    private String selected = null;
    private List<Integer> dni_carga = new ArrayList<>();//lista de persona que pueden cargar inasistencia
    private TextAutoCompleter textAutoAcompleter;
    private TextAutoCompleter textAutoAcompleterReg;

    public MInasistencia(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        quienes_cargan();
        textAutoAcompleter = new TextAutoCompleter( jTextField1, new AutoCompleterCallback() {
            @Override
            public void callback(Object selectedItem) {
                //String cadena = selectedItem.toString();
            }
        });
        textAutoAcompleter.setMode(0);
        textAutoAcompleter.setCaseSensitive(false);
        textAutoAcompleterReg = new TextAutoCompleter( jTextField2, new AutoCompleterCallback() {
            @Override
            public void callback(Object selectedItem) {
                //String cadena = selectedItem.toString();
            }
        });
        textAutoAcompleterReg.setMode(0);
        textAutoAcompleterReg.setCaseSensitive(false);
        List<Persona> lp = new PersonaDAO().buscarTodo();
        if (lp!=null && lp.size()>0){
            for(Persona p : lp){
                textAutoAcompleter.addItem(p.getApellido()+" "+p.getNombre()+" "+p.getDni());
                if(dni_carga.contains(p.getDni())){
                    textAutoAcompleterReg.addItem(p.getApellido()+" "+p.getNombre()+" "+p.getDni());
                }
            }
        }
    }
    
    public void quienes_cargan(){
        dni_carga.add(11946426);
        dni_carga.add(23275216);
        dni_carga.add(27839917);
        dni_carga.add(11542415);
        dni_carga.add(16843110);
        dni_carga.add(17075929);
        dni_carga.add(22823947);
        dni_carga.add(35115376);
        dni_carga.add(17552066);
        dni_carga.add(28959137);
        dni_carga.add(13599887);
        dni_carga.add(18741660);
        dni_carga.add(21863437);
        dni_carga.add(27021213);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        dateChooserCombo1 = new datechooser.beans.DateChooserCombo();
        dateChooserCombo2 = new datechooser.beans.DateChooserCombo();
        jLayeredPane2 = new javax.swing.JLayeredPane();
        jCheckBox5 = new javax.swing.JCheckBox();
        jLabel5 = new javax.swing.JLabel();
        dateChooserCombo3 = new datechooser.beans.DateChooserCombo();
        jLabel2 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jCheckBox4 = new javax.swing.JCheckBox();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        jLayeredPane3 = new javax.swing.JLayeredPane();
        jLabel8 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        jComboBox4 = new javax.swing.JComboBox();
        jLabel9 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Menú Inasistencia");
        setMinimumSize(new java.awt.Dimension(780, 472));
        setModal(true);
        setPreferredSize(new java.awt.Dimension(780, 472));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel3.setText("Fecha Carga");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, -1, -1));

        jLabel4.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel4.setText("Fecha Falta");
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
    dateChooserCombo1.setLocked(true);
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
getContentPane().add(dateChooserCombo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 90, 250, -1));

jLayeredPane2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Recupera", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 14))); // NOI18N
jLayeredPane2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

jCheckBox5.setText("Recupera");
jCheckBox5.addActionListener(new java.awt.event.ActionListener() {
    public void actionPerformed(java.awt.event.ActionEvent evt) {
        jCheckBox5ActionPerformed(evt);
    }
    });
    jLayeredPane2.add(jCheckBox5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));

    jLabel5.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
    jLabel5.setText("Fecha Estimada a Recupera");
    jLayeredPane2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, -1));

    dateChooserCombo3.setCurrentView(new datechooser.view.appearance.AppearancesList("Swing",
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
dateChooserCombo3.setNothingAllowed(false);
dateChooserCombo3.setWeekStyle(datechooser.view.WeekDaysStyle.SHORT);
dateChooserCombo3.setEnabled(false);
dateChooserCombo3.setBehavior(datechooser.model.multiple.MultyModelBehavior.SELECT_SINGLE);
jLayeredPane2.add(dateChooserCombo3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 250, -1));

jLabel2.setText("Cantidad de Horas");
jLayeredPane2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, -1));

jComboBox3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16" }));
jComboBox3.setEnabled(false);
jLayeredPane2.add(jComboBox3, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 70, 130, -1));

getContentPane().add(jLayeredPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 350, 210));

jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/add.png"))); // NOI18N
jButton1.setText("Cargar Inasistencia");
jButton1.addActionListener(new java.awt.event.ActionListener() {
    public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButton1ActionPerformed(evt);
    }
    });
    getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 390, -1, 50));

    jLabel1.setText("¿Quién falta?");
    getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 50, -1, -1));
    getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 50, 370, -1));

    jCheckBox4.setText("Con Aviso");
    jCheckBox4.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jCheckBox4ActionPerformed(evt);
        }
    });
    getContentPane().add(jCheckBox4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, -1, -1));

    jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Licencia por Enfermedad", "Duelo", "Estudio", "Maternidad", "Nacimiento de Hijo", "Cuidado de Familiar Enfermo", "Mudanza", "Actividad Fuera de Facultad", "Razones Personales", "Otros" }));
    jComboBox1.setEnabled(false);
    jComboBox1.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jComboBox1ActionPerformed(evt);
        }
    });
    getContentPane().add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 130, 260, -1));

    jLabel6.setText("Causa");
    getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 130, -1, 20));

    jLayeredPane3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Actividad Fuera de Facultad", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 14))); // NOI18N
    jLayeredPane3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

    jLabel8.setText("Cantidad de Horas");
    jLayeredPane3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, -1, -1));

    jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Reunión Consejo", "Salida de Campo", "Feria de Carrera", "Mesa de Examen", "Jornada Institucional", "Otros" }));
    jComboBox2.setEnabled(false);
    jComboBox2.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jComboBox2ActionPerformed(evt);
        }
    });
    jLayeredPane3.add(jComboBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 280, -1));

    jLabel7.setText("Actividad");
    jLayeredPane3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, -1, -1));

    jComboBox4.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16" }));
    jComboBox4.setEnabled(false);
    jLayeredPane3.add(jComboBox4, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 120, 130, -1));

    getContentPane().add(jLayeredPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 170, 350, 210));

    jLabel9.setText("¿Quién registra?");
    getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 20, -1, -1));
    getContentPane().add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 20, 370, -1));

    pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        String sdni = "";
        String cdni = "";
        try{
            sdni = textAutoAcompleter.getItemSelected().toString();
            cdni = textAutoAcompleterReg.getItemSelected().toString();
        }catch(Exception e){}
        sdni = sdni.substring(sdni.lastIndexOf(" ")+1);
        cdni = cdni.substring(cdni.lastIndexOf(" ")+1);
        int dni = 0;
        int dnic = 0;
        try{
            dni = Integer.parseInt(sdni);
            dnic = Integer.parseInt(cdni);
        }catch(Exception e){}
        if((dni!=0 && dnic!=0) && (new PersonaDAO().ExisteDni(sdni) && new PersonaDAO().ExisteDni(cdni))){
            Inasistencia ina = new Inasistencia();
            ina.setPersona(new PersonaDAO().buscarId(dni));
            ina.setCarga(new PersonaDAO().buscarId(dnic));
            ina.setAviso(jCheckBox4.isSelected());
            if(jComboBox1.isEnabled()){
                ina.setCausa(jComboBox1.getSelectedItem().toString());}
            else{
                ina.setCausa("Desconosida Sin Aviso");}
            Date f1 = dateChooserCombo1.getSelectedDate().getTime();
            ina.setFechaaviso(f1);
            if (dateChooserCombo1.getSelectedDate().before(dateChooserCombo2.getSelectedDate())){
                Date f2 = dateChooserCombo2.getSelectedDate().getTime();
                ina.setFechafalta(f2);
                if (jCheckBox5.isSelected()){
                    Recupera rec = new Recupera();
                    if (dateChooserCombo2.getSelectedDate().before(dateChooserCombo3.getSelectedDate())){
                        Date f3 = dateChooserCombo3.getSelectedDate().getTime();
                        rec.setFecha(f3);
                        rec.setCanthoras(Integer.parseInt(jComboBox3.getSelectedItem().toString()));
                        ina.setRecupera(rec);
                    }
                    else{
                        JOptionPane.showMessageDialog(this, "La Fecha de Recuperar Clase Debe ser Posterior a la Fecha de Falta!");}
                }
                if (ina.getCausa().equals("Actividad Fuera de Facultad")){
                    Actividad act = new Actividad();
                    act.setDescripcion(jComboBox2.getSelectedItem().toString());
                    act.setCanthoras(Integer.parseInt(jComboBox4.getSelectedItem().toString()));
                    ina.setActividad(act);
                }
                
                new InasistenciaDAO().Guardar(ina);
                if(ina.getRecupera()!=null){
                    new RecuperaDAO().Guardar(ina.getRecupera(), ina.getId());
                }
                if(ina.getActividad()!=null){
                    new ActividadDAO().Guardar(ina.getActividad(), ina.getId());
                }
                JOptionPane.showMessageDialog(this, "Carga Exitosa!");
                this.dispose();
            }
            else{
                JOptionPane.showMessageDialog(this, "La Fecha de Falta Debe ser Posterior o Igual a la Fecha de Aviso!");}
        }else{
            JOptionPane.showMessageDialog(this, "Debe Seleccionar la Persona que Registra y la que Falta!");}
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jCheckBox4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox4ActionPerformed
        // TODO add your handling code here:
        if(jCheckBox4.isSelected()){
            jComboBox1.setEnabled(true);
        }else {jComboBox1.setEnabled(false);}
    }//GEN-LAST:event_jCheckBox4ActionPerformed

    private void jCheckBox5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox5ActionPerformed
        // TODO add your handling code here:
        if(jCheckBox5.isSelected()){
            jComboBox3.setEnabled(true);
            dateChooserCombo3.setEnabled(true);
        }else {
            jComboBox3.setEnabled(false);
            dateChooserCombo3.setEnabled(false);}
    }//GEN-LAST:event_jCheckBox5ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
        String seleccionado = jComboBox1.getSelectedItem().toString();
        if(seleccionado.equals("Actividad Fuera de Facultad")){
            jComboBox4.setEnabled(true);
            jComboBox2.setEnabled(true);
        }else {
            jComboBox4.setEnabled(false);
            jComboBox2.setEnabled(false);
        }
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox2ActionPerformed

    public static void main(String args[]) {
        try {
            javax.swing.UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MInasistencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MInasistencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MInasistencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MInasistencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                MInasistencia dialog = new MInasistencia(new javax.swing.JFrame(), true);
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
    private datechooser.beans.DateChooserCombo dateChooserCombo3;
    private javax.swing.JButton jButton1;
    private javax.swing.JCheckBox jCheckBox4;
    private javax.swing.JCheckBox jCheckBox5;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JComboBox jComboBox3;
    private javax.swing.JComboBox jComboBox4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLayeredPane jLayeredPane2;
    private javax.swing.JLayeredPane jLayeredPane3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}
