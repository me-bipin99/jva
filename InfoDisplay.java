
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.*;


public class InfoDisplay implements ActionListener{
    JLabel lblId,lblName,lblPrice;
    JTextField txtId,txtName,txtPrice;
    JButton btnFirst,btnBack,btnNext,btnLast;
    JPanel panel;
    JFrame frame;
    Connection con;
    Statement st;
    ResultSet rs;
    void createForm(){
        lblId=new JLabel("ID:");
        lblName=new JLabel("Name:");
        lblPrice=new JLabel("Price:");
        
        txtId=new JTextField();
        txtName=new JTextField(10);
        txtPrice=new JTextField();
        
        btnFirst=new JButton("First");
        btnBack=new JButton("Back");
        btnNext=new JButton("Next");
        btnLast=new JButton("Last");
        
        btnFirst.addActionListener(this);
        btnBack.addActionListener(this);
        btnNext.addActionListener(this);
        btnLast.addActionListener(this);
        
        lblId.setBounds(50,20,80,25);
        lblName.setBounds(50,60,80,25);
        lblPrice.setBounds(50,100,80,25);
        
        txtId.setBounds(150,20,160,25);
        txtName.setBounds(150,60,160,25);
        txtPrice.setBounds(150,100,160,25);
        
        btnFirst.setBounds(30,180,80,25);
        btnBack.setBounds(130,180,80,25);
        btnNext.setBounds(230,180,80,25);
        btnLast.setBounds(330,180,80,25);
        
        panel=new JPanel();
        panel.setLayout(null);
        panel.add(lblId);
        panel.add(lblName);
        panel.add(lblPrice);
        panel.add(txtId);
        panel.add(txtName);
        panel.add(txtPrice);
        
        panel.add(btnFirst);
        panel.add(btnBack);
        panel.add(btnNext);
        panel.add(btnLast);
        
        frame =new JFrame("Data Display Form...");
        frame.add(panel);
        frame.setSize(500,400);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        
    }
    void connectionDB(){
    try{
            //Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            //String db_url = "jdbc:sqlserver://ANJIL\\SQLEXPRESS:1433;databaseName=BCA;integratedSecurity=true;";

            Class.forName("com.mysql.cj.jdbc.Driver");
            String db_url="jdbc:mysql://localhost:3306/bca";
            String db_user="root";
            String db_password="";
            con=DriverManager.getConnection(db_url,db_user,db_password);
            System.out.println("Database connected");
            st=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
            String sql="SELECT * FROM PRODUCT;";
            rs=st.executeQuery(sql);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    void displayData() {
        try {
            if (rs != null && rs.isBeforeFirst() == false) {
                txtId.setText(rs.getString(1));
                txtName.setText(rs.getString(2));
                txtPrice.setText(String.valueOf(rs.getFloat(3)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void actionPerformed(ActionEvent e){
         try {
            if (e.getSource() == btnFirst && rs.first()) {
                displayData();
            } else if (e.getSource() == btnLast && rs.last()) {
                displayData();
            } else if (e.getSource() == btnNext && rs.next()) {
                displayData();
            } else if (e.getSource() == btnBack && rs.previous()) {
                displayData();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    public static void main(String args[]){
        InfoDisplay infoDisplay = new InfoDisplay();
        infoDisplay.createForm();
        infoDisplay.connectionDB();
    }   
}
