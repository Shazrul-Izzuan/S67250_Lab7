<%-- 
    Document   : user
    Created on : 30 May 2024, 11:37:11 pm
    Author     : ashaz
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>New Record</title>
    </head>
    <body>
        <p><b>New Record</b></p>
        <form name="frmAddUser" action="UserController" method="POST">
            <table border="0">
                <tbody>
                    <tr>
                        <td>User ID:</td>
                        <td><input type="text" name="userid" size="25" required /></td>
                    </tr>
                    <tr>
                        <td>First Name:</td>
                        <td><input type="text" name="firstName" size="40" /></td>
                    </tr>
                    <tr>
                        <td>Last Name:</td>
                        <td><input type="text" name="lastName" size="40" /></td>
                    </tr>
                    <tr>
                        <td><input type="hidden" name="action" value="insert" /></td>
                    </tr>
                    <tr>
                        <td><input type="submit" value="Submit" name="submit" /></td>
                        <td><input type="reset" value="Cancel" name="cancel" /></td>
                    </tr>
                </tbody>
            </table>
        </form>
    </body>
</html>
