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
    <title>人员管理</title>
    <script src="https://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js">
    </script>
    <script>
        $(function () {
            $("#btn").click(function () {
                $.ajax({
                        url:"person_manager_login",
                        contentType:"application/x-www-form-urlencoded",
                        dataType:"json",
                        type:"post",
                        data:$('#person').serialize(),//$('#person').serialize()      JSON.stringify($("#person").serialize())
                        success: function (data) {
                           // alert(data.state);
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
                            //alert($("#person").serialize());
                            alert("error");
                        }
                    }
                );
            });
        });


    </script>


</head>
<body>
<form id="person" method="post" action="">
    员工编号：<input type="text" name="num" required="required"><br>
    员工姓名：<input type="text" name="name"required="required"><br>
    性别：     <label><input type="radio" name="sex" value="man"  checked ="checked">男</label>
    <label><input type="radio" name="sex" value="woman">女</label><br>
    年龄：<input type="text" name="age"required="required"><br>
    职务：<input type="text" name="futy"required="required"><br>
    密码：<input type="text" name="password"required="required"><br>
    权限：
    <label><input type="radio" name="aut" value="manager" checked ="checked">管理员</label>
    <label><input type="radio" name="aut" value="person">普通员工</label><br>
    <!--<input type="submit"id="btn">-->
</form>
<button id="btn">提交</button>
</body>
</html>
