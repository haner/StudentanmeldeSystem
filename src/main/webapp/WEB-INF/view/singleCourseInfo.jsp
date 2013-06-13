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
		<jsp:param name="username" value="${student.name}" />
	</jsp:include>
	<h1 id="banner">Course</h1>
	<hr />

	<p>
		<span id="username">${kurs.title} (${kurs.abkuerzung})</span>
	</p>
	<table width="80%" border="1" cellspacing="0" cellpadding="5">
		<sec:authorize access="hasRole('ROLE_STUDENT')">
			<caption>
				<h2>Besuchte Kurse</h2>
			</caption>
		</sec:authorize>
		<sec:authorize access="hasRole('ROLE_PROFESSOR')">
		</sec:authorize>
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
			<c:when test="${kurs != null}">
				<tr>
					<td>${counter.index + 1}</td>
					<td>${kurs.kursId}</td>
					<td>${kurs.title}</td>
					<td>${kurs.abkuerzung}</td>
					<td>${kurs.leistungspunkte}</td>
					<td>${kurs.veranstaltungsform}</td>
					<td>${kurs.turnus}</td>
				</tr>
			</c:when>
		</c:choose>
	</table>

	</br>

	</br>
	<sec:authorize access="hasRole('ROLE_PROFESSOR')">
		<table width="80%" border="1" cellspacing="0" cellpadding="2">
			<caption>
				<h2>Besuchte Studenten</h2>
			</caption>
			<tr>
				<th>StudentId</th>
				<th>Student Name</th>
			</tr>
			<c:forEach var="student" items="${students}">
				<tr>
					<td>${student.id}</td>
					<td>${student.name}</td>
				</tr>
			</c:forEach>
		</table>
	</sec:authorize>

	<table width="80%" border="1" cellspacing="0" cellpadding="5">
		<caption>
			<h2>Dateien</h2>
		</caption>
		<tr>
			<th width="4%">No</th>
			<th width="30%">Filename</th>
			<th width="30%">Notes</th>
			<th width="16%">Type</th>
			<th width="20%">&nbsp;</th>
		</tr>
		<c:choose>
			<c:when test="${dateien != null}">
				<c:forEach var="datei" items="${dateien}" varStatus="counter">
					<tr>
						<td>${counter.index + 1}</td>
						<td>${datei.name}</td>
						<td>${datei.beschreibung}</td>
						<td>${datei.typ}</td>
						<td><div align="center">
								<a href="download?id=${datei.id}">Download</a>
								<sec:authorize access="hasRole('ROLE_PROFESSOR')">
								 / <a href="delete?fileId=${datei.id}">Delete</a>
								</sec:authorize>
							</div></td>
					</tr>
				</c:forEach>
			</c:when>
		</c:choose>
	</table>
	<p class="message">${message}</p>


	<sec:authorize access="hasRole('ROLE_PROFESSOR')">
		<form action="upload?courseId=${kursId}" method="post"
			enctype="multipart/form-data">
			<table width="60%" border="1" cellspacing="0">
				<caption>
					<h2>Neue Datei Hinzufügen</h2>
				</caption>
				<tr>
					<td width="35%"><strong>File to upload</strong></td>
					<%-- 				<tr>
				<td colspan="2" style="color: red;"><form:errors path="*"
						cssStyle="color : red;" /> ${errors}</td>
			    </tr> --%>
					<td width="65%"><input type="file" name="file" /></td>
				</tr>

				<tr>
					<td><strong>Notes</strong></td>
					<td><input type="text" name="notes" width="60" /></td>
				</tr>
				<tr>
					<td>&nbsp;</td>
					<td><input type="submit" name="submit" value="Add" /></td>
				</tr>
			</table>
		</form>
	</sec:authorize>
</body>
</html>