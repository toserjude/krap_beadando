<%--
  Created by IntelliJ IDEA.
  User: Judit
  Date: 2020. 12. 06.
  Time: 11:05
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>${auto.rendszam}</title>
</head>
<body>
<table>
    <tr>
        <td>Rendszám:</td><td>${auto.rendszam}</td>
    </tr>
    <tr>
        <td>Márka:</td><td>${auto.marka}</td>
    </tr>
    <tr>
        <td>Model:</td><td>${auto.model}</td>
    </tr>
    <tr>
        <td>Márka:</td><td>${auto.hengerurtartalom}</td>
    </tr>
    <tr>
        <td>Üzemanyag:</td><td>${auto.uzemanyag}</td>
    </tr>
    <tr>
        <td>Gyártás éve:</td><td>${auto.gyartasEve}</td>
    </tr>
    <tr>
        <td>Tulajdonos:</td><td>${auto.tulajdonos}</td>
    </tr>
    <tr>
        <td>Legutóbbi műszaki vizsga:</td><td>${auto.muszakiVizsgaIdo}</td>
    </tr>
</table>

<form action="${pageContext.servletContext.contextPath}/updateAuto/${auto.rendszam}">
    <input type="submit" value="Módosítás">
</form>
<form action="${pageContext.servletContext.contextPath}/deleteAuto/${auto.rendszam}">
    <input type="submit" value="Törlés">
</form>
<form action="${pageContext.servletContext.contextPath}/autok">
    <input type="submit" value="Vissza">
</form>
</body>
</html>
