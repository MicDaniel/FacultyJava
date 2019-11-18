import javax.swing.*;
import java.awt.*;

public class TestFrameLayoutManager extends JFrame {
    public TestFrameLayoutManager() {
        setTitle("BoxLayout Application");
        JPanel topPanel = new JPanel();
        topPanel.setLayout( new BorderLayout());
        getContentPane().add(topPanel);
        JPanel yAxisPanel = createYAxisPanel();
        topPanel.add(yAxisPanel, BorderLayout.CENTER);
        Box xAxisPanel = createXAxisPanel();
        topPanel.add(xAxisPanel, BorderLayout.NORTH);
    }

    private Box createXAxisPanel() {
        JPanel panel = new JPanel();
        Box boxPanel = new Box(BoxLayout.X_AXIS);
        boxPanel.setBackground(Color.lightGray);
        boxPanel.add( new JButton("Do stuff"));
        boxPanel.add( new JTextArea("Write stuff"));
        boxPanel.add( new JCheckBox("Check stuff"));

        return boxPanel;
    }

    private JPanel createYAxisPanel() {
        JPanel panel = new JPanel();
        panel.setLayout( new BoxLayout(panel, BoxLayout.X_AXIS));
        panel.setBackground(Color.darkGray);
        panel.add( new JButton("Do stuff again"));
        panel.add( new TextArea("Write stuff again"));
        panel.add( new JCheckBox("Check stuff again"));

        return panel;
    }

    public static void main(String[] args) {
        TestFrameLayoutManager mainFrame = new TestFrameLayoutManager();
        mainFrame.pack();
        mainFrame.setVisible(true);
    }
}
