import java.sql.*;
import java.util.Scanner;

public class SearchStudent {
    public void execute(Scanner sc) {
        System.out.print("Enter ID: ");
        String id = sc.nextLine();

        String query = "SELECT * FROM student WHERE studentid = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                System.out.println(
                    rs.getString("studentid") + " - " +
                    rs.getString("lname") + ", " +
                    rs.getString("fname")
                );
            } else {
                System.out.println("Not found.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}