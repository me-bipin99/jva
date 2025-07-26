import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import javax.swing.JFrame;

public class Shapes extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g); 
    }

    public void draw(Graphics g) {
        g.setColor(Color.RED);
        g.drawLine(5, 30, 380, 30);

        g.setColor(Color.BLUE);
        g.drawRect(5, 40, 60, 55);

        g.setColor(Color.GREEN);
        g.drawOval(120, 50, 90, 55);
        g.fillOval(280, 40, 70, 55);

        g.setColor(Color.CYAN);
        g.fillOval(5, 100, 90, 90);
    }
    public static void main(String[] args) {
        JFrame frame = new JFrame("Drawing Shapes");
        Shapes panel = new Shapes();
        frame.add(panel);
        frame.setSize(400, 250);  // Width x Height
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
