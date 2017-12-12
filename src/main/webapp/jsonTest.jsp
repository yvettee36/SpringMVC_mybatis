<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>json交互测试</title>
    <script type="text/javascript" src="/js/jquery-1.9.0.min.js"></script>
    <script type="text/javascript">
        //请求json，输出是json
        function requestJson() {
            $.ajax({
                type: 'post',
                url: '/requestJson.action',
                contentType: 'application/json;charset=utf-8',
                //数据格式是json串，商品信息
                data: '{"name":"手机","price":999}',
                success: function (data) {//返回json结果
                    alert(data);
                }
            });
        }

        //请求key/value，输出是json
        function responseJson() {
            $.ajax({
                type: 'post',
                url: '/responseJson.action',
                //请求是key/value这里不需要指定contentType，因为默认就 是key/value类型
                //contentType:'application/json;charset=utf-8',
                //数据格式是json串，商品信息
                data: 'name=手机&price=999',
                success: function (data) {//返回json结果
                    alert(data.name);
                }
            });
        }
    </script>
</head>
<body>
<input type="button" onclick="requestJson()" value="请求json，输出是json"/>
<input type="button" onclick="responseJson()" value="请求key/value，输出是json"/>
</body>
</html>
