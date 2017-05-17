import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class Login extends HttpServlet  {
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        System.out.println(username + "  --  " + password);
        PrintWriter writer = response.getWriter();

//        response.setHeader("Cache-Control", "no-cache");
//        response.setHeader("Cache-Control", "no-store");
//        response.setHeader("Pragma", "no-cache");
//        response.setDateHeader("Expires", 0);
//        if(request.getSession().getAttribute("username")!=null) {
//            response.sendRedirect("index.html");
//        }

        if(Validate.checkUser(username,password)){
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("welcome");
           // System.out.println("Forwarding request to welcome....");
            HttpSession session = request.getSession();
            session.setAttribute("username", username);
            requestDispatcher.include(request,response);
        }
        else{
            System.out.println("Invalid login details");
            RequestDispatcher rs = request.getRequestDispatcher("register.html");
            rs.forward(request,response);
        }
    }
}
