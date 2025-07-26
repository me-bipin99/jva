
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.*;

public class DrawImage extends JPanel{
    public void paint(Graphics g){
        ImageIcon icon=new ImageIcon("/home/mebipin/Pictures/Camera/1682941176240-3.jpg");
        Image img=icon.getImage();
        g.drawImage(img, 0, 0, this);
        g.drawImage(img,250,250,this);
        g.drawImage(img, 0, 250,150,100,this);
        
    }
    public static void main(String args[]){
        JFrame f=new JFrame("Insert an image");
        f.add(new DrawImage());
        f.setSize(700, 700);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}