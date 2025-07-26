import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.io.*;
import javax.swing.border.*;
import java.awt.Font;
public class chatform implements ActionListener {
    JLabel label;
    JTextField text;
    JButton send,reset;
    JTextArea ta;
    JMenuItem m11,m12,m13;
    JFrame frame;
    File file;
    public void createform(){
        JMenuBar mb=new JMenuBar();
        JMenu m1=new JMenu("File");
        JMenu m2=new JMenu("View");
        JMenu m3=new JMenu("Settings");
        JMenu m4=new JMenu("Help");
        
        m11=new JMenuItem("Open");
        m11.addActionListener(this);
        m12=new JMenuItem("Save as");
        m12.addActionListener(this);
        m13=new JMenuItem("Close");
        m13.addActionListener(this);
        
        JMenuItem m21=new JMenuItem("Standard View");
        JMenuItem m22=new JMenuItem("Custom View");
        
        JMenuItem m31=new JMenuItem("Connection settting");
        JMenuItem m32=new JMenuItem("User setting");
        
        mb.add(m1);
        mb.add(m2);
        mb.add(m3);
        mb.add(m4);
        
        m1.add(m11);
        m1.add(m12);
        m1.add(m13);
        m2.add(m21);
        m2.add(m22);
        m3.add(m31);
        m3.add(m32);
        
        JPanel panel=new JPanel();
        label=new JLabel("Enter Text");
        text=new JTextField(10);
        send=new JButton("Send");
        send.addActionListener(this);
        reset=new JButton("Reset");
        reset.addActionListener(this);
        panel.add(mb);
        panel.add(label);
        panel.add(text);
        panel.add(send);
        panel.add(reset);
        
        Border blackline=BorderFactory.createEmptyBorder(5,5,5,5);
        panel.setBorder(blackline);
        panel.setBorder(BorderFactory.createTitledBorder("Chat"));
        ta=new JTextArea();
        ta.setLineWrap(true);
        ta.setEditable(false);
        ta.setForeground(Color.blue);
        Font font=new Font("Dotum",Font.BOLD,10);
        ta.setFont(font);
        frame=new JFrame("chat Frame");
        frame.getContentPane().add(BorderLayout.NORTH,mb);
        frame.getContentPane().add(BorderLayout.CENTER,ta);
        frame.getContentPane().add(BorderLayout.SOUTH,panel);
        frame.setSize(350, 350);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    public static void main(String args[])
    {
        chatform chat=new chatform();
        chat.createform();
    }
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource().equals(send)){
            if(!text.getText().trim().equals("")){
                ta.append(" "+ text.getText()+"\n");
                clear();
            }
        }
        if(e.getSource().equals(reset)){
            ta.setText("");
        }
        if(e.getSource().equals(m11)){
            JFileChooser chooser=new JFileChooser();
            chooser.showOpenDialog(frame);
        }
        if(e.getSource().equals(m13)){
            System.exit(0);
        }
        if(e.getSource().equals(m12)){
            JFileChooser filechooser=new JFileChooser();
            int option=filechooser.showOpenDialog(frame);
            if(option==JFileChooser.APPROVE_OPTION){
                file=filechooser.getSelectedFile();
            }
        }
    }
    public void clear()
    {
        text.setText("");
    }
    public void create() throws IOException
    {
        if(file.exists())
            file.createNewFile();
        else
            JOptionPane.showMessageDialog(frame, "File already exists.....");
    }
}