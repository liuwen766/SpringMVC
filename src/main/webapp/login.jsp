<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form modelAttribute="account" action="/validator/login" method="post">
    姓名：<form:input path="name"/><from:errors path="name"></from:errors>
    <br/>
    密码：<form:input path="password"/><from:errors path="password">
</from:errors><br/>
    <input type="submit" value="登录"/>
</form:form>
</body>
</html>