// lab3
import java.awt.event.*;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import java.awt.Font;


public  class KeyDemo implements KeyListener{
    String line1 ="";
    JTextArea txtarea;
    public void form(){
        txtarea=new JTextArea();
        txtarea.setText("Press any key on keyboard");
        txtarea.setEnabled(true);
        txtarea.setEditable(false);

        txtarea.setFont(new Font("Arial",Font.BOLD,14));
        JFrame frame=new JFrame("KeyEvent example");
        frame.add(txtarea);
        txtarea.addKeyListener(this);
        
        frame.setSize(300, 300);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
                      
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
        line1 = "KeyTyped: " + e.getKeyChar();
        setLine(e);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        line1 = "KeyPressed: " + e.getKeyChar();
        setLine(e);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        line1 = "KeyReleased: " + e.getKeyChar();
        setLine(e);
    }

    public void setLine(KeyEvent e){
        txtarea.setText(String.format(line1));
    }
    public static void main(String args[]){
        KeyDemo f=new KeyDemo();
        f.form();
    }
}