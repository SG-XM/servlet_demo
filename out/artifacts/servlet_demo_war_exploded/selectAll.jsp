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
    <title>Select Name and Dno</title>
    <script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
    <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

<script type="text/javascript">
    $(function () {
        $("#button1").click(function () {
            window.location.href="/selectSearch.jsp"
        });
        $("#button").click(function () {
            $.post("/select", {
                type: "1",
                name: ""
            }, function (data) {
                eval("var res = " + data);

                if (res.code != 200) {
                    alert(res.msg)
                } else {
                    $("#tb").css("display","table")
                    var table = document.getElementById("tb");
                    for (var i = 0; i < res.res.length; i++) {
                        var row = table.insertRow(-1);
                        var cell1 = row.insertCell(0);
                        var cell2 = row.insertCell(1);
                        var cell3 = row.insertCell(2);
                        var cell4 = row.insertCell(3);
                        cell1.innerHTML = res.res[i].eid;
                        cell2.innerHTML = res.res[i].name;
                        cell3.innerHTML = res.res[i].job;
                        cell4.innerHTML = res.res[i].dno;
                    }



                    alert("成功");
                    //window.location.href="/selectAll.jsp"
                }
            });


        })
    })

</script>
</head>

<button id="button" type=button>查询全部信息</button>
<table class="table table-striped" id="tb" style="display: none;">
    <caption>查询结果</caption>
    <thead>
    <tr>
        <th>Eid</th>
        <th>Name</th>
        <th>Job</th>
        <th>Dno</th>

    </tr>
    </thead>
    <tbody>

    </tbody>
</table>
<button id="button1" type=button>下一步</button>
</body>
</html>
