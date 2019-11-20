import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

class TestLabel extends JFrame
{
    public TestLabel()
    {
        setTitle( "JLabel Application" );
        setSize( 300, 200 );
        setBackground( Color.gray );
        JPanel topPanel = new JPanel();
        topPanel.setLayout( new GridLayout( 2, 2 ) );
        getContentPane().add( topPanel );

        JLabel label1 = new JLabel();
        label1.setBackground(Color.red);
        label1.setOpaque(true);
        label1.setText( "Label1" );
        label1.setForeground( Color.yellow );
        topPanel.add( label1 );

        JLabel label2 = new JLabel( "Label2" );
        label2.setBackground(Color.blue);
        label2.setOpaque(true);
        label2.setFont( new Font( "Helvetica", Font.BOLD, 18 ) );
        topPanel.add( label2 );

        Icon image = new ImageIcon( "myimage.jpeg" );
        JLabel label3 = new JLabel( "Enabled", image,SwingConstants.CENTER );
        label3.setMinimumSize( new Dimension(image.getIconWidth(), image.getIconHeight()));
        label3.setPreferredSize( new Dimension(image.getIconWidth() + 5, image.getIconHeight()+ 5));
        label3.setMaximumSize( new Dimension(image.getIconWidth() + 25, image.getIconHeight() + 25));
        label3.setBackground(Color.green);
        label3.setOpaque(true);
        label3.setVerticalTextPosition( SwingConstants.TOP );
        topPanel.add( label3 );

        JLabel label4 = new JLabel( "Label4",SwingConstants.RIGHT );
        label4.setOpaque(true);
        label4.setBackground(Color.darkGray);
        topPanel.add( label4 );
        JLabel label5 = new JLabel( new ImageIcon("https://media.giphy.com/media/jRlP4zbERYW5HoCLvX/200w_d.gif"));
        topPanel.add(label5);
    }
    public static void main( String args[] )
    {
        TestLabel mainFrame = new TestLabel();
        mainFrame.setVisible( true );
    }

    static class TestJButImg extends JFrame implements ActionListener
    {
        private int iCounter = 0;
        private JButton button = null;
        public TestJButImg()
        {
            setTitle( "Animated Button Application" );
            setBackground( Color.gray );
            JPanel topPanel = new JPanel();
            topPanel.setLayout( new FlowLayout() );
            getContentPane().add( topPanel );
            ImageIcon image = new ImageIcon( "catimage.jfif" );
            button = new JButton( "Press Me", image );
            button.setPreferredSize( new Dimension( 550, 500 ) );
            ImageIcon image1 = new ImageIcon( "myimage.jpeg" );
            button.setPressedIcon(image1);
            button.setMnemonic( 'P' );
            topPanel.add( button );
            button.addActionListener( this );
            JButton but1=new JButton(" OK ");
            but1.setEnabled( false );
            topPanel.add(but1);
            JButton but2=new JButton(" OK ");
            but2.setEnabled( true );
            topPanel.add(but2);
        }
        public void actionPerformed( ActionEvent event )
        {
            if( event.getSource() == button )
            {
                iCounter++;
                button.setText( "Pressed " + iCounter + " times" );
                pack();
            }
        }
        public static void main( String args[] )
        {
            TestJButImg mainFrame = new TestJButImg();
            mainFrame.pack();
            mainFrame.setVisible( true );
        }
    }
}