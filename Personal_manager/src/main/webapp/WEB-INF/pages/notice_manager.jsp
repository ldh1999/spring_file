<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 6
  Date: 2020/12/31
  Time: 12:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<html>
<head>
    <title>notice_manager</title>
    <script src="https://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
    <script>
        $(function () {
            $("#btn").click(function () {
                $.ajax({
                        url:"notice_login",
                        contentType:"application/x-www-form-urlencoded",
                        dataType:"json",
                        type:"post",
                        data:$('#notice').serialize(),
                        success: function (data) {
                            if (data.state==400){
                                alert("添加成功");
                                history.back();
                            }
                            if(data.state==200){
                                alert("该编号已被注册");
                            }
                            if(data.state==250){
                                alert("不能有空值");
                            }
                        },
                        error:function () {
                            alert($('#salary').serialize());
                        }
                    }
                );
            });
        });

        $(function () {
            $("#btn_2").click(function () {
                $.ajax(
                    {
                        url:"notice_delete_login",
                        contentType:"application/x-www-form-urlencoded",
                        dataType:"json",
                        type:"post",
                        data:$('#notice_delete').serialize(),
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
                            alert($('#notice_delete').serialize());
                        }
                    }
                );
            });
        });

    </script>
</head>
<body>
    <form id="notice" action="" method="post">
        添加<br>
        <hr>
        编号：<input name="num" type="text"/><br>
        主题：<textarea name="subject" cols="40" rows="2"></textarea>
            <br>
        内容：<textarea name="word" cols="40" rows="6"></textarea><br>
    </form>
    <button id="btn">提交</button><hr><br><br><br><br><br>

    <span>所有公告预览</span><br><hr>
    <c:forEach items="${list}" var="item">
        编号：${item.num}<br>
        主题：${item.subject}<br>
        内容：<br>${item.word}<br>
        <hr>
    </c:forEach>
    <br><br><br><br><br>

    删除公告<br><hr>
    <form action="" id="notice_delete" method="post">
        <input type="text" name="num_delete"><br>
    </form>
    <button id="btn_2">确认删除</button>

</body>
</html>
