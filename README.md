# front-end

<!-- index.html -->
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login Page</title>
</head>
<body>
    <div id="loginContainer">
        <h2>Login</h2>
        <form id="loginForm">
            <label for="username">Username:</label>
            <input type="text" id="username" name="username" required>

            <label for="password">Password:</label>
            <input type="password" id="password" name="password" required>

            <button type="button" id="loginButton">Login</button>
        </form>
    </div>

    <script src="app.js"></script>
</body>
</html>


// app.ts
document.addEventListener("DOMContentLoaded", () => {
    const loginButton = document.getElementById("loginButton");

    if (loginButton) {
        loginButton.addEventListener("click", () => {
            // 模拟登录验证，这里可以根据实际需求添加更多逻辑
            const usernameInput = document.getElementById("username") as HTMLInputElement;
            const passwordInput = document.getElementById("password") as HTMLInputElement;

            const username = usernameInput.value;
            const password = passwordInput.value;

            if (username === "user" && password === "password") {
                // 登录成功，跳转到另一个页面
                window.location.href = "dashboard.html";
            } else {
                alert("Invalid username or password. Please try again.");
            }
        });
    }
});
