import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

public class HwSwingAPP extends JFrame  {
    JPanel panel = new JPanel();

    ImageIcon greenEyedCat = new ImageIcon("myimage.jpeg");
    ImageIcon typingCat = new ImageIcon("catimage.jfif");

    public HwSwingAPP() {
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        getContentPane().add(panel);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("I have no idea");
        setSize(500, 500);
        setBackground(Color.lightGray);

        JLabel label = new JLabel("This is the Label Text", greenEyedCat,SwingConstants.CENTER );
        label.setHorizontalTextPosition(JLabel.CENTER);
        label.setVerticalTextPosition(JLabel.BOTTOM);
        panel.add(label);

        typingCat = scaleImage(typingCat, greenEyedCat.getIconWidth(), greenEyedCat.getIconHeight());
        JButton changeImage = new JButton("Change!");
        changeImage.setMnemonic('P');
        changeImage.addActionListener(e -> {
            if(label.getIcon() == greenEyedCat) {
                label.setIcon(typingCat);
            }
            else {
                label.setIcon(greenEyedCat);
            }
        });
        panel.add(changeImage,SwingConstants.CENTER);

        ButtonGroup radioGroup = new ButtonGroup();

        JRadioButton radio1 = new JRadioButton("Radio button 1");
        radio1.setActionCommand("Radio button 1");
        radioGroup.add(radio1);

        JRadioButton radio2 = new JRadioButton("Radio button 2");
        radio2.setActionCommand("Radio button 2");
        radioGroup.add(radio2);

        radio1.addActionListener(e -> {
            label.setText(e.getActionCommand());
        });
        radio2.addActionListener(e -> {
            label.setText(e.getActionCommand());
        });

        JPanel radioPanel = new JPanel();
        radioPanel.setLayout(new BoxLayout(radioPanel,BoxLayout.Y_AXIS));
        radioPanel.setPreferredSize(new Dimension(100,25));
        radioPanel.setBorder(new TitledBorder(new EtchedBorder(),
                "Radio buttons"
        ));
        radioPanel.add(radio1);
        radioPanel.add(radio2);
        panel.add(radioPanel);
    }

    public static void main(String[] args){
        HwSwingAPP mainFrame = new HwSwingAPP();
        mainFrame.setVisible(true);

    }

    private ImageIcon scaleImage(ImageIcon img, int w, int h) {
        Image resizedImage = img.getImage();
        resizedImage = resizedImage.getScaledInstance(w,h,Image.SCALE_SMOOTH);
        return new ImageIcon(resizedImage);
    }
}
