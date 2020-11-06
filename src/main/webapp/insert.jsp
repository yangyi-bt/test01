<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Author: yangyi
  Date: 2020/10/10
  Time: 10:23
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>insert</title>
</head>
<body>
    <h1>添加信息</h1>
    <form action="/UserServlet" method="post">
        <input type="hidden" name="method" value="insert">
        <table>
            <tr><td>账户编号</td><td><input type="text" name="user_num"></td></tr>
            <tr><td>姓名</td><td><input type="text" name="user_name"></td></tr>
            <tr><td>详细地址</td><td><input type="text" name="user_addr"></td></tr>
            <tr><td>卡种</td>
                <td>
                    <select name="cards_id">
                        <option>请选择</option>
                        <c:forEach items="${cards}" var="card">
                            <option value="${card.card_id}">${card.card_name}
                            </option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
        </table>
        <input type="submit" value="添加">
        <input type="reset" value="重置">
    </form>
</body>
</html>
