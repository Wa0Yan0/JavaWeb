<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
<meta charset="UTF-8">
<title>图书管理</title>
	<%@ include file="/pages/common/header.jsp"%>
</head>
<body>
	
	<div id="header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
			<span class="wel_word">图书管理系统</span>
			<div>
				<a href="manager/bookServlet?action=page">图书管理</a>
				<a href="pages/manager/order_manager.jsp">订单管理</a>
				<a href="index.jsp">返回商城</a>
			</div>
	</div>
	
	<div id="main">
		<table>
			<tr>
				<td>名称</td>
				<td>价格</td>
				<td>作者</td>
				<td>销量</td>
				<td>库存</td>
				<td colspan="2">操作</td>
			</tr>
			<c:forEach items="${requestScope.page.items}" var="item">
				<tr>
					<td>${item.name}</td>
					<td>${item.price}</td>
					<td>${item.author}</td>
					<td>${item.sales}</td>
					<td>${item.stock}</td>
					<td><a href="manager/bookServlet?action=getBook&id=${item.id}&pageTotal=${requestScope.page.pageNo}">修改</a></td>
					<td><a href="manager/bookServlet?action=delete&id=${item.id}&pageNo=${requestScope.page.pageNo}" class="delete">删除</a></td>
				</tr>
			</c:forEach>

			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td><a href="pages/manager/book_edit.jsp?pageTotal=${requestScope.page.pageTotal}&count=${requestScope.page.items.size()}">添加图书</a></td>
			</tr>	
		</table>

		<%@include file="/pages/common/page.jsp"%>

	</div>

	<%@ include file="/pages/common/footer.jsp"%>
</body>
</html>

