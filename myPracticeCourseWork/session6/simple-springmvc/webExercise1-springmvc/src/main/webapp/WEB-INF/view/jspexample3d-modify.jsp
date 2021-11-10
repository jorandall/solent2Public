<%-- 
    Document   : jspexample2
    Created on : 22-Jul-2021, 11:16:28
    Author     : admin
    THIS EXAMPLE USES USER OBJECT
--%>
        
        // To be deleted once ReST implemented - see service/AdminService.java
        propertiesDao.setProperty("org.solent.ood.assessmentgroupa7.name", name);
        propertiesDao.setProperty("org.solent.ood.assessmentgroupa7.enddate", endDate);
        propertiesDao.setProperty("org.solent.ood.assessmentgroupa7.cardno", cardNumber);
        propertiesDao.setProperty("org.solent.ood.assessmentgroupa7.cvv", cvv);
        propertiesDao.setProperty("org.solent.ood.assessmentgroupa7.issueno", issueNumber);
    }
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Example 3d</title>
    </head>
    <body>
        <h1>JSP Example 3d: Modify User table</h1>

        <h2>Modify user</h2>
        <form action="./userlist-modify" method="post">
            <p>user name <input type="text" name="userName" value="${user.name}"></p>
            <p>user address <input type="text" name="userAddress" value="${user.address}"></p>
            <input type="hidden" name="action" value="modifyUser">
            <input type="hidden" name="index" value="${index}">
            <button type="submit" >modify user</button>
        </form> 
        <br>
        <form action="./userlist" method="get">
            <button type="submit" >return to user list</button>
        </form> 
        <br>
        <a href="./" >back to index page</a>
    </body>
</html>
