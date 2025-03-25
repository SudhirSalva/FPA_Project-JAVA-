import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ContributeServlet")
public class ContributeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException {
        
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String contributionType = request.getParameter("contributionType");
        String amount = request.getParameter("amount");

        // Ensure amount is not null or empty
        amount = (amount == null || amount.isEmpty()) ? "0" : amount;

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/fpa", "root", "password");

            String sql = "INSERT INTO contributions (name, email, contribution_type, amount) VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, name);
            stmt.setString(2, email);
            stmt.setString(3, contributionType);
            stmt.setDouble(4, Double.parseDouble(amount)); // Ensures amount is stored as a number

            int rowsInserted = stmt.executeUpdate();

            if (rowsInserted > 0) {
                out.println("<h3>Contribution Submitted Successfully!</h3>");
            } else {
                out.println("<h3>Submission Failed. Try again.</h3>");
            }
        } catch (Exception e) {
            out.println("<h3>Error: " + e.getMessage() + "</h3>");
        }
    }
}
