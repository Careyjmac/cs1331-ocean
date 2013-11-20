import javax.swing.JFrame;
import java.awt.BorderLayout;

/**
 * This is the Ocean.  Sets up the JFrame and panels that hold all of the
 * components of the Ocean.
 *
 * @author Doug
 * @version 1.0
 */
public class Ocean {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Ocean");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ControlPanel control = new ControlPanel();
        frame.add(control, BorderLayout.WEST);
        frame.add(new OceanPanel(control)); //defaults to CENTER
        frame.pack();
        frame.setVisible(true);
    }
}
