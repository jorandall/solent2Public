<%-- 
    Document   : checkcard
    Created on : 28 Jul 2021, 17:13:43
    Author     : cgallen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="solent.ac.uk.ood.examples.cardcheck.CardValidationResult" %>
<%@ page import="solent.ac.uk.ood.examples.cardcheck.RegexCardValidator" %>

<%
    String creditcardno = request.getParameter("creditcardno");
    CardValidationResult result = RegexCardValidator.isValid(creditcardno);
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Check Credit Card</h1>
   
        <form action="./checkcard.jsp" method="post">
            <input type="text" name="creditcardno" value="<%=creditcardno%>">
            <button type="submit" >Check Card</button>
        </form> 
        
        <% if(result.isValid()) {%>
        <p>"<%=creditcardno%>" is a valid card number issued by <%=result.getCardType()%> </p>
        <%} else {%>
        <p>"<%=creditcardno%>" is an invalid card number: <%=result.getError()%> </p>
        <%}%>
      

    </body>
</html>
