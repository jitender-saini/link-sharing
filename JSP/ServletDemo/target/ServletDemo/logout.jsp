<%@ page language="java" contentType="text/html;"
        %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html;">
    <title>Logout</title>
</head>
<body>
<% session.invalidate();
response.getWriter().println("SuccessFully Logged Out");
request.getRequestDispatcher("signin.jsp").include(request,response);
%>
</body>
</html>