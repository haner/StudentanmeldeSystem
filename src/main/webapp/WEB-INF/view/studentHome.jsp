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
	<div>
		<jsp:include page="menu.jsp">
			<jsp:param name="username" value="${student.name}" />
			<jsp:param name="userId" value="${student.id}" />
		</jsp:include>
	</div>
	<h1 id="banner">Home of Student</h1>
	<hr />

	<p>
		Welcome <span id="username">${student.name} (${student.id})</span>
	</p>

	<table>
		<caption>
			<h2>Fachbereich</h2>
		</caption>
		<colgroup>
			<col width="300" />
		</colgroup>
		<c:forEach var="fach" items="${student.fachbereich}">
			<tr>
				<td>${fach.fachName}</td>
			</tr>
		</c:forEach>
	</table>

	<%-- <table>
		<caption>
			<h2>Besuchte Kurse</h2>
		</caption>
		<colgroup>
			<col width="300" />
		</colgroup>
		<c:forEach var="kurs" items="${student.kurse}">
			<tr>
				<td><a
					href="<c:url value="/singleCourse?courseId=${kurs.kursId}"/>">${kurs.title}</a></td>
			</tr>
		</c:forEach>
	</table> --%>
</body>
</html>