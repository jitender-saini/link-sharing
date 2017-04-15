
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

public class Register extends HttpServlet {
    
    public void init()
    {
        
    }
    public void doPost(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws IOException, ServletException {
    
        String html="<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>Registration</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "\n" +
                "<h1 align=\"center\">User-Register</h1>\n" +
                "\n" +
                "<div align=\"center\">\n" +
                "<table>\n" +
                "    <form name=\"register\" action=\"/register\" method=\"post\">\n" +
                "\n" +
                "        <tr>\n" +
                "    <td>    Name</td>\n" +
                "      <td>  <input type=\"text\" name=\"name\" required maxlength=\"20\" placeholder=\"name\"/></td>\n" +
                "            </tr>\n" +
                "<tr>\n" +
                "    <td>User-Name</td>\n" +
                " <td>   <input type=\"text\" name=\"username\" required maxlength=\"10\" placeholder=\"Username\"/></td></tr>\n" +
                "\n" +
                "        <tr>\n" +
                "            <td> Password</td>\n" +
                "            <td><input type=\"password\" name=\"password\" maxlength=\"10\" placeholder=\"Password\" required/></td></tr>\n" +
                "        <tr>\n" +
                "            <td>\n" +
                "        <input type=\"submit\" value=\"Sign-Up\">\n" +
                "            </td>\n" +
                "            <td><a href=\"signin.jsp\">Login?</a></td>\n" +
                "        </tr>\n" +
                "   </form>\n" +
                "</table>\n" +
                "</div>\n" +
                "\n" +
                "</body>\n" +
                "</html>";
        
        
        String name = httpServletRequest.getParameter("name");
        String username = httpServletRequest.getParameter("username");
        String password = httpServletRequest.getParameter("password");
        PrintWriter out=httpServletResponse.getWriter();
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con= DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/jsp","root","delete");
            PreparedStatement preparedStatement=con.prepareStatement("insert into user VALUES (?,?,?)");
         preparedStatement.setString(1,name);
            preparedStatement.setString(2,username);
            preparedStatement.setString(3,password);
    
            System.out.println( preparedStatement.executeUpdate());
    
            out.println("<h1 style=\"color:green\"> Registration Successful </h1>   ");
          httpServletRequest.getRequestDispatcher("register.jsp").include(httpServletRequest,httpServletResponse);
            con.close();
        }catch(Exception e){
          out.println("<h1 style=\"color:red\"> Registration Failed </h1>   ");
            out.println(html);
            e.printStackTrace();
        }
    
    }
    
    
    
    public void destroy()
    {
        
    }
    
}
