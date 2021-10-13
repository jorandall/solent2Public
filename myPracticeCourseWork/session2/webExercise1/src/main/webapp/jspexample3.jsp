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

    String name = request.getParameter("userName");
    String address = request.getParameter("userAddress");

    // find what action to perform on the page
    String action = request.getParameter("action");

    if ("removeUser".equals(action)) {
        int removeIdx = Integer.parseInt(request.getParameter("idx"));
        users.remove(removeIdx);
        
    } else if ("addUser".equals(action)) {
        User user = new User();
        
        user.setName(name);
        user.setAddress(address);
        
        users.add(user);
    } else if ("modifyUser".equals(action)) {
        int modifyIdx = Integer.parseInt(request.getParameter("idx"));
        User user = users.get(modifyIdx);
        
        user.setName(name);
        user.setAddress(address);
    }

%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Example 3</title>
    </head>
    <body>
        <h1>JSP Example 3: User list</h1>

        <h2>user list</h2>
        
        <table>
            <tr>
                <th>No.</th>
                <th>Name</th>
                <th>Address</th>
             </tr>
             
            <% for (int idx = 0; idx < users.size(); idx++) {
                        User user = users.get(idx);
            %>
               
                <tr>
                    <td><%=idx + 1%></td>
                    <td><%=user.getName()%></td>
                    <td><%=user.getAddress()%></td>
                    <td>
                        <form action="./jspexample3.jsp" method="get">
                        <input type="hidden" name="idx" value="<%=idx%>">
                        <input type="hidden" name="action" value="removeUser">
                        <button type="submit" >remove</button>
                        </form> 
                        
                        <a href="./modifyuser.jsp?idx=<%=idx%>">
                        <button>modify</button>
                        </form> 
                    </td>
                  
                </tr>
            <%
                }
            %>
        </table>
        <h2>commands</h2>
        <form action="./jspexample3.jsp" method="get">
            <p>user name <input type="text" name="userName" value=""></p>
            <p>user address <input type="text" name="userAddress" value=""></p>
            <input type="hidden" name="action" value="addUser">
            <button type="submit" >add name to list</button>
        </form> 
    </body>
</html>

