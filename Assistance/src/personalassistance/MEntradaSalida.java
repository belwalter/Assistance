package personalassistance;

import entity.Docente;
import entity.Turnoa;
import entity.Turnod;
import entityDAO.CatedraDAO;
import entityDAO.DocenteDAO;
import entityDAO.TurnoaDAO;
import entityDAO.TurnodDAO;
import java.awt.Color;
import java.awt.Rectangle;
import java.sql.Time;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import util.SalidasOlvidadas;
import util.TablaModelAdmin;
import util.TablaModelDocente;
import util.Tabulacion;

/**
 *
 * @author walter
 */
public class MEntradaSalida extends javax.swing.JFrame {
    
    public TablaModelDocente modelo1 = new TablaModelDocente();
    public  TablaModelAdmin modelo2   = new TablaModelAdmin();
    private final Tabulacion renderizador = new Tabulacion();

    public MEntradaSalida() {
        initComponents();
        getContentPane().setBackground(Color.WHITE);
        jTable1.setModel(modelo1);
        jTable1.setDefaultRenderer(String.class, renderizador);
        jTable2.setModel(modelo2);
        jTable2.setDefaultRenderer(String.class, renderizador);
        List<Turnod> ltd = new TurnodDAO().Filtro();
        List<Turnoa> lta = new TurnoaDAO().Filtro();
        anchoColumnas();
                
        for(Turnod td : ltd){
            modelo1.agregarTurno(td);
            if (modelo1.getRowCount()>5){
                int row =  jTable1.getRowCount () - 1;
                Rectangle rect = jTable1.getCellRect(row, 0, true);
                jTable1.scrollRectToVisible(rect);}}
        for(Turnoa ta : lta){
            modelo2.agregarTurno(ta);
            if (modelo2.getRowCount()>5){
                int row =  jTable2.getRowCount () - 1;
                Rectangle rect = jTable2.getCellRect(row, 0, true);
                jTable2.scrollRectToVisible(rect);}
        }
        jTable1.getTableHeader().setResizingAllowed(false);
        jTable2.getTableHeader().setResizingAllowed(false);
        
        //Para los que se Olvidan
        Timer temporizador = new Timer();
        int tiempoRepeticion = 86400000;
        Calendar c = Calendar.getInstance();
        c.set(Calendar.HOUR_OF_DAY, 23);
        c.set(Calendar.MINUTE, 59);
        c.set(Calendar.SECOND, 0);
        Date horaTarea = c.getTime();
        temporizador.schedule(new SalidasOlvidadas(jTable1, jTable2), horaTarea, tiempoRepeticion);
    }
    
    public void anchoColumnas(){
        jTable1.getColumnModel().getColumn(0).setMaxWidth(130);
        jTable1.getColumnModel().getColumn(0).setPreferredWidth(130);
        jTable1.getColumnModel().getColumn(1).setMaxWidth(40);
        jTable1.getColumnModel().getColumn(1).setPreferredWidth(40);
        jTable1.getColumnModel().getColumn(2).setMaxWidth(60);
        jTable1.getColumnModel().getColumn(2).setPreferredWidth(60);
        jTable1.getColumnModel().getColumn(4).setMaxWidth(215);
        jTable1.getColumnModel().getColumn(4).setPreferredWidth(215);
        
        jTable2.getColumnModel().getColumn(0).setMaxWidth(130);
        jTable2.getColumnModel().getColumn(0).setPreferredWidth(130);
        jTable2.getColumnModel().getColumn(1).setMaxWidth(40);
        jTable2.getColumnModel().getColumn(1).setPreferredWidth(40);
        jTable2.getColumnModel().getColumn(3).setMaxWidth(250);
        jTable2.getColumnModel().getColumn(3).setPreferredWidth(250);
    }
    
    public Turnod obtenerEntrada(Turnod turno){
        Turnod td = null;
        List<Turnod> ltd = modelo1.obtenerLista();
        for(int i=(ltd.size()-1);i>=0;i--){
            if(turno.getDocente().getId()==ltd.get(i).getDocente().getId()){
                td = ltd.get(i);
                break;}}
        if(td == null){
            td = new Turnod(turno.getDocente(), new Time(turno.getHora().getTime()), turno.getFecha(), 'E');
            td.getHora().setHours(td.getHora().getHours()-2);
            }
        return td;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Menú Entrada/Salida de Personal");
        setMinimumSize(new java.awt.Dimension(800, 600));
        setPreferredSize(new java.awt.Dimension(800, 600));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Fecha y Hora", "Tipo", "Carrera", "Cátedra", "Docente"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setRowHeight(36);
        jTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(1).setResizable(false);
            jTable1.getColumnModel().getColumn(2).setResizable(false);
            jTable1.getColumnModel().getColumn(3).setResizable(false);
            jTable1.getColumnModel().getColumn(4).setResizable(false);
        }

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 800, 210));

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Fecha y Hora", "Tipo", "Cargo/Departamento", "Administrativo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable2.setRowHeight(36);
        jTable2.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(jTable2);
        if (jTable2.getColumnModel().getColumnCount() > 0) {
            jTable2.getColumnModel().getColumn(0).setResizable(false);
            jTable2.getColumnModel().getColumn(1).setResizable(false);
            jTable2.getColumnModel().getColumn(2).setResizable(false);
            jTable2.getColumnModel().getColumn(3).setResizable(false);
        }

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 360, 800, 210));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/identity.png"))); // NOI18N
        jButton1.setText("<html>Identifíquese<center>para</center> Entrar/Salir</html>");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 260, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        MIdentificar mi = new MIdentificar(this, true);
        mi.setLocationRelativeTo(null);
        mi.setVisible(true);
        Object t = mi.devolverTurno();
        mi.dispose();
        if(t!=null){
            if(t instanceof Turnod){
                Turnod tds = (Turnod) t;
                if((new CatedraDAO().esCompartida(tds.getDocente().getCatedra().getId()))&&(tds.getTipo()=='S')){
                    Turnod tde = obtenerEntrada(tds);
                    modelo1.agregarTurno(tds);
                    List<Integer> listaidc = new CatedraDAO().listaCompartida(tds.getDocente().getCatedra().getId());
                    for (Integer idcat : listaidc) {
                        Docente d = new DocenteDAO().FiltroDNICatedra(tde.getDocente().getPersona().getDni(), idcat);
                        Turnod td = new Turnod(d, tde.getHora(), tde.getFecha(), tde.getTipo());
                        new TurnodDAO().Guardar(td);
                        modelo1.agregarTurno(td);
                        td = new Turnod(d, tds.getHora(), tds.getFecha(), tds.getTipo());
                        new TurnodDAO().Guardar(td);
                        modelo1.agregarTurno(td);}
                }else{
                    modelo1.agregarTurno(tds);}
                
                if(modelo1.getRowCount()>5){
                    int row =  jTable1.getRowCount() -1;
                    Rectangle rect = jTable1.getCellRect(row, 0, true);
                    jScrollPane1.getViewport().scrollRectToVisible(rect);}
            }
            else{
                if(t instanceof Turnoa){
                    modelo2.agregarTurno((Turnoa) t);
                    if(modelo2.getRowCount()>5){
                        int row =  jTable2.getRowCount() -1;
                        Rectangle rect = jTable2.getCellRect(row, 0, true);
                        jScrollPane2.getViewport().scrollRectToVisible(rect);}
                }
            }
        }
        
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
            java.util.logging.Logger.getLogger(MEntradaSalida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MEntradaSalida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MEntradaSalida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MEntradaSalida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MEntradaSalida().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    // End of variables declaration//GEN-END:variables
}
