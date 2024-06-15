<%-- 
    Document   : editUser
    Created on : 31 May 2024, 12:05:46 am
    Author     : ashaz
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit User</title>
    </head>
    <body>
        <p>Updating User Profile</p>
        <form name="frmEditUser" action="UserController" method="POST">
            <table border="0">
                <tbody>
                    <tr>
                        <td>User ID:</td>
                        <td><input type="text" name="userid" readonly="readonly" value="<c:out value='${user.userid}' />" size="25" /></td>
                    </tr>
                    <tr>
                        <td>First Name:</td>
                        <td><input type="text" name="firstName" value="<c:out value='${user.firstName}' />" size="40" /></td>
                    </tr>
                    <tr>
                        <td>Last Name:</td>
                        <td><input type="text" name="lastName" value="<c:out value='${user.lastName}' />" size="40" /></td>
                    </tr>
                    <tr>
                        <td><input type="hidden" name="action" value="edit" /></td>
                    </tr>
                    <tr>
                        <td><input type="submit" name="Submit" value="submit" /></td>
                    </tr>
                </tbody>
            </table>
        </form>
    </body>
</html>
