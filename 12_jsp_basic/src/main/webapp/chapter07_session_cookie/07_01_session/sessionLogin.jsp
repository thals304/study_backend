<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>session 로그인</title>
<style>
body {
    font-family: Arial, sans-serif;
    display: flex;
    justify-content: center;
    align-items: center;
    height: 100vh;
    background-color: #f0f0f0;
}

.login-container {
    background: white;
    padding: 20px;
    border-radius: 5px;
    box-shadow: 0px 0px 10px 0px #00000030;
}

form {
    display: flex;
    flex-direction: column;
}

.form-control {
    margin-bottom: 10px;
}

form h2 {
    text-align: center;
}

input[type="text"], input[type="password"] {
    width: 90%;
    padding: 10px;
    margin: 5px 0;
    border: 1px solid #ddd;
    border-radius: 4px;
}

button {
    padding: 10px;
    border: none;
    border-radius: 4px;
    background-color: blue;
    color: white;
    cursor: pointer;
}

button:hover {
    background-color: darkblue;
}
</style>
</head>
<body>

	 <div class="login-container">
        <form action="sessionLogin" method="post">
            <h2>Login</h2>
            <div class="form-control">
                <label for="id">id</label>
                <input type="text" name="id" id="id" placeholder="Enter your id">
            </div>
            <div class="form-control">
                <label for="passwd">Password</label>
                <input type="password" name="passwd" id="passwd" placeholder="Enter your password">
            </div>
            <button type="submit">Login</button>
        </form>
    </div>

</body>
</html>