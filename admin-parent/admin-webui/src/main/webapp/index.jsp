<%--
  Created by IntelliJ IDEA.
  User: 青衫
  Date: 2022/10/9
  Time: 15:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>首页</title>
    <base href="http://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}/">
    <script type="text/javascript" src="jquery/jquery-2.1.1.min.js"></script>
    <script type="text/javascript">
        $(function () {

            $("#btn02").click(function () {
                $.ajax({
                    url: 'send/array/two.html',
                    type: 'post',
                    data: {                   // 请求参数
                        array: [5, 2, 18]
                    },
                    // 服务器返回数据类型
                    dataType: 'text',

                    // 请求成功
                    success: function (response) {
                        console.log(response)
                    },
                    //     请求失败
                    error: function (response) {
                        console.log(response);
                    }
                });
            })


            $("#btn01").click(function () {
                $.ajax({
                    url: 'send/array/one.html',
                    type: 'post',
                    data: {                   // 请求参数
                        array: [5, 2, 18]
                    },
                    // 服务器返回数据类型
                    dataType: 'text',

                    // 请求成功
                    success: function (response) {
                        console.log(response)
                    },
                    //     请求失败
                    error: function (response) {
                        console.log(response);
                    }
                });
            })
        })
    </script>
</head>
<body>

<a href="test/ssm.html">测试SSM整合环境</a><br>
<button id="btn01">Send [5,2,18] One</button>
<br>
<button id="btn02">Send [5,2,18] Two</button>

</body>
</html>
