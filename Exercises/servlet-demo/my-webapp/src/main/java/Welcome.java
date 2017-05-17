import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class Welcome extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter writer = response.getWriter();

//        response.setHeader("Cache-Control", "no-cache");
//        response.setHeader("Cache-Control", "no-store");
//        response.setHeader("Pragma", "no-cache");
//        response.setDateHeader("Expires", 0);
//        if(request.getSession().getAttribute("username")!=null) {
//            response.sendRedirect("index.html");
//        }

        request.getRequestDispatcher("welcome.html").include(request,response);
        writer.println("Hello ");
        HttpSession session = request.getSession(false);
        if(session!=null){
            String username=(String)session.getAttribute("username");
            writer.println(username);
        }

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "delete");
            PreparedStatement ps = con.prepareStatement("select * from blogs ORDER BY post_date DESC");
            ResultSet rs = ps.executeQuery();

            writer.println("<div>");
            writer.println("<h1>Blog displayed here</h1>");
            writer.println("<ul>");
            while (rs.next()){
                writer.println("<li> Blog Title is: "+rs.getString("title")+"</li>");
                writer.println("<li>"+rs.getString("blog_body")+"</li>");
                writer.println("<li> Blog is Written By: "+rs.getString("username")+"</li>");
                writer.println("<li> Posted on: "+rs.getTimestamp("post_date")+"</li></br></br>");
            }
            writer.println("</ul>");
            writer.println("</div>");

        }catch (SQLException e){
            System.out.println("servlet exception");
        }
        catch (ClassNotFoundException e){
            System.out.println("Class not found");
        }
    }
}
