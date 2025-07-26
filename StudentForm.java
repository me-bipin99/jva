import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;

public class StudentForm extends JFrame {
    JTextField txtName, txtAddress, txtContact, txtEmail;
    JComboBox<String> cmbFaculty, cmbLevel;
    ArrayList<Student> studentList = new ArrayList<>();
    JLabel header, lblName, lblAddress, lblContact, lblEmail, lblFaculty, lblLevel;
    JTextArea txtArea;
    JButton btnSubmit;
    JPanel panel;
    JFrame frame;
    public void Form() {
        header = new JLabel("Student Registration Form");
        lblName = new JLabel("Name:");
        lblEmail = new JLabel("Email:");
        lblAddress = new JLabel("Address:");
        lblContact = new JLabel("Contact:");
        lblFaculty = new JLabel("Faculty:");
        lblLevel = new JLabel("Level:");

        txtName = new JTextField();
        txtAddress = new JTextField();
        txtContact = new JTextField();
        txtEmail = new JTextField();
        String[] faculties = {"","BCA", "BBA", "BBS", "MCA", "MBA"};
        cmbFaculty = new JComboBox<>(faculties);
        String[] levels = {" ","Bachelor", "Masters"};
        cmbLevel = new JComboBox<>(levels);
        btnSubmit = new JButton("Submit");
        txtArea = new JTextArea();

        header.setBounds(200, 10, 200, 30);
        lblName.setBounds(50, 40, 100, 25);
        lblAddress.setBounds(50, 100, 100, 25);
        lblContact.setBounds(50, 160, 100, 25);
        lblEmail.setBounds(50, 220, 100, 25);
        lblFaculty.setBounds(50, 280, 100, 25);
        lblLevel.setBounds(50, 340, 100, 25);
        txtName.setBounds(140, 40, 200, 25);
        txtAddress.setBounds(140, 100, 200, 25);
        txtContact.setBounds(140, 160, 200, 25);
        txtEmail.setBounds(140, 220, 200, 25);
        cmbFaculty.setBounds(140, 280, 200, 25);
        cmbLevel.setBounds(140, 340, 200, 25);
        btnSubmit.setBounds(140, 400, 100, 25);
        txtArea.setBounds(10, 440, 600, 100);

        frame = new JFrame("Student Form");
        panel = new JPanel();
        panel.setLayout(null);
        panel.add(header);
        panel.add(lblName);
        panel.add(lblAddress);
        panel.add(lblContact);
        panel.add(lblEmail);
        panel.add(lblFaculty);
        panel.add(lblLevel);
        panel.add(txtName);
        panel.add(txtAddress);
        panel.add(txtContact);
        panel.add(txtEmail);
        panel.add(cmbFaculty);
        panel.add(cmbLevel);
        panel.add(btnSubmit);
        panel.add(txtArea);
        txtArea.setEditable(false);
        frame.getContentPane().add(panel);
        frame.setSize(700, 600);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        btnSubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addStudent();
            }
        });
    }

    private void addStudent() {
        String name = txtName.getText();
        String address = txtAddress.getText();
        String contact = txtContact.getText();
        String email = txtEmail.getText();
        String faculty = (String) cmbFaculty.getSelectedItem();
        String level = (String) cmbLevel.getSelectedItem();

        Student student = new Student(name, address, contact, email, faculty, level);
        studentList.add(student);
        displayStudents();
    }

    private void displayStudents() {
        txtArea.setText("");
        for (Student student : studentList) {
            txtArea.append(student.toString() + "\n");
        }
    }

    private class Student {
        private String name, address, contact, email, faculty, level;

        public Student(String name, String address, String contact, String email, String faculty, String level) {
            this.name = name;
            this.address = address;
            this.contact = contact;
            this.email = email;
            this.faculty = faculty;
            this.level = level;
        }

        @Override
        public String toString() {
            return "Name: " + name + ", Address: " + address + ", Contact: " + contact + ", Email: " + email + ", Faculty: " + faculty + ", Level: " + level;
        }
    }

    public static void main(String[] args) {
        StudentForm form=new StudentForm();
        form.Form();
    }
}
