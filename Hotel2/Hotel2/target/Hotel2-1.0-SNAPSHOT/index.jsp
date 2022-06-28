
<%@ page import="com.example.hotel2.entities.Users" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Main page</title>
    <style>
        .header{
            display: flex;
            justify-content: flex-end;
            align-items: center;
            padding: 20px;
        }
        .header>*:not(:last-child){
            margin-right: 10px;
        }
        .btn{
            display: flex;
            justify-content: center;
            align-items: center;
            text-align: center;
            text-decoration: none;
            padding: 10px;
            background-color: #420101;
            border-radius: 3px;
            color: white;
        }
    </style>
</head>
<body>

<div class="header">
<% if(session.getAttribute("user") != null) { %>
    <p>Hello <%=session.getAttribute("user")%></p>
    <a class="btn" href="signout">Sign Out</a><br>
<% } else { %>
<a class="btn" href="signin">Sign In</a>
<a class="btn" href="register">Sign Up</a><br>
<% } %>
</div>
<div style = "text-align: center; margin: 50px auto; width: 500px">

    <% if(session.getAttribute("user") != null) { %>
        <h1 style = "display: inline-block; text-align: center; margin: 50px auto">You're signed in as <%=session.getAttribute("user")%>.</h1><br>
    <% } else { %>
        <p>You are not logged in!!!</p>
    <% } %>

</div>
</body>
</html>