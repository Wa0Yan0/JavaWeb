<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2021/7/30
  Time: 16:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div id="page_nav">
    <a href="${requestScope.page.url}&pageNo=1">首页</a>
    <c:if test="${requestScope.page.pageNo > 1}">
        <a href="${requestScope.page.url}&pageNo=${requestScope.page.pageNo-1}">上一页</a>
    </c:if>

    <c:choose>
        <c:when test="${requestScope.page.pageTotal <= 5}">
            <c:set var="begin" value="1"></c:set>
            <c:set var="end" value="5"></c:set>
        </c:when>
        <c:when test="${requestScope.page.pageTotal > 5}">
            <c:choose>
                <c:when test="${requestScope.page.pageNo < 3}">
                    <c:set var="begin" value="1"></c:set>
                    <c:set var="end" value="5"></c:set>
                </c:when>
                <c:when test="${requestScope.page.pageNo > requestScope.page.pageTotal - 3 }">
                    <c:set var="begin" value="${requestScope.page.pageTotal - 4 }"></c:set>
                    <c:set var="end" value="${requestScope.page.pageTotal}"></c:set>
                </c:when>
                <c:otherwise>
                    <c:set var="begin" value="${requestScope.page.pageNo - 2}"></c:set>
                    <c:set var="end" value="${requestScope.page.pageNo + 2}"></c:set>
                </c:otherwise>
            </c:choose>
        </c:when>
    </c:choose>
    <c:forEach begin="${begin}" end="${end}" var="i">
        <c:if test="${ i == requestScope.page.pageNo }">
            【${i}】
        </c:if>
        <c:if test="${ i != requestScope.page.pageNo }">
            <a href="${requestScope.page.url}&pageNo=${i}">${i}</a>
        </c:if>
    </c:forEach>

    <c:if test="${requestScope.page.pageNo < requestScope.page.pageTotal}">
        <a href="${requestScope.page.url}&pageNo=${requestScope.page.pageNo+1}">下一页</a>
    </c:if>
    <a href="${requestScope.page.url}&pageNo=${requestScope.page.pageTotal}">末页</a>
    共${requestScope.page.pageTotal}页，${requestScope.page.pageTotalCount}条记录 到第<input name="pn" id="pn_input"/>页
    <input type="button" id="queryPage" value="确定">
</div>

<script type="text/javascript">
    $(function (){
        $("a.delete").click(function (){
            return confirm("是否要删除["+ $(this).parent().parent().find("td:first").text()+"]?");
        });
        $("#queryPage").click(function (){
            var pageNo = $("#pn_input").val();
            alert(pageNo);
            location.href = "${req.scheme}://${ req.serverName }:${req.serverPort}${req.contextPath}/manager/bookServlet?action=page&pageNo=" + pageNo;
        });
    });
</script>