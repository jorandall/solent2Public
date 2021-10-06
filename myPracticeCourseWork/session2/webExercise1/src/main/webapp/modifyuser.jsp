<%-- 
    Document   : jspexample3
    Created on : 22-Jul-2021, 11:16:28
    Author     : admin
    THIS EXAMPLE SHOWS HOW OBJECTS CAN BE STORED IN THE SESSION
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.mycompany.webexercise1.model.User" %>
<%
    // retrieve the stored users list from the session
    List<User> users = (List<User>) session.getAttribute("users");
    if (users == null) {
        users = new ArrayList<User>();
        session.setAttribute("users", users);
    }

    int idx = Integer.parseInt(request.getParameter("idx"));
    User user = users.get(idx);
    
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Example 3</title>
    </head>
    <body>
        <h1>JSP Example 3: Modify User</h1>

        <h2>commands</h2>
        <form action="./jspexample3.jsp" method="get">
            <p>user name <input type="text" name="userName" value="<%= user.getName()%>"</p>
            <p>user address <input type="text" name="userAddress" value="<%= user.getAddress()%>"></p>
            <input type="hidden" name="idx" value="<%=idx%>">
            <input type="hidden" name="action" value="modifyUser">
            <button type="submit" >update</button>
        </form> 
    </body>
</html>

