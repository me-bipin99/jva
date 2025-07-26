import java.awt.event.*;
import java.awt.Color;
import javax.swing.*;
public class ShowColor implements ActionListener {
    JButton btn;
    Color color;
    JPanel panel;
    JFrame frame;
    
    public void showColor(){
        panel=new JPanel();
        panel.setBackground(color);
        
        btn =new JButton("Change Color");
        btn.addActionListener(this);
        
        panel.add(btn);
        frame=new JFrame("Color form...");
        frame.getContentPane().add(panel);
        frame.setSize(400,400);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    @Override
    public void actionPerformed(ActionEvent e)
    {
        color=JColorChooser.showDialog(frame,"Choose a color",color);
        if(color==null)
            color=Color.LIGHT_GRAY;
        panel.setBackground(color);
    }
    public static void main(String [] args)
    {
        ShowColor show =new ShowColor();
        show.showColor();
    }
}