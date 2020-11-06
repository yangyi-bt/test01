<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Author: yangyi
  Date: 2020/10/9
  Time: 21:14
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>update</title>
</head>
<body>
    <form action="/UserServlet" method="post" id="form" >
        <input type="hidden" name="method" value="update">
        <input type="hidden" name="user_id" value="${user.user_id}">
        <table border="1px" width="600px">
            <h1>修改信息</h1>
            <tr><td>账户编号</td><td>${user.user_num}</td></tr>
            <tr><td>姓名</td><td><input type="text" name="user_name" value="${user.user_name}"></td></tr>
            <tr><td>详细地址</td><td><input type="text" name="user_addr" value="${user.user_addr}"></td></tr>
            <tr><td>卡种</td>
                <td>
                    <select name="cards_id">
                        <c:forEach items="${cards}" var="card">
                            <option value="${card.card_id}"
                                    <c:if test="${card.card_id == user.cards_id}">
                                        selected="selected"
                                    </c:if>
                            >${card.card_name}
                            </option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
        </table>
        <input type="submit" value="修改">
        <input type="reset" value="重置">
    </form>
</body>
</html>
