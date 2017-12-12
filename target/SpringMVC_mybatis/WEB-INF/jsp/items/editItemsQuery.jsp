<%--
  Created by IntelliJ IDEA.
  User: yvettee
  Date: 2017/12/2
  Time: 15:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <title>查询商品列表</title>
    <script type="text/javascript">
        function editItemsAllSubmit() {
            //提交form
            document.itemsForm.action = "/items/editItemsAllSubmit.action";
            document.itemsForm.submit();
        }
        function queryItems() {
            //提交form
            document.itemsForm.action = "/items/queryItems.action";
            document.itemsForm.submit();
        }
    </script>
</head>
<body>
<form name="itemsForm" action="items/queryItems.action" method="post">
    查询条件：
    <table width="100%" border=1>
        <tr>
            <td>
                商品名称：<input name="itemsCustom.name"/>
            </td>
            <td><input type="button" value="查询" onclick="queryItems()"/>
                <input type="button" value="批量修改提交" onclick="editItemsAllSubmit()"/>
            </td>
        </tr>
    </table>
    商品列表：
    <table width="100%" border=1>
        <tr>
            <td>商品名称</td>
            <td>商品价格</td>
            <td>生产日期</td>
            <td>商品描述</td>
            <td>操作</td>
        </tr>
        <c:forEach items="${itemsList }" var="itemsList" varStatus="status">
            <tr>
                <td><input name="itemsList[${status.index }].name" value="${itemsList.name }"/></td>
                <td><input name="itemsList[${status.index }].price" value="${itemsList.price }"/></td>
                <td><input name="itemsList[${status.index }].createtime"
                           value="<fmt:formatDate value="${itemsList.createtime}" pattern="yyyy-MM-dd HH:mm:ss"/>"/></td>
                <td><input name="itemsList[${status.index }].detail" value="${itemsList.detail }"/></td>
            </tr>
        </c:forEach>
    </table>
</form>
</body>
</html>