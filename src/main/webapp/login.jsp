<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+
            request.getServerPort()+request.getContextPath()+"/";
%>

<meta http-equiv=“Content-Type” content=“text/html; charset=UTF-8″>
<html>
<body>
<h2>Hello World!</h2>
    <form action="<%=basePath %>login.action">
        用户名：<input type="text" name="username" id="uname" /> <br>
        密  码：<input  type="text" name="password" id="upass" /> <br>
        <button type="submit">登录</button>
    </form>

</body>
</html>
