import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * This is the ControlPanel for the Ocean. It allows the
 * user to pick which Fish it would like to add next.
 *
 * @author Doug, Carey MacDonald
 * @version 1.1
 */
public class ControlPanel extends JPanel {
    private JButton surgeonfish, parrotfish, shark, giantSquid, magikarp,
    gyarados;
    private JLabel current;

    private String fishType;

    /**
     *  Constructor for ControlPanel.  Sets up the panel and buttons that
     *  allows the user to pick which type of Fish they would like to add next.
     */
    public ControlPanel() {
        setPreferredSize(new Dimension(150, OceanPanel.HEIGHT));

        surgeonfish = new JButton("SurgeonFish");
        surgeonfish.addActionListener(new ButtonListener("SurgeonFish"));
        // ***Make sure that the String you pass into ButtonListener matches the
        // exact class name of the object.
        add(surgeonfish);

        parrotfish = new JButton("ParrotFish");
        parrotfish.addActionListener(new ButtonListener("ParrotFish"));
        add(parrotfish);

        shark = new JButton("Shark");
        shark.addActionListener(new ButtonListener("Shark"));
        add(shark);

        giantSquid = new JButton("GiantSquid");
        giantSquid.addActionListener(new ButtonListener("GiantSquid"));
        add(giantSquid);

        magikarp = new JButton("Magikarp");
        magikarp.addActionListener(new ButtonListener("Magikarp"));
        add(magikarp);

        gyarados = new JButton("Gyarados");
        gyarados.addActionListener(new ButtonListener("Gyarados"));
        add(gyarados);

        //default starting fish
        fishType = "SurgeonFish";
        add(new JLabel("Current Fish"));
        current = new JLabel("SurgeonFish");
        add(current);

        //implement timer speed control if you feel adventurous
    }

    /**
     * Invoked by OceanPanel to determine which Fish
     * was chosen.
     *
     * @return The currently selected Fish type
     */
    public String getFishType() {
        return fishType;
    }

    private class ButtonListener implements ActionListener {
        private String name;

        public ButtonListener(String className) {
            name = className;
        }

        public void actionPerformed(ActionEvent e) {
            fishType = name;
            current.setText(name);
        }
    }
}