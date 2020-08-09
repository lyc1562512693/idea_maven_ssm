<%--
  Created by IntelliJ IDEA.
  User: lyc
  Date: 2020/5/18
  Time: 23:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Item detail</title>
</head>
<body>
    <div>
        <%--<c:forEach items="${item}" var="it">
            <span>${it.itemId}</span><br>
            <span>${it.itemType}</span><br>
            <span>${it.itemName}</span><br>
            <span>${it.itemPrice}</span>
        </c:forEach>--%>
            <span>${item.itemName}</span><br>
    </div>
</body>
</html>
