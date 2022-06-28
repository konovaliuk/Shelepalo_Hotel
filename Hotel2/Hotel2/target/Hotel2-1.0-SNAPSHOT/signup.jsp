<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Sign up</title>
</head>
<body>
<main>
    <a href="/Hotel2_war/">Go back</a>
    <div style="width: 200px; margin: 0 auto; text-align: center;">
        <h1 style="margin: 50px auto;">Sign up</h1>
        <form style="text-align: left;" action="" method="POST">
            <%String message = (String) request.getAttribute("message");
                if (message == null) {
                    message="";
                }%>
            Username: <br>
            <input type="text" style="width: 200px;" name="email"/> <br><br>
            Password: <br>
            <input type="password" style="width: 200px;" name="password"/> <br>
            name: <br>
            <input type="text" style="width: 200px;" name="name"/> <br><br>
            surname: <br>
            <input type="text" style="width: 200px;" name="surname"/> <br>
            
            <p  style="color: red; font-size: 14px">
                <%=message%>
            </p>
            <input type="submit" class="form-submit-button" value="Submit"/>
        </form><br><br>
        <p>Already registered? <a href="signin">Sign In</a></p>
    </div>
</main>
</body>
</html>
