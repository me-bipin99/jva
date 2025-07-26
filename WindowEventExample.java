import javax.swing.JFrame;
import java.awt.event.*;
import javax.swing.JOptionPane;


public class WindowEventExample extends WindowAdapter{
    JFrame frame;
    public WindowEventExample(){
        frame=new JFrame("Window event");
        frame.addWindowListener(this);
        frame.setSize(300,300);
        frame.setLocationRelativeTo(frame);
        frame.setVisible(true);
    }
    public static void main(String args[]){
        new WindowEventExample();
    }
    @Override
    public void windowIconified(WindowEvent e){
        JOptionPane.showMessageDialog(null,"Window Iconified");
    }
    @Override
    public void windowDeiconified(WindowEvent e){
        JOptionPane.showMessageDialog(null,"Window Deiconified");
    }
    @Override
    public void windowClosing(WindowEvent e){
        JOptionPane.showMessageDialog(null,"Window closing");
    }
    @Override
    public void windowOpened(WindowEvent e){
        JOptionPane.showMessageDialog(null,"Window Opened");
    }
}