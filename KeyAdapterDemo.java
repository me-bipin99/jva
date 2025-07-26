import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyAdapterDemo extends KeyAdapter {
    String line1 = "";
    JTextArea txtarea;

    public void form() {
        txtarea = new JTextArea();
        txtarea.setText("Press any key on the keyboard");
        txtarea.setEditable(false);
        JFrame frame = new JFrame("KeyAdapterEvent Example");
        frame.setLayout(new BorderLayout());
        frame.add(txtarea, BorderLayout.CENTER);
        
        txtarea.addKeyListener(this); 

        frame.setSize(300, 300);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        line1 = "KeyPressed: " + e.getKeyChar();
        setLine();
    }

    @Override
    public void keyReleased(KeyEvent e) {
        line1 = "KeyReleased: " + e.getKeyChar();
        setLine();
    }

    public void setLine() {
        txtarea.setText(String.format(line1));
    }

    public static void main(String args[]) {
        new KeyAdapterDemo().form();
    }
}