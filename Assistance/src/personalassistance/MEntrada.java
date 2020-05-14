package personalassistance;

import entity.Administrativo;
import entity.Docente;
import entity.Persona;
import entity.Turnoa;
import entity.Turnod;
import entityDAO.AdministrativoDAO;
import entityDAO.DocenteDAO;
import entityDAO.PersonaDAO;
import entityDAO.TurnoaDAO;
import entityDAO.TurnodDAO;
import java.sql.Time;
import java.util.Date;
import java.util.List;

/**
 *
 * @author walter
 */
public class MEntrada extends javax.swing.JDialog {
    
    private Persona p;
    private Docente d;
    private List<Docente> ld;
    private Administrativo a;
    private List<Administrativo> la;
    private Object turno = null; 

    public MEntrada(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }
    
    public void registrarSalida(){
        String tipo = jButton1.getText().equals("Registrar Entrada") ? "E" : "S";
        if(tipo.equals("S")){
            jButton1ActionPerformed(null);}
    }
    
    public MEntrada(java.awt.Frame parent, boolean modal, String dni, int tipo) {
        super(parent, modal);
        initComponents();
        jButton2.setVisible(false);
        p = new PersonaDAO().buscarId(Integer.parseInt(dni));
        if(tipo==3){jButton2.setVisible(true);}
        
        jTextField1.setText(p.getApellido());
        jTextField2.setText(p.getNombre());
        if(p.getSexo()=='M'){
            jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/man.png")));}
        else{
            jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/woman.png")));}
        
        if(tipo==1){
            menuDoc(p);}
        else{
            menuAdmin(p);}
        
    }
    
    public void menuDoc(Persona p){
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/on2.png")));
        jLabel4.setText("Elegir Cátedra");
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/adm.png")));
        jButton2.setText("<html>Cambiar a <br>Administrativo</html>");
        ld = new DocenteDAO().FiltroDNI(p.getDni().toString());
        jComboBox1.removeAllItems();
        int cantt = 0;
        if(ld!=null){
            for(Docente d : ld){
                cantt += new TurnodDAO().CantT(String.valueOf(d.getId()));
                if (cantt % 2 == 0){
                    jComboBox1.addItem(d.getCatedra().getNombre()+" - "+d.getCatedra().getCarrera().getNombre());}
                else{
                    jComboBox1.removeAllItems();
                    jComboBox1.addItem(d.getCatedra().getNombre()+" - "+d.getCatedra().getCarrera().getNombre());
                    jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/off2.png")));
                    jButton1.setText("Registrar Salida");
                    this.d = d;
                    break;
                }
            }
        }
        
    }
    
    public void menuAdmin(Persona p){
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/on2.png")));
        jLabel4.setText("Elegir Cargo");
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/doc.png")));
        jButton2.setText("<html>Cambiar a <br>Docente</html>");
        la = new AdministrativoDAO().FiltroDNI(p.getDni().toString());
        jComboBox1.removeAllItems();
        int cantt = 0;
        if(la!=null){
            for(Administrativo a : la){
                cantt += new TurnoaDAO().CantT(String.valueOf(a.getId()));
                if (cantt % 2 == 0){
                    jComboBox1.addItem(a.getCargo());}
                else{
                    jComboBox1.removeAllItems();
                    jComboBox1.addItem(a.getCargo());
                    jButton1.setText("Registrar Salida");
                    jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/off2.png")));
                    this.a = a;
                    break;
                }
            }
        }
    }
    
    public Object devolverTurno(){
        return turno;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Menú Selección Cátedra/Cargo");
        setMinimumSize(new java.awt.Dimension(800, 350));
        setModal(true);
        setPreferredSize(new java.awt.Dimension(800, 350));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel1.setPreferredSize(new java.awt.Dimension(256, 256));
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jLabel2.setText("Apellido/s");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 17, -1, 30));

        jLabel3.setText("Nombre/s");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 47, -1, 30));

        jTextField1.setEditable(false);
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 20, 290, -1));

        jTextField2.setEditable(false);
        getContentPane().add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 50, 290, -1));

        jLabel4.setText("Elegir Cátedra");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 90, -1, 30));

        jComboBox1.setFont(new java.awt.Font("Ubuntu", 0, 16)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione una Cátedra" }));
        getContentPane().add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 130, 510, 40));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/on2.png"))); // NOI18N
        jButton1.setText("Registrar Entrada");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 260, -1, -1));

        jButton2.setText("cambiar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 259, 180, 60));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        if(jLabel4.getText().equals("Elegir Cargo")){
            menuDoc(p);}
        else{
            menuAdmin(p);}
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        String tipo = jButton1.getText().equals("Registrar Entrada") ? "E" : "S";
        Date date = new Date();
        Time time = new Time(date.getTime());
        if(jLabel4.getText().equals("Elegir Cargo")){
            if(a==null){a=la.get(jComboBox1.getSelectedIndex());}
            Turnoa ta = new Turnoa();
            ta.setTipo(tipo.charAt(0));
            ta.setAdministrativo(a);
            ta.setFecha(date);
            ta.setHora(time);
            new TurnoaDAO().Guardar(ta);
            turno = ta;
        }
        else{
            if(d==null){d=ld.get(jComboBox1.getSelectedIndex());}
            Turnod td = new Turnod();
            td.setTipo(tipo.charAt(0));
            td.setDocente(d);
            td.setFecha(date);
            td.setHora(time);
            new TurnodDAO().Guardar(td);
            turno = td;
        }
        System.out.println("FALTA CONFIRMAR ENTRADA/SALIDA");
        if(turno!=null){
            setVisible(false);}
    }//GEN-LAST:event_jButton1ActionPerformed

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MEntrada.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MEntrada.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MEntrada.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MEntrada.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                MEntrada dialog = new MEntrada(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}
