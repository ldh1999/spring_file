<%--
  Created by IntelliJ IDEA.
  User: 6
  Date: 2020/12/27
  Time: 15:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<html>
<head>
    <title>登录</title>
    <script src="js/jquery.min.js"></script>
    <script>
        $(function () {
            $("#ok").click(function () {
                $.ajax({
                    url:"enroll/first",
                    contentType:"application/x-www-form-urlencoded",
                    dataType:"json",
                    type:"post",
                    data:$('#Enroll').serialize(),
                    success:function (data) {
                        if(data.state=="100"){
                            alert("查无此人");
                        }else if(data.state=="150"){
                            alert("密码错误");
                        }else{
                            if (data.decision=="manager")
                                window.location.href ="manager_/main?uid="+data.uid;
                            else
                                window.location.href ="person/main?uid="+data.uid;
                        }
                    },
                    error:function () {
                        alert("error");
                      // window.location.href('enroll/person_main');//localhost:8080/WEB-INF/pages/person_main.jsp
                    }
                    }
                );
            });
        });
    </script>
</head>
<body>
    <span>人事管理系统</span>
    <form id= "Enroll"method="post" action="enroll/first">
        username:<input type="text" name="username"><br>
        password:<input type="text" name="password"><br>
        <label><input type="radio" name="aut" value="manager"  checked ="checked">管理员</label>
        <label><input type="radio" name="aut" value="person">员工</label><br>

    </form>
    <button id="ok">提交</button>

</body>
</html>
