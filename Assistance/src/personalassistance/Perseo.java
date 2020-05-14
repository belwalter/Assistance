package personalassistance;

import javax.swing.UIManager;

/**
 *
 * @author Bel Walter
 */
public class Perseo {

    public static void main(String[] args) {
        
            try {
                javax.swing.UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
                java.util.logging.Logger.getLogger(MPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
        
            Runnable ejecutable = new Runnable() {
                @Override
            public void run() {
                Splash s = new Splash();
                s.setVisible(true);
                try {Thread.sleep(1000);} 
                catch (Exception e) {}
                s.dispose();
                MPrincipal mp = new MPrincipal();
                mp.setVisible(true);
                mp.setLocationRelativeTo(null);}
            };
            Thread tarea = new Thread(ejecutable);
            tarea.start();        
}
}