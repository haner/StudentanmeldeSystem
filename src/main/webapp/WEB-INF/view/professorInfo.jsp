<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
		<jsp:param name="username" value="${professor.name}" />
		<jsp:param name="userId" value="${professor.id}" />
	</jsp:include>
	<h1 id="banner">Professor Information</h1>
	<hr />

	<p>
		<span id="username">${professor.name} (${professor.id})</span>
	</p>

	<table>
		<caption>
			<h2>Fachbereich</h2>
		</caption>
		<colgroup>
			<col width="300" />
		</colgroup>
		<c:forEach var="fach" items="${professor.fachbereich}">
			<tr>
				<td>${fach.fachName}</td>
			</tr>
		</c:forEach>
	</table>

	<table>
		<caption>
			<h2>Verantwortliche Kurse</h2>
		</caption>
		<colgroup>
			<col width="300" />
		</colgroup>
		<c:forEach var="kurs" items="${professor.kurse}">
			<tr>
				<td><a
					href="<c:url value="/singleCourse?courseId=${kurs.kursId}"/>">${kurs.title}</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>