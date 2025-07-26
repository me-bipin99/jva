import javax.swing.*;
public class DrawShapes {
    public static void main(String [] args){
        JFrame frame=new JFrame("Sample Shapes");
        frame.add(new Shapes());
        frame.setSize(400,250);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
