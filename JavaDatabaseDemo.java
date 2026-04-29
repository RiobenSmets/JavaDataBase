import java.sql.*;
import java.util.Scanner;
public class JavaDatabaseDemo {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/javadb";
        String user = "root";
        String password = "";
        String query = "SELECT studentid, lname, fname, mi FROM student";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, user, password);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            Scanner sc = new Scanner(System.in);    

            while (resultSet.next()) {
                String studentid = resultSet.getString("studentid");
                String lname = resultSet.getString("lname");
                String fname = resultSet.getString("fname");
                String mi = resultSet.getString("mi");
                System.out.println("ID: " + studentid + ", Last Name: " + lname + ", First Name: " + fname  + ", MI: " + mi);

            }   

            String insertQuery = "INSERT INTO student (studentid, lname, fname, mi) VALUES (?, ?, ?, ?)";

            System.out.println("Add a new student to the database.");

            System.out.print("Enter Student ID: ");
            String studentid = sc.nextLine();

            System.out.print("Enter Last Name: ");
            String lname = sc.nextLine();

            System.out.print("Enter First Name: ");
            String fname = sc.nextLine();

            System.out.print("Enter Middle Initial: ");
            String mi = sc.nextLine();


            PreparedStatement pstmt = connection.prepareStatement(insertQuery);

            pstmt.setString(1, studentid);
            pstmt.setString(2, lname);
            pstmt.setString(3, fname);
            pstmt.setString(4, mi);

            pstmt.executeUpdate();

            System.out.println("Successfully added: " + studentid + ", " + lname + ", " + fname + " " + mi);

            pstmt.close();
            resultSet.close();
            connection.close();
            statement.close();
            sc.close();

        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found!");
            e.printStackTrace();

        } catch (SQLException e) {
            System.out.println("Connection failed!");
            e.printStackTrace();
        }
    }
}

//PD:\JavaDatabaseOOP\DatabaseDemo> javac -cp ".;lib\mysql-connector-j-9.7.0.jar" JavaDatabaseDemo.java
//PS D:\JavaDatabaseOOP\DatabaseDemo> java -cp ".;lib\mysql-connector-j-9.7.0.jar" JavaDatabaseDemo