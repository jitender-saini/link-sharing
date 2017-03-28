import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BlogServlet extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter writer = response.getWriter();

        String blogTitle=request.getParameter("blogTitle");
        String blogBody = request.getParameter("blogBody");

//        response.setHeader("Cache-Control", "no-cache");
//        response.setHeader("Cache-Control", "no-store");
//        response.setHeader("Pragma", "no-cache");
//        response.setDateHeader("Expires", 0);
//        if(request.getSession().getAttribute("username")!=null) {
//            response.sendRedirect("index.html");
//        }

        HttpSession session = request.getSession(false);
    try{
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","delete");
        PreparedStatement ps = con.prepareStatement("insert into blogs(title,blog_body,username) values(?,?,?)");
        if(session!=null) {
            String username = (String) session.getAttribute("username");

            ps.setString(1, blogTitle);
            ps.setString(2, blogBody);
            ps.setString(3, username);
            ps.executeUpdate();
            System.out.println("inserting data into blog table");
            //writer.println("<h1 style=\"color:green\"> Blog is saved :)</hl>");
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("welcome");
            requestDispatcher.include(request,response);
        }
    }catch (ClassNotFoundException e){
        System.out.println("error");
    }
    catch (SQLException e){
        System.out.println("sql error");
    }

    }
}
