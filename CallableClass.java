//database procedure

// DELIMITER //

//CREATE PROCEDURE GetStudent(IN studentaddress VARCHAR(10))
//BEGIN
  //  SELECT * FROM students WHERE address = studentaddress;
//END //

////DELIMITER ;



import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class CallableClass {
    public static void main(String [] args){
         try{
            //Class.forName{"com.microsoft.sqlserver.jdbc.SQLServerDriver"};
            //String db_url="jdbc:sqlserver://COOLDUDE\\SQLEXPRESS2:1433;databaseName=BCA;integratedSecurity=true;";
            Class.forName("com.mysql.cj.jdbc.Driver");
            String db_url="jdbc:mysql://localhost:3306/bca";
            String db_user="root";
            String db_password="";
            Connection con=DriverManager.getConnection(db_url,db_user,db_password);
            System.out.println("Database connected....");
            String query="CALL GETStudent('Kathmandu')";
            CallableStatement callstmt=con.prepareCall(query);
            ResultSet rs=callstmt.executeQuery();
            System.out.println("Id\tName\t\taddress\t\tcontact\t\tfaculty\tlevel");
            while(rs.next()){
                for(int i=1;i<=6;i++)   
                    System.out.print(rs.getString(i)+"\t");
                System.out.println();
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}