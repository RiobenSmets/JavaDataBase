import java.sql.*;
import java.util.Scanner;

public class UpdateStudent {
    public void execute(Scanner sc) {
        System.out.print("Enter ID: ");
        String id = sc.nextLine();

        System.out.print("New Last Name: ");
        String lname = sc.nextLine();

        System.out.print("New First Name: ");
        String fname = sc.nextLine();

        System.out.print("New MI: ");
        String mi = sc.nextLine();

        String query = "UPDATE student SET lname=?, fname=?, mi=? WHERE studentid=?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setString(1, lname);
            ps.setString(2, fname);
            ps.setString(3, mi);
            ps.setString(4, id);

            ps.executeUpdate();

            System.out.println("Updated!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}