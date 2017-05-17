<%@ page language="java" contentType="text/html"
%>
<%@ page import="java.sql.*" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<%! String userdbName;
    String userdbPsw;

%>
<%
    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    String driverName = "com.mysql.jdbc.Driver";
    String url = "jdbc:mysql://localhost:3306/jsp";
    String user = "root";
    String dbpsw = "delete";

    String sql = "SELECT * From user WHERE username =? AND password=?";

    String name = request.getParameter("username");
    String password = request.getParameter("password");
    try {

        Class.forName(driverName);
        con = DriverManager.getConnection(url, user, dbpsw);
        ps = con.prepareStatement(sql);
        ps.setString(1, name);
        ps.setString(2, password);
        rs = ps.executeQuery();
        if (rs.next()) {
            userdbName = rs.getString("username");
            userdbPsw = rs.getString("password");
            if (name.equals(userdbName) && password.equals(userdbPsw)) {
                session.setAttribute("name", userdbName);
                response.sendRedirect("profile.jsp");
            }
        } else {

            response.getWriter().println("Wrong Credentials");
            request.getRequestDispatcher("signin.jsp").include(request, response);
        }
    } catch (Exception e) {
        response.getWriter().println(e);
    }

%>
</body>
</html>