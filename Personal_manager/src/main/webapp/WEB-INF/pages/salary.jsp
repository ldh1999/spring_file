<%--
  Created by IntelliJ IDEA.
  User: 6
  Date: 2020/12/28
  Time: 20:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<html>
<head>
    <title>工资管理</title>
    <script src="https://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
    <script>
        $(function () {
            $("#btn").click(function () {
                $.ajax({
                    url:"person_salary_login",
                    contentType:"application/x-www-form-urlencoded",
                    dataType:"json",
                    type:"post",
                    data:$('#salary').serialize(),
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
                        history.back();
                    },
                    error:function () {
                        alert($('#salary').serialize());
                    }
                    }
                );
            });
        });


    </script>


</head>
<body>
    <form id="salary" method="post" action="">
        员工编号：<input type="text"name="num"oninput="value=value.replace(/[^\d]/g,'')"><br>
        基本工资：<input type="text"name="base"oninput="value=value.replace(/[^\d]/g,'')"><br>
        奖金：<input type="text"name="bonus"oninput="value=value.replace(/[^\d]/g,'')"><br>
        罚金：<input type="text"name="penalty"oninput="value=value.replace(/[^\d]/g,'')"><br>
    </form>
    <button id="btn">提交</button>
</body>
</html>
