<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>登录</title>
  <link rel="stylesheet" type="text/css" href="css/public.css"/>
  <link rel="stylesheet" type="text/css" href="css/login.css"/>
</head>
<body><!-------------------login-------------------------->
<div class="login">
  <form class="loginFrom" action="/booktown/loginServlet" method="post"><h1><a href="index.jsp"><img src="images/logo.png"></a></h1>
    <p></p>
    <div class="msg-warn hide"><b></b>公共场所不建议自动登录，以防账号丢失</div>
    <p><input type="text" name="userName" value="" placeholder="昵称/邮箱/手机号"></p>
    <p><input type="text" name="passWord" value="" placeholder="密码"></p>
    <p><input type="submit" name="" value="登  录"></p>
    <p class="txt"><a class="" href="reg.jsp">免费注册</a><a href="forget.jsp">忘记密码？</a></p>
  </form>
</div>
</body>
</html>