<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 6
  Date: 2020/12/27
  Time: 21:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<html>
<head>
    <title>Person_main</title>
</head>
<body>
    编号：${person.num}<br>
    姓名：${person.name}<br>
    <hr>
    工资<br>
    基本工资：${salary.base}<br>
    奖金：${salary.bonus}<br>
    罚金：${salary.penalty}<br>
    总和：${salary.sum}<br>
    <hr><br><br><br><br>
    近日公告<hr>
    <c:forEach items="${list}" var="item">
        编号：${item.num}<br>
        主题：${item.subject}<br>
        内容：<br>${item.word}<br>
        <hr>
    </c:forEach>
</body>
</html>
