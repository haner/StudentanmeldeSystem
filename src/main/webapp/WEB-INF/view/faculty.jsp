<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<%@ page
	import="org.springframework.security.core.context.SecurityContextHolder"%>
<html>
<head>
<link rel="stylesheet" type="text/css" media="screen"
	href="resources/css/style.css" />
<title>Home</title>
</head>

<body>
	<jsp:include page="menu.jsp">
	<jsp:param name="username" value="Besucher" />
	</jsp:include>
	<h1 id="banner">Fachbereich: ${fachbereich.fachName}</h1>
	<hr />
	<table align=center border="1" cellspacing="0" cellpadding="5">
		<colgroup>
			<col width="300" />
		</colgroup>
		<tr align=center>
			<th width="5%">Fachbereich ID</th>
			<th width="30%">Beschreibung</th>
			<th width="16%">Dekan</th>
			<th width="20%">Prodekan</th>
		</tr>
		<c:choose>
			<c:when test="${fachbereich != null}">
				<tr align=center>
					<td>${fachbereich.fachId}</td>
					<td>${fachbereich.beschreibung}</td>
					<td>${fachbereich.dekan}</td>
					<td>${fachbereich.prodekan}</td>
				</tr>
			</c:when>
		</c:choose>
	</table>

	<table border="1" cellspacing="0" cellpadding="5">
			<caption>
				<h2>Kurse</h2>
			</caption>
		<colgroup>
			<col width="300" />
		</colgroup>
		<colgroup>
			<col width="300" />
		</colgroup>
		<tr>
			<th width="4%">No</th>
			<th width="50%">Kurs ID</th>
			<th width="30%">Kurs Name</th>
			<th width="30%">Abkürzung</th>
			<th width="16%">Leistungspunkte</th>
			<th width="20%">Veranstaltungsform</th>
			<th width="20%">Turnus</th>
		</tr>
		<c:choose>
			<c:when test="${kurse != null}">
				<c:forEach var="kurs" items="${kurse}" varStatus="counter">
					<tr>
						<td>${counter.index + 1}</td>
						<td>${kurs.kursId}</td>
						<td>${kurs.title}</a></td>
						<td>${kurs.abkuerzung}</td>
						<td>${kurs.leistungspunkte}</td>
						<td>${kurs.veranstaltungsform}</td>
						<td>${kurs.turnus}</td>
					</tr>
				</c:forEach>
			</c:when>
		</c:choose>
	</table>
</body>
</html>