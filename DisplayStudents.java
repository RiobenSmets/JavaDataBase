import java.sql.*;

public class DisplayStudents {
    public void execute() {
        String query = "SELECT * FROM student";

        try (Connection conn = DatabaseConnection.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                System.out.println(
                    rs.getString("studentid") + " - " +
                    rs.getString("lname") + ", " +
                    rs.getString("fname")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}