import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Databases {
    public Connection con;
    public Statement stat;
    public ResultSet rs;
    public Databases() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String db_url = "jdbc:mysql://localhost:3306/bca";
            String db_user = "root";
            String db_password = "";
            con = DriverManager.getConnection(db_url, db_user, db_password);
            stat = con.createStatement();
            System.out.println("Database connected successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void createTable() {
        try {
            String sql = "CREATE TABLE IF NOT EXISTS Student (" +
                         "ID VARCHAR(10) PRIMARY KEY, " +
                         "NAME VARCHAR(30), " +
                         "AGE INT)";
            stat.executeUpdate(sql);
            System.out.println("Table checked/created successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void insertData() {
        try {
            String insert = "INSERT INTO Student (ID, NAME, AGE) VALUES " +
                            "('1/2078', 'Raj', 18), " +
                            "('2/2078', 'Hari', 19)";

            int insertResult = stat.executeUpdate(insert);
            if (insertResult > 0) {
                System.out.println("Record(s) inserted successfully!");
            } else {
                System.out.println("Insertion failed!");
            }
        } catch (Exception e) {
            if (e.getMessage().contains("Duplicate entry")) {
                System.out.println("Record already exists!");
            } else {
                e.printStackTrace();
            }
        }
    }

    public void displayData() {
        try {
            String select = "SELECT * FROM Student";
            rs = stat.executeQuery(select);

            System.out.println("Retrieve:");
            System.out.println("ID\tName\tAge");
            while (rs.next()) {
                System.out.println(rs.getString(1) + "\t" + rs.getString(2) + "\t" + rs.getInt(3));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } 
    }

    public void deleteData(String studentId) {
        try {
            String delete = "DELETE FROM Student WHERE ID = '" + studentId + "'";
            int affectedRows = stat.executeUpdate(delete);
            if (affectedRows > 0) {
                System.out.println("Record with ID " + studentId + " deleted successfully!");
            } else {
                System.out.println("No record found with ID " + studentId);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String args[]) {
        Databases db = new Databases();
        db.createTable();
        db.insertData();
        db.displayData();
        db.deleteData("1/2078");
        db.displayData(); 
    }
}