<%--
  Created by IntelliJ IDEA.
  User: Judit
  Date: 2020. 12. 01.
  Time: 12:50
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Autóink</title>
</head>
<body>
<c:if test="${!empty autok}">
    <table frame="border" rules="all">
        <tr>
            <th>Rendszám</th>
            <th>Márka</th>
            <th>Model</th>
            <th>Műszaki vizsga dátum</th>
            <th>Üzemanyag</th>
        </tr>
        <c:forEach items="${autok}" var="auto">
            <tr>
                <td>
                    <a href="${pageContext.servletContext.contextPath}/auto/${auto.rendszam}">
                        ${auto.rendszam}
                    </a>
                </td>
                <td>${auto.marka}</td>
                <td>${auto.model}</td>
                <td>${auto.muszakiVizsgaIdo}</td>
                <td>${auto.uzemanyag}</td>
            </tr>
        </c:forEach>
    </table>
</c:if>
<c:if test="${empty autok}">
    <c:out value="Nincs autónk!"/>
</c:if>
<br/>
<form action="${pageContext.servletContext.contextPath}/addAuto">
    <input type="submit" value="Autó hozzáadása">
</form>
<form action="${pageContext.servletContext.contextPath}/">
    <input type="submit" value="Kezdőoldal">
</form>

</body>
</html>
