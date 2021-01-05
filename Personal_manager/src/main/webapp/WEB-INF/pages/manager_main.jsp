<%--
  Created by IntelliJ IDEA.
  User: 6
  Date: 2020/12/28
  Time: 17:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>manager_main</title>
</head>
<body>
    <span>管理员姓名：${manager.name}</span><br>
    <span>管理员编号：${manager.num}</span><br>
    <a href="salary">工资管理</a><br>
    <a href="personal_manager">人员添加</a><br>
    <a href="find_all">员工查找</a><br>
    <a href="notice">公告管理</a><br>

</body>
</html>
