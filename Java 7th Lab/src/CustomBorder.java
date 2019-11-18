import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class CustomBorder implements Border {
    protected int w=6;
    protected int h=6;
    protected Color topColor = Color.white;
    protected Color bottomColor = Color.gray;

    public CustomBorder() {
        this.w = 6;
        this.w = 6;
    }

    public CustomBorder(int w, int h) {
        this.w = w;
        this.h = h;
    }

    public CustomBorder(int w, int h, Color topColor, Color bottomColor) {
        this.w=w;
        this.h=h;
        this.topColor = topColor;
        this.bottomColor = bottomColor;
    }

    public Insets getBorderInsets(Component c) {
        return new Insets(this.h, this.w, this.h, this.w);
    }
    public boolean isBorderOpaque() { return true; }
    public void paintBorder(Component c, Graphics g,
                            int x, int y, int w, int h) {
        w--;
        h--;
        g.setColor(this.topColor);
        g.drawLine(x, y+h-this.h, x, y+this.h);
        g.drawArc(x, y, 2*this.w, 2*this.h, 180, -90);
        g.drawLine(x+this.w, y, x+w-this.w, y);
        g.drawArc(x+w-2*this.w, y, 2*this.w, 2*this.h, 90, -90);
        g.setColor(this.bottomColor);
        g.drawLine(x+w, y+this.h, x+w, y+h-this.h);
        g.drawArc(x+w-2*this.w, y+h-2*this.h, 2*this.w, 2*this.h, 0, -90);
        g.drawLine(x+this.w, y+h, x+w-this.w, y+h);
        g.drawArc(x, y+h-2*this.h, 2*this.w, 2*this.h, -90, -90);
    }
    public static void main(String[] args) {
        JFrame frame = new JFrame("Custom Border: OvalBorder");
        JLabel label = new JLabel("OvalBorder");
        ((JPanel) frame.getContentPane()).setBorder(new CompoundBorder(
                new EmptyBorder(10,10,10,10), new CustomBorder(10,10)));
        frame.getContentPane().add(label);
        frame.setBounds(0,0,300,150);
        frame.setVisible(true);
    }
}
