import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;

public class BorderTest extends JFrame {
    public BorderTest() {
        setTitle("Border Test");

        setSize(500, 300);
        JPanel content = (JPanel) getContentPane();
        content.setLayout(new GridLayout(6, 2));
        JPanel p = new JPanel();
        p.setBorder(new BevelBorder((BevelBorder.RAISED)));

        p.add(new JLabel("RAISED BevelBorder"));
        content.add(p);
        p = new JPanel();
        p.setBorder(new BevelBorder(BevelBorder.LOWERED));
        p.add(new JLabel("LOWERED BevelBorder"));
        content.add(p);
        p = new JPanel();
        p.setBorder(new LineBorder(Color.black, 5));
        p.add(new JLabel("Black LineBorder, thickness = 5"));
        content.add(p);
        p = new JPanel();
        p.setBorder(new EmptyBorder(10, 10, 10, 10));
        p.add(new JLabel("EmptyBorder with thickness of 10"));
        content.add(p);
        p = new JPanel();
        p.setBorder(new EtchedBorder(EtchedBorder.RAISED));
        p.add(new JLabel("RAISED EtchedBorder"));
        content.add(p);
        p = new JPanel();
        p.setBorder(new EtchedBorder(EtchedBorder.LOWERED));
        p.add(new JLabel("LOWERED EtchedBorder"));
        content.add(p);
        p = new JPanel();
        p.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED));
        p.add(new JLabel("RAISED SoftBevelBorder"));
        content.add(p);
        p = new JPanel();
        p.setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED));
        p.add(new JLabel("LOWERED SoftBevelBorder"));
        content.add(p);
        p = new JPanel();
        p.setBorder(new MatteBorder(new ImageIcon("spiral.gif")));
        p.add(new JLabel("MatteBorder"));
        content.add(p);
        p = new JPanel();
        p.setBorder(new TitledBorder(
                new MatteBorder(new ImageIcon("spiral.gif")), "Title String"));
        p.add(new JLabel("TitledBorder using MatteBorder"));
        content.add(p);
        p = new JPanel();
        p.setBorder(new TitledBorder(
                new LineBorder(Color.black, 5), "Title String"));
        p.add(new JLabel("TitledBorder using LineBorder"));
        content.add(p);
        p = new JPanel();
        p.setBorder(new TitledBorder(
                new EmptyBorder(10, 10, 10, 10), "Title String"));
        p.add(new JLabel("TitledBorder using EmptyBorder"));
        content.add(p);
        setVisible(true);
    }

    public static void main(String args[]) {
        new BorderTest();
    }
}