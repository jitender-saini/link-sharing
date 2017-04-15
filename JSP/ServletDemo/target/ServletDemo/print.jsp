<%--
  Created by IntelliJ IDEA.
  User: akshay
  Date: 14/4/17
  Time: 9:59 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
   int n= Integer.parseInt(request.getParameter("n"));
   for (int i=1;i<=n;i++)
       response.getWriter().println(i);

%>
</body>
</html>
