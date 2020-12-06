<%--
  Created by IntelliJ IDEA.
  User: Judit
  Date: 2020. 12. 06.
  Time: 22:52
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Autó törlése</title>
</head>
<body>
<form:form method="post" action="${auto.rendszam}" modelAttribute="auto">
    <h2>Biztosan törölni akarod a(z) ${auto.rendszam} rendszámú autót?</h2>
    <br/>
    <input type="submit" value="Törlés"/>
</form:form>
<form action="${pageContext.servletContext.contextPath}/auto/${auto.rendszam}">
    <input type="submit" value="Vissza">
</form>
</body>
</html>
