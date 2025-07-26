
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.*;
public class FontExample extends JPanel {
    public void paint(Graphics g){
        g.setFont(new Font("Arial",Font.BOLD,12));
        g.drawString("This is sample text",20,30);

        g.setFont(new Font("Serif",Font.ITALIC,18));
        g.drawString("This is another sample text",20,60);
        
        g.setFont(new Font("Monospaced",Font.BOLD,20));
        g.drawString("This is again another sample text",20,90);
        
        g.setFont(new Font("Times New Roman",Font.BOLD,20));
        g.drawString("This is again another sample text with times new roman",20,120);
    }
}
