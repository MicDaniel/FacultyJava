import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class FirstJFrameAPP extends JFrame {
    public FirstJFrameAPP() {
        setTitle("Test Application");
        setSize(250, 250);
        setBackground(Color.lightGray);

        Panel topPanel = new Panel();
        topPanel.setLayout( new BorderLayout() );
        getContentPane().add( topPanel );
        Label labelHello = new Label( "Hello Wolrd!" );
        topPanel.add(labelHello, BorderLayout.NORTH);
    }

    public static void main (String[] args) {
        FirstJFrameAPP mainFrame = new FirstJFrameAPP();
        mainFrame.setVisible(true);
    }
}
