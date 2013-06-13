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
	<jsp:include page="menu.jsp" />
	<h1 id="banner">Home</h1>
	<hr />

	<%-- <p>Welcome <span id="username"><%=SecurityContextHolder.getContext().getAuthentication().getName()%></span>!</p>
 --%>
	<table>
		<caption>Fachbereich</caption>
		<colgroup>
			<col width="300" />
		</colgroup>
		<tr>
			<th width="5%">No</th>
			<th width="5%">Fach ID</th>
			<th width="40%">Name</th>
			<th width="20%">Beschreibung</th>
			<th width="15%">Dekan</th>
		</tr>
		<c:choose>
			<c:when test="${fachbereich != null}">
				<c:forEach var="fach" items="${fachbereich}">
					<tr>
						<td>${counter.index + 1}</td>
						<td>${fach.fachId}</td>
						<td>${fach.fachName}</td>
						<td>${fach.beschreibung}</td>
						<td>${fach.dekan}</td>
					</tr>
				</c:forEach>
			</c:when>
		</c:choose>
	</table>

</body>
</html>