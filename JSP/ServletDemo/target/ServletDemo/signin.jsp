<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Registration</title>
</head>
<body>

<h1 align="center">Login</h1>
<div align="center"></div>
<div align="center">
    <table>

        <form name="login" action="login.jsp" method="post">
            <tr>
                <td>User-Name</td>
                <td><input type="text" name="username" maxlength="10" required placeholder="Username"/></td>
            </tr>


            <tr>
                <td> Password</td>
                <td><input type="password" name="password" maxlength="10" placeholder="Password" required/></td>
            </tr>
            <tr>
                <td>
                    <input type="submit" value="login">
                </td>
                <td><a href="register.jsp">Signup?</a></td>
            </tr>
        </form>
    </table>

</div>

</body>
</html>