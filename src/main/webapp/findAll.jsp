<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Author: yangyi
  Date: 2020/10/9
  Time: 19:02
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>findAll</title>
</head>
<body>
<form action="/UserServlet"  method="post" id="form">
    <input type="hidden" name="method" value="findAll">
    <input type="hidden" name="page" id="page">
    卡种分类
    <select name="cards_id">
        <option value="-1">全部</option>
            <c:forEach items="${cards}" var="card">
                <option value="${card.card_id}"
                    <c:if test="${card.card_id == user.cards_id}">
                        selected="selected"
                    </c:if>
                    >${card.card_name}
                </option>
            </c:forEach>
    </select>
    姓名：<input type="text" name="user_name" value="${user.user_name}">
    <input type="submit" value="查询">
    <a href="/insert.jsp">添加账户</a>
</form>
<table border="1px" width="600px">
    <tr>
    <td>账户编号</td><td>姓名</td><td>详细地址</td><td>开户日期</td>
    <td>卡种</td><td>删除</td><td>修改</td>
    </tr>
    <c:forEach items="${pageBean.list}" var="user">
        <tr>
        <td>${user.user_num}</td>
        <td>${user.user_name}</td>
        <td>${user.user_addr}</td>
        <td>${user.create_date}</td>
        <td>${user.card_name}</td>
        <td><a href="UserServlet?method=delete&user_id=${user.user_id}">删除</a></td>
        <td><a href="/UserServlet?method=findById&user_id=${user.user_id}">修改</a></td>
        </tr>
    </c:forEach>
</table>
<table  border="1px" width="600px">
    <tr>
        <td>
            <a href="javascript:changePage(1)">首页</a>
            <a href="javascript:changePage(${pageBean.currentPage - 1})">上一页</a>
            <a href="javascript:changePage(${pageBean.currentPage + 1})">下一页</a>
            <a href="javascript:changePage(${pageBean.totalPage})">末页</a>
            ${pageBean.currentPage}/${pageBean.totalPage}页
            <input type="text" id="selectPage" value="${pageBean.currentPage}">
            <input type="button" value="GO" id="go">
        </td>
    </tr>
</table>
<script>
    function changePage(no){
        document.getElementById("page").value=no;
        document.getElementById("form").submit();
    }
    document.getElementById("go").onclick = function(){
        document.getElementById("page").value=document.getElementById("selectPage").value;
        document.getElementById("form").submit();
    }
</script>
</body>
</html>
