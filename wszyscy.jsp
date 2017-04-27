<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Wszyscy zawodnicy</title>
<%-- Podpięcie stylu do stronki --%>
<link rel="stylesheet" type="text/css" href="styl.css">
</head>
<body>
	<h1>Wszyscy zawodnicy</h1>

	<%-- Uwaga, zostawimy niezamknięte połączenie, to nie jest dobre rozwiązanie "na produkcję" --%>

	<jsp:useBean id="dostep" class="model.DostepDoBazy" />

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
		<c:forEach items="${dostep.listaZawodnikow}" var="z">
			<tr>
				<td>${z.idZadownika}</td>
				<td>${z.imie}</td>
				<td>${z.nazwisko}</td>
				<td>${z.kraj}</td>
				<td>${z.dataUrodzenia}</td>
				<td>${z.wzrost}</td>
				<td>${z.waga}</td>
			</tr>
		</c:forEach>
	</table>


</body>
</html>