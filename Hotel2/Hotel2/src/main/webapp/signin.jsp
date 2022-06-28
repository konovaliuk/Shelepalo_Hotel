<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Sign in</title>
</head>
<body>
<main>
    <a href="/Hotel2_war/">Go back</a>
    <div style="width: 500px; margin: 0 auto; text-align: center;">
        <h1 style="margin: 50px auto;">Sign in</h1>
        <form style="text-align: left;" action="" method="POST">
            <%String message = (String) request.getAttribute("message");
                if (message == null) {
                    message="";
                }%>
            Username: <br>
            <input type="text" style="width: 500px;" name="email"/> <br><br>
            Password: <br>
            <input type="password" style="width: 500px;" name="password"/> <br>
            <p  style="color: red; font-size: 14px">
                <%=message%>
            </p>
            <input type="submit" class="form-submit-button" value="Submit"/>
        </form><br><br>
        <p><a href="register">Register new account.</a></p>
    </div>
</main>
</body>
</html>
