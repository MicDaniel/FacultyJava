import javax.swing.*;
import java.awt.*;

public class TestPanel extends JFrame {
    public TestPanel() {
        setTitle("Test Panel");
        setSize(250,250);
        setBackground(Color.red);
        JPanel topPanel = new JPanel(true);
        topPanel.setLayout( new GridLayout(3, 2));
        getContentPane().add(topPanel);
        topPanel.setBackground(Color.darkGray);
        topPanel.add(new Button("One"));
        topPanel.add(new Button("Two"));
        topPanel.add(new Button("Three"));
        topPanel.add(new Button("Four"));
        topPanel.add(new Button("Five"));

    }

    public static void main(String[] args) {
        TestPanel testPanel = new TestPanel();
        testPanel.setVisible(true);
    }
}
