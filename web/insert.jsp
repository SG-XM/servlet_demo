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
    <script src="https://code.jquery.com/jquery-3.1.1.min.js">

    </script>

    <title>Insert Without Preparement</title>
</head>
<body>
<form action="/insert">
    eid:<br>
    <input type="text" id="eid" name="eid" value="0002">
    <br>
    name:<br>
    <input type="text" id="name" name="name" value="lisi">
    <br>
    job:<br>
    <input type="text" id="job" name="job" value="doctor">
    <br>
    dno:<br>
    <input type="text" id="dno" name="dno" value="2">
    <br><br>
</form>
<button type="submit" id="insert">插入数据</button>

<script type="text/javascript">
    $(function () {
        $("#insert").click(function () {
            $.post("/insert", {
                eid:$("#eid").val(),
                name:$("#name").val(),
                job:$("#job").val(),
                dno:$("#dno").val()
            }, function (data) {
                eval("var res = " + data);
                if (res.code != 200) {
                    alert(res.msg)
                } else {
                    alert("无预处理插入成功");
                    window.location.href="/selectDN.jsp"
                }
            });

            return true;
        })
    })

</script>
</head>
</body>
</html>
