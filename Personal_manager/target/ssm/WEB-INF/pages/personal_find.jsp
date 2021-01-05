<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 6
  Date: 2020/12/28
  Time: 20:17
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<html>
<head>
    <title>人员查找</title>
    <script src="https://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
    <script>
        $(function () {
            $("#btn").click(function () {
                $.ajax(
                    {
                        url:"person_delete_login",
                        contentType:"application/x-www-form-urlencoded",
                        dataType:"json",
                        type:"post",
                        data:$('#person_delete').serialize(),
                        success: function (data) {
                            if (data.state==400){
                                alert("删除成功");
                                history.back();
                            }
                            if(data.state==100){
                                alert("编号输入错误");
                            }
                            if(data.state==250){
                                alert("不能有空值");
                            }
                        },
                        error:function () {
                            alert($('#person_delete').serialize());
                        }
                    }
                );
            });
        });

    </script>
</head>
<body>
    删除员工<br><hr>
    <form id="person_delete" method="post" action="">
        员工编号：<input name="num_delete" type="text">
    </form>
    <button id="btn">确定删除</button>
    <br><br><br><br><br>
    <hr>
    <span>全部员工</span><br>
    <hr>
    <c:forEach items="${list}" var="item">
        员工编号：${item.num}<br>
        员工姓名：${item.name}<br>
        性别：${item.sex}<br>
        职务：${item.futy}<br>
        权限：${item.aut}<br>
        <hr>
    </c:forEach>

</body>
</html>
