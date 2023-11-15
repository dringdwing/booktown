<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>管理员登录页面</title>
    <link rel="icon" href="favicon.ico" type="image/ico">
    <link rel="stylesheet" href="../admincss/adminLogin.css">
</head>

<body>
<form action="/booktown/backstage/adminlogin">
    <canvas class="cavs" width="1575" height="1337"></canvas>
    <div class="loginmain">
        <div class="login-title">
            <span>管理员登录</span>
        </div>
        <div class="login-con">
            <div class="login-user">
                <div class="icon">
                    <img src="images/user_icon_copy.png" alt="">
                </div>
                <input type="text" name="userName" placeholder="用户名" autocomplete="off">
            </div>
            <div class="login-pwd">
                <div class="icon">
                    <img src="images/lock_icon_copy.png" alt="">
                </div>
                <input type="text" name="passWord" placeholder="密码" autocomplete="off">
            </div>
            <div class="login-btn">
                <input type="submit" value="登录">
            </div>
        </div>

    </div>
</form>
</body>

</html>

<script src="js/jquery-1.10.2.js"></script>
<script src="../admincss/adminLogin.js"></script>