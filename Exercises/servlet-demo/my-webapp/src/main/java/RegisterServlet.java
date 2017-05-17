import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

public class RegisterServlet extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter writer = response.getWriter();

        String name = request.getParameter("name");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","delete");
            PreparedStatement ps = con.prepareStatement("insert into user values(?,?,?)");

            ps.setString(1,name);
            ps.setString(2,username);
            ps.setString(3,password);

            ps.executeUpdate();
            ps.close();
        }catch (ClassNotFoundException e){
            writer.println("<h1 style=\"color:red\"> Unable to register</hl>");
        }
        catch (SQLException e){
            writer.println("<h1 style=\"color:red\"> Unable to register</hl>");
        }
       // writer.println("<h1 style=\"color:green\"> You are registered</hl>");
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.html");
        requestDispatcher.forward(request,response);
    }

}
