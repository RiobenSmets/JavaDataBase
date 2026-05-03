import java.sql.*;
import java.util.Scanner;

public class AddStudent {
    public void execute(Scanner sc) {
        System.out.print("ID: ");
        String id = sc.nextLine();

        System.out.print("Last Name: ");
        String lname = sc.nextLine();

        System.out.print("First Name: ");
        String fname = sc.nextLine();

        System.out.print("MI: ");
        String mi = sc.nextLine();

        String query = "INSERT INTO student (studentid, lname, fname, mi) VALUES (?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setString(1, id);
            ps.setString(2, lname);
            ps.setString(3, fname);
            ps.setString(4, mi);

            ps.executeUpdate();

            System.out.println("Student added!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}