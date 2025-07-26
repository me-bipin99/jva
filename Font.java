import javax.swing.JFrame;
public class Font {
    public static void main(String args[]){
        JFrame frame=new JFrame("Font Styles");
        frame.add(new FontExample());
        frame.setSize(480,350);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
