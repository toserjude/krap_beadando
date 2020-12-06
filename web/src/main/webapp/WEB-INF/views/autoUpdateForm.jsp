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
    <title>Autó módosítása</title>
</head>
<body>
<form:form method="post" action="updateAuto" modelAttribute="auto">
    <table>
        <tr>
            <td><form:label path="marka">Márka</form:label></td>
            <td><form:input path="marka"/></td>
        </tr>
        <tr>
            <td><form:label path="model">Model</form:label></td>
            <td><form:input path="model"/></td>
        </tr>
        <tr>
            <td><form:label path="gyartasEve">Gyártás éve</form:label></td>
            <td><form:input path="gyartasEve"/></td>
        </tr>
        <tr>
            <td><form:label path="rendszam">Rendszám</form:label></td>
            <td><form:input path="rendszam"/></td>
        </tr>
        <tr>
            <td><form:label path="hengerurtartalom">Hengerűrtartalom</form:label></td>
            <td><form:input path="hengerurtartalom"/></td>
        </tr>
        <tr>
            <td><form:label path="tulajdonos">Tulajdonos neve</form:label></td>
            <td><form:input path="tulajdonos"/></td>
        </tr>
        <tr>
            <td><form:label path="muszakiVizsgaIdo">Műszaki vizsga</form:label></td>
            <td><form:input type="date" path="muszakiVizsgaIdo"/></td>
        </tr>
        <tr>
            <td><form:label path="uzemanyag">Üzemanyag</form:label></td>
            <td>
                <form:select path="uzemanyag">
                    <form:options items="${uzemanyag}"/>
                </form:select></td>
        </tr>
    </table>
    <input type="submit" value="Mentés"/>
</form:form>
<form action="${pageContext.servletContext.contextPath}/auto/${auto.rendszam}">
    <input type="submit" value="Vissza">
</form>
</body>
</html>
