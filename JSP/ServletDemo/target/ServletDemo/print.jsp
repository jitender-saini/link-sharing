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
