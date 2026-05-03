import java.sql.*;
import java.util.Scanner;

public class DeleteStudent {
    public void execute(Scanner sc) {
        System.out.print("Enter ID to delete: ");
        String id = sc.nextLine();

        String query = "DELETE FROM student WHERE studentid = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setString(1, id);
            ps.executeUpdate();

            System.out.println("Deleted!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}