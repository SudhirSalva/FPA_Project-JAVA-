import java.sql.*;
import java.util.Scanner;

class FPAUpdate {
    public static void main(String args[]) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/fpa_db", "root", "1234");
            Scanner sc = new Scanner(System.in);
            int choice;

            do {
                System.out.println("\n1. Insert Record\n2. Update Record\n3. Display Records\n4. Search by ID\n5. Exit");
                System.out.print("Enter choice: ");
                choice = sc.nextInt();
                sc.nextLine();

                switch (choice) {
                    case 1 -> insertRecord(con, sc);
                    case 2 -> updateRecord(con, sc);
                    case 3 -> displayRecords(con);
                    case 4 -> searchRecord(con, sc);
                    case 5 -> System.out.println("Exiting...");
                    default -> System.out.println("Invalid choice! Try again.");
                }
            } while (choice != 5);

            sc.close();
            con.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void insertRecord(Connection con, Scanner sc) throws SQLException {
        System.out.print("Enter ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Location: ");
        String location = sc.nextLine();

        String query = "INSERT INTO fire_accidents (id, location) VALUES (?, ?)";
        try (PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setInt(1, id);
            pstmt.setString(2, location);
            pstmt.executeUpdate();
            System.out.println("Record Inserted!");
        }
    }

    private static void updateRecord(Connection con, Scanner sc) throws SQLException {
        System.out.print("Enter ID to update: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter New Location: ");
        String location = sc.nextLine();

        String query = "UPDATE fire_accidents SET location=? WHERE id=?";
        try (PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setString(1, location);
            pstmt.setInt(2, id);
            int rows = pstmt.executeUpdate();
            System.out.println(rows > 0 ? "Record Updated!" : "ID not found!");
        }
    }

    private static void displayRecords(Connection con) throws SQLException {
        String query = "SELECT * FROM fire_accidents";
        try (Statement stmt = con.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                System.out.println(rs.getInt(1) + " - " + rs.getString(2));
            }
        }
    }

    private static void searchRecord(Connection con, Scanner sc) throws SQLException {
        System.out.print("Enter ID: ");
        int id = sc.nextInt();

        String query = "SELECT * FROM fire_accidents WHERE id = ?";
        try (PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                System.out.println("Found: " + rs.getInt(1) + " - " + rs.getString(2));
            } else {
                System.out.println("ID not found!");
            }
        }
    }
}
