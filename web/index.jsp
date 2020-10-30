<%--
  Created by IntelliJ IDEA.
  User: wzl
  Date: 2020/10/11
  Time: 8:17 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html  PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"  "http://www.w3.org/TR/html4/loose.dtd">
<%
    String name, password;
    name = (String)session.getAttribute("name");
    password = (String)session.getAttribute("password");
    if (name == null) {
        name="";
    }
    if (password==null) {
        password="";
    }
%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>登陆页面</title>
</head>
<body>
<form action="loginServlet"  method="post">
    用户名:<label><input type="text" name="name"  value="<%=name %>"/></label><br>
    密码: <label><input type="password" name="password" value="<%=password%>"/></label><br>
    <input type="submit" value="提交"/>&nbsp<br>
</form>
</body>
</html>
