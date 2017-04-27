<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Wszyscy zawodnicy</title>
<link rel="stylesheet" type="text/css" href="styl.css">
</head>
<body>
	<h2>Wybierz kraj</h2>

	<form>
		<select name="kraj">
			<option value="">wszyscy</option>
			<option value="POL">Polska</option>
			<option value="GER">Niemcy</option>
			<option value="AUT">Austria</option>
			<option value="NOR">Norwegia</option>
			<option value="FIN">Finlandia</option>
			<option value="USA">Stany Zjednoczone</option>
		</select> <br> <input type="submit" value="Wybierz">
	</form>

	<c:choose>
		<c:when test="${not empty param.kraj}">
			<h2>Zawodnicy z kraju ${param.kraj}</h2>
		</c:when>
		<c:otherwise>
			<h2>Wszyscy zawodnicy</h2>
		</c:otherwise>
	</c:choose>

	<table>
		<tr>
			<th>ID</th>
			<th>Imię</th>
			<th>Nazwisko</th>
			<th>Kraj</th>
			<th>Data ur.</th>
			<th>Wzrost</th>
			<th>Waga</th>
		</tr>

		<c:forEach items="${zawodnicy}" var="z">
			<tr>
				<td>${z.idZadownika}</td>
				<td>${z.imie}</td>
				<td>${z.nazwisko}</td>
				<td>${z.kraj}</td>
				<td>${z.dataUrodzenia}</td>
				<td>${z.wzrost}cm</td>
				<td>${z.waga}kg</td>
			</tr>
		</c:forEach>

	</table>

</body>
</html>