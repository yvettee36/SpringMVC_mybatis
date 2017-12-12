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
    <title>修改商品信息</title>
</head>
<body>
<!-- 显示错误信息 -->
<c:if test="${allErrors!=null }">
    <c:forEach items="${allErrors }" var="error">
        ${error.defaultMessage}<br/>
    </c:forEach>
</c:if>

<form id="itemForm" action="/items/editItemsSubmit.action" method="post" enctype="multipart/form-data">
    <input type="hidden" name="id" value="${itemsCustom.id }"/>
    修改商品信息：
    <table width="100%" border=1>
        <tr>
            <td>商品名称</td>
            <td><input type="text" name="name" value="${itemsCustom.name }"/></td>
        </tr>
        <tr>
            <td>商品价格</td>
            <td><input type="text" name="price" value="${itemsCustom.price }"/></td>
        </tr>
        <tr>
            <td>商品生产日期</td>
            <td><input type="text" name="createtime"
                       value="<fmt:formatDate value="${itemsCustom.createtime}" pattern="yyyy-MM-dd HH:mm:ss"/>"/></td>
        </tr>
        <tr>
            <td>商品图片</td>
            <td>
                <c:if test="${itemsCustom.pic !=null}">
                    <img src="/img/${itemsCustom.pic}" width=100 height=100/>
                    <br/>
                </c:if>
                <input type="file" name="items_pic"/>
            </td>
        </tr>
        <tr>
            <td>商品简介</td>
            <td>
                <textarea rows="3" cols="30" name="detail">${itemsCustom.detail }</textarea>
            </td>
        </tr>
        <tr>
            <td colspan="2" align="center"><input type="submit" value="提交"/>
            </td>
        </tr>
    </table>
</form>

</body>
</html>