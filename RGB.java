import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class RGB implements ActionListener{
    JButton btnred,btngreen,btnblue;
    JFrame frame;
    public void eventHandler(){
        btnred=new JButton("Red Color");
        btngreen=new JButton("Green Color");
        btnblue=new JButton("Blue Color");
        
        btnred.setActionCommand("Red");
        btngreen.setActionCommand("Green");
        btnblue.setActionCommand("Blue");
        
        btnred.addActionListener(this);
        btngreen.addActionListener(this);
        btnblue.addActionListener(this);
        
        frame=new JFrame();
        FlowLayout f1=new FlowLayout();
        frame.setLayout(f1);
        
        frame.add(btnred);
        frame.add(btnblue);
        frame.add(btngreen);
        
        frame.setTitle("Button in action");
        frame.setSize(300, 300);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e){
        String str=e.getActionCommand();
        if(str.equals("Red")){
            frame.getContentPane().setBackground(Color.red);
        }else if(str.equals("Blue")){
            frame.getContentPane().setBackground(Color.blue);
        }else if(str.equals("Green")){
            frame.getContentPane().setBackground(Color.green);
        }
    }
    public static void main(String args[]){
        RGB r=new RGB();
        r.eventHandler();
    }
}