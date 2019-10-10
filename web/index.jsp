<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 2019/10/6
  Time: 18:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Create EMP</title>
</head>
<body>
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<script type="text/javascript">
    $(function () {
        $("#button").click(function () {
            $.post("/create", function (data) {
                eval("var res = " + data);
                if (res.code != 200) {
                    alert(res.msg)
                } else {
                    alert("成功");
                    window.location.href="/insertPre.jsp"
                }
            });

           // window.location.href="/selectSearch.jsp"
        })
    })
    $(function () {
        $("#button-d").click(function () {
            $.post("/delete", function (data) {
                eval("var res = " + data);
                if (res.code != 200) {
                    alert(res.msg)
                } else {
                    alert("成功");
                }
            });
        })
    })
</script>
</head>
<body>
<button id="button" type=button>创建Emp表</button>
<button id="button-d" type=button>删除Emp表</button>
</body>
</body>
</html>
