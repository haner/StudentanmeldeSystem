<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page
	import="org.springframework.security.core.context.SecurityContextHolder"%>
<html>
<head>
<link rel="stylesheet" type="text/css" media="screen"
	href="resources/css/style.css" />
<title>Home</title>
</head>
<%-- <jsp:param name="homeUrl" value="studentHome" /> --%>
<!--      <c:import url="/menu"></c:import>
-->

<body>
	<jsp:include page="menu.jsp">
		<jsp:param name="username" value="${student.name}" />
	</jsp:include>
	<h1 id="banner">Student Information</h1>
	<hr />

	<p>
		<span id="username">${student.name} (${student.id})</span>
	</p>

	<p>
	<h2>
		SemesterNumber: <span id="SemesterNumber">${student.semesterNummber}</span>
	</h2>
	</p>

	<h2>Fachbereich:</h2>
	<table>
		<caption></caption>
		<colgroup>
			<col width="300" />
		</colgroup>
		<c:forEach var="fach" items="${student.fachbereich}">
			<tr>
				<td>${fach.fachName}</td>
			</tr>
		</c:forEach>
	</table>

	<p>
	<h2>
		Fachrichtung: ${student.fachrichtung}</span>
	</h2>
	</p>

	<h2>Besuchte Kurse</h2>
	<table>
		<caption></caption>
		<colgroup>
			<col width="300" />
		</colgroup>
		<c:forEach var="kurs" items="${student.kurse}">
			<tr>
				<td><a
					href="<c:url value="/singleCourse?courseId=${kurs.kursId}"/>">${kurs.title}</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>