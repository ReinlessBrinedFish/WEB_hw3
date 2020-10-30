<%--
  Created by IntelliJ IDEA.
  User: deLLL
  Date: 2020/10/29
  Time: 12:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html  PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"  "http://www.w3.org/TR/html4/loose.dtd">
<%
    Integer sum = (Integer) session.getAttribute("sum");
    if (sum==null) {
        sum = 0;
    }
%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>加法页面</title>
</head>
<body>
    <form action="doneServlet"  method="post">
        输入数a：<input type="text" name="a"/><br/>
        输入数b：<input type="text" name="b"/><br/>
        <input type="submit" value="提交"/><br/>
    </form>
    结果为：<input type="text" name="sum" value="<%=sum%>"/><br/>
    <a  href='logoutServlet'>注销</a>
</body>
</html>