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
    <script type="text/javascript" src="layer/layer.js"></script>
    <script type="text/javascript">
        $(function () {

            var object = {
                stuId: 1,
                stuName: "王德法",
                address: {
                    province: '广东',
                    city: '深圳',
                    street: '玉树临风街'
                },
                subjects: [
                    {
                        subjectName: 'javaee',
                        subjectScore: '100'
                    },
                    {
                        subjectName: 'mysql',
                        subjectScore: '99'
                    },
                ],
                map: {
                    k1: 'v1',
                    k2: 'v2'
                }
            }

            var requestBodyObj = JSON.stringify(object);

            $("#btn04").click(function () {
                $.ajax({
                    url: "send/array/object.json",
                    type: 'post',
                    data: requestBodyObj,
                    contentType: "application/json;charset=UTF-8",
                    dataType: 'json',
                    success: function (response) {
                        console.log(response)
                    },
                    //     请求失败
                    error: function (response) {
                        console.log(response);
                    }
                })
            })


            // 准备好发送的数组
            var array = [5, 2, 18];
            // 将json数组转为 json 字符串
            var requestBody = JSON.stringify(array);
            console.log(requestBody)

            $("#btn03").click(function () {
                $.ajax({
                    url: 'send/array/three.html',
                    type: 'post',
                    data: requestBody, //请求体
                    contentType: "application/json;charset=UTF-8", // 设置请求体内容类型
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
            });

            $("#btn05").click(function () {
                layer.msg("layer")
            });


        })
    </script>
</head>
<body>

<a href="test/ssm.html">测试SSM整合环境</a><br>
<button id="btn01">Send [5,2,18] One</button>
<br>
<button id="btn02">Send [5,2,18] Two</button>
<br>
<button id="btn03">Send [5,2,18] Three</button>
<br>
<button id="btn04">Send Object</button>
<br>
<button id="btn05">Send layer</button>


</body>
</html>
