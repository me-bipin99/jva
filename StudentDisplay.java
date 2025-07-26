import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.sql.*;

public class StudentDisplay extends JFrame {
    JTextField txtName, txtAddress, txtContact, txtEmail;
    JComboBox<String> cmbFaculty, cmbLevel;
    JLabel header, lblName, lblAddress, lblContact, lblEmail, lblFaculty, lblLevel;
    JButton btnSubmit;
    JPanel panel;
    JFrame frame;
    private Connection conn;

    public StudentDisplay() {
        initializeDB();
        initializeUI();
    }

    public void initializeDB() {
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bca", "root", "");
            Statement stmt = conn.createStatement();
            stmt.executeUpdate("CREATE TABLE IF NOT EXISTS students (id INT PRIMARY KEY AUTO_INCREMENT, name VARCHAR(100), address VARCHAR(100),contact VARCHAR(100),Faculty VARCHAR(100),level VARCHAR(100),email VARCHAR(100))");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void initializeUI() {
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

        header.setBounds(200, 10, 200, 30);
        lblName.setBounds(50, 40, 100, 25);
        lblAddress.setBounds(50, 100, 100, 25);
        lblContact.setBounds(50, 160, 100, 25);
        lblFaculty.setBounds(50, 220, 100, 25);
        lblLevel.setBounds(50, 280, 100, 25);
        lblEmail.setBounds(50, 340, 100, 25);
        txtName.setBounds(140, 40, 200, 25);
        txtAddress.setBounds(140, 100, 200, 25);
        txtContact.setBounds(140, 160, 200, 25);
        cmbFaculty.setBounds(140, 220, 200, 25);
        cmbLevel.setBounds(140, 280, 200, 25);
        txtEmail.setBounds(140, 340, 200, 25);
        btnSubmit.setBounds(140, 400, 100, 25);

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
        frame.getContentPane().add(panel);
        frame.setSize(500, 600);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        btnSubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loadStudents();
            }
        });
    }
    
private void loadStudents(){
        String name = txtName.getText();
        String address = txtAddress.getText();
        String contact = txtContact.getText();
        String email = txtEmail.getText();
        String faculty = (String) cmbFaculty.getSelectedItem();
        String level = (String) cmbLevel.getSelectedItem();
        
        try {
            String query = "INSERT INTO students (name, address, contact, email, Faculty, level) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, name);
            pstmt.setString(2, address);
            pstmt.setString(3, contact);
            pstmt.setString(4, email);
            pstmt.setString(5, faculty);
            pstmt.setString(6, level);
            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(this, "Student registered successfully in database!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        displayStudents();
        

    }

public void displayStudents(){
        frame = new JFrame("Student Form");
        panel = new JPanel();
        panel.setLayout(null);
        String[] columnNames = {"Name", "Address", "Contact", "Email", "Faculty", "Level"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(10, 10, 600, 200);
        panel.add(scrollPane);
        try{
            String query = "SELECT * FROM students";
            PreparedStatement pstmt = conn.prepareStatement(query);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                String name = rs.getString("name");
                String address = rs.getString("address");
                String contact = rs.getString("contact");
                String email = rs.getString("email");
                String faculty = rs.getString("Faculty");
                String level = rs.getString("level");
                model.addRow(new Object[]{name, address, contact, email, faculty, level});
            }
            pstmt.close();
            rs.close();
        }catch (SQLException e) {
            e.printStackTrace();
        }
        frame.getContentPane().add(panel);
        frame.setSize(650, 400);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }

    public static void main(String[] args) {
        new StudentDisplay();
    }
}