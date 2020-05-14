package personalassistance;
 
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
 
/**
 *
 * @author Bel Walter
 */
public class Splash extends JFrame {
 
    public Splash() {
        dibujarVentana();}
 
    private void dibujarVentana() {
        this.setSize(800, 600);
        this.setUndecorated(true);
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(Color.white);
        this.getRootPane().setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        JLabel jl = new JLabel(new javax.swing.ImageIcon(getClass().getResource("/image/sede.png")));
        this.add(jl);
        }
}