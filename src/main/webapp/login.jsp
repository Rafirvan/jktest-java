<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
    <link rel="stylesheet" type="text/css" href="styles/login.css">
    <script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
    <script>
        $(document).ready(function() {
            $("#loginForm").on("submit", function(event) {
                let isValid = true;
                const userID = $("#userID").val().trim();
                const password = $("#password").val().trim();

                if (userID === "" || password === "") {
                    alert("All fields are required.");
                    isValid = false;
                }
                return isValid;
            });
        });
    </script>
</head>
<body>
<h1>Login Page</h1>
<form id="loginForm" action="${pageContext.request.contextPath}/login" method="POST">
    <div>
        <label for="userID">User ID:</label>
        <input type="text" id="userID" name="userID">
    </div>
    <div>
        <label for="password">Password:</label>
        <input type="password" id="password" name="password">
    </div>
    <button type="submit">Login</button>
</form>

</body>
</html>
