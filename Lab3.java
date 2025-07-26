import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import javax.swing.*;

public class Lab3 implements KeyListener {

    JTextField txt;
    JLabel lbl;

    public void form() {
        txt = new JTextField(10);
        lbl = new JLabel("Sum will appear here");

        JFrame frame = new JFrame("Sum of Odd/Even Digits");
        frame.setLayout(new java.awt.FlowLayout());  // use FlowLayout consistently
        frame.add(txt);
        frame.add(lbl);

        txt.addKeyListener(this);

        frame.setSize(300, 120);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    // When a key is typed or released, update the sum display
    public void calculateSum() {
        String input = txt.getText();
        int evenSum = 0, oddSum = 0;

        for (char c : input.toCharArray()) {
            if (Character.isDigit(c)) {
                int digit = Character.getNumericValue(c);
                if (digit % 2 == 0) {
                    evenSum += digit;
                } else {
                    oddSum += digit;
                }
            }
        }
        lbl.setText("Even: " + evenSum + " | Odd: " + oddSum);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // not used
    }

    @Override
    public void keyReleased(KeyEvent e) {
        calculateSum(); // update when key is released
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // not used
    }

    public static void main(String[] args) {
        new Lab3().form();
    }
}
