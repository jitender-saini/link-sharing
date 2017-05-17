<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Registration</title>
</head>
<body>

<h1 align="center">User-Register</h1>

<div align="center">
    <table>
        <form name="register" action="/register" method="post">

            <tr>
                <td> Name</td>
                <td><input type="text" name="name" required maxlength="20" placeholder="name"/></td>
            </tr>
            <tr>
                <td>User-Name</td>
                <td><input type="text" name="username" required maxlength="10" placeholder="Username"/></td>
            </tr>

            <tr>
                <td> Password</td>
                <td><input type="password" name="password" maxlength="10" placeholder="Password" required/></td>
            </tr>
            <tr>
                <td>
                    <input type="submit" value="Sign-Up">
                </td>
                <td><a href="signin.jsp">Login?</a></td>
            </tr>
        </form>
    </table>
</div>

</body>
</html>