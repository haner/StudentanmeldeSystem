<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page
	import="org.springframework.security.core.context.SecurityContextHolder"%>

<html>

<c:url value="target" var="targetURL" />

<head>
<!-- 
<script type="text/javascript" src="resources/js/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="resources/js/jquery.blockUI.js"></script>
<script type="text/javascript" src="resources/js/apprise-1.5.full.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$('#kennwortCheck').click(function() {
			$.blockUI({
				message : $('#loginForm')
			});
		});

		$('#yes').click(function() {
			// update the block message 
			$.blockUI({
				message : "<h1>Remote call in progress...</h1>"
			});

			$.ajax({
				url : 'wait.php',
				cache : false,
				complete : function() {
					// unblock when remote call returns 
					$.unblockUI();
				}
			});
		});

		$('#no').click(function() {
			$.unblockUI();
			return false;
		});
	});
</script>
<script>
	function tryit(string, args) {
		apprise(string, args, function(r) {
			if (r) {
				if (typeof (r) == 'string') {
					$('#returns').text(r);
				} else {
					$('#returns').text('True');
				}
			} else {
				$('#returns').text('False');
			}
		});
	}
</script>
 -->
<link rel="stylesheet" type="text/css" media="screen"
	href="resources/css/style.css" />
<link rel="stylesheet" type="text/css" media="screen"
	href="resources/css/apprise.min.css" />
<title>Home</title>
</head>

<body>
	<jsp:include page="menu.jsp">
		<jsp:param name="username" value="${student.name}" />
	</jsp:include>
	<h1 id="banner">Courses</h1>

	<table width="80%" border="1" cellspacing="0" cellpadding="5">
		<sec:authorize ifAnyGranted="ROLE_ANONYMOUS">
			<caption>
				<h2>Kurse</h2>
			</caption>
		</sec:authorize>
		<sec:authorize access="hasRole('ROLE_STUDENT')">
			<caption>
				<h2>Besuchte Kurse</h2>
			</caption>
		</sec:authorize>
		<sec:authorize access="hasRole('ROLE_PROFESSOR')">
			<caption>
				<h2>Verantwortliche Kurse</h2>
			</caption>
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
			<%-- 			<sec:authorize access="hasRole('ROLE_PROFESSOR')">
				<th width="20%">Kennwort</th>
			</sec:authorize> --%>
		</tr>
		<c:choose>
			<c:when test="${kurse != null}">
				<c:forEach var="kurs" items="${kurse}" varStatus="counter">
					<tr>
						<td>${counter.index + 1}</td>
						<td>${kurs.kursId}</td>
						<td><a
							href="<c:url value="/singleCourse?courseId=${kurs.kursId}"/>">${kurs.title}</a></td>
						<td>${kurs.abkuerzung}</td>
						<td>${kurs.leistungspunkte}</td>
						<td>${kurs.veranstaltungsform}</td>
						<td>${kurs.turnus}</td>
						<%-- 						<sec:authorize access="hasRole('ROLE_PROFESSOR')">
							<td>${kurs.kennwort}</td>
						</sec:authorize> --%>

					</tr>
				</c:forEach>
			</c:when>
		</c:choose>
	</table>

	<sec:authorize access="hasRole('ROLE_STUDENT')">
		<table width="80%" border="1" cellspacing="0" cellpadding="5">
			<caption>
				<h2>Verfügbare Kurse</h2>
			</caption>

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
				<%-- 			<sec:authorize access="hasRole('ROLE_PROFESSOR')">
				<th width="20%">Kennwort</th>
			</sec:authorize> --%>
			</tr>
			<c:choose>
				<c:when test="${verfuegbareKurse != null}">
					<c:forEach var="kurs" items="${verfuegbareKurse}"
						varStatus="counter">
						<tr>
							<td>${counter.index + 1}</td>
							<td>${kurs.kursId}</td>
							<td><a
								href="<c:url value="/singleCourse?courseId=${kurs.kursId}"/>">${kurs.title}</a></td>
							<td>${kurs.abkuerzung}</td>
							<td>${kurs.leistungspunkte}</td>
							<td>${kurs.veranstaltungsform}</td>
							<td>${kurs.turnus}</td>
						</tr>
					</c:forEach>
				</c:when>
			</c:choose>
		</table>
	</sec:authorize>

	<sec:authorize access="hasRole('ROLE_PROFESSOR')">
		<h2>Einfügen/Aktualisieren Course</h2>
		<form:form method="POST" name="newCourse" commandName="neuerKurs"
			action="newCourse">
			<table width="60%" border="1" cellspacing="0">
				<tr>
					<td width="35%"><form:label path="kursId">Kurs ID</form:label></td>
					<td width="65%"><form:input path="kursId" /></td>
				</tr>

				<tr>
					<td><form:label path="title">Kurs Titel</form:label></td>
					<td><form:input path="title" /></td>
				</tr>
				<tr>
					<td><form:label path="abkuerzung">Abkürzung</form:label></td>
					<td><form:input path="abkuerzung" /></td>
				</tr>
				<tr>
					<td><form:label path="leistungspunkte">Leistungspunkte</form:label></td>
					<td><form:input path="leistungspunkte" /></td>
				</tr>
				<tr>
					<td><form:label path="veranstaltungsform">Veranstaltungsform</form:label></td>
					<td><form:input path="veranstaltungsform" /></td>
				</tr>
				<tr>
					<td><form:label path="turnus">Turnus</form:label></td>
					<td><form:input path="turnus" /></td>
				</tr>
				<tr>
					<td><form:label path="kennwort">Kennwort</form:label></td>
					<td><form:input type="password" path="kennwort"
							showPassword="true" /></td>
				</tr>
				<tr>
					<td>&nbsp;</td>
					<td><input type="submit" name="submit" value="Bestätigen" /></td>
				</tr>
			</table>
		</form:form>

		<h2>Delete Course</h2>
		<form action="deleteCourse" method="post">
			<table width="60%" border="1" cellspacing="0">
				<tr>
					<td width="35%"><strong>Kurs ID: </strong></td>
					<td width="65%"><input id="couseId" type="text" name="couseId" /></td>
				</tr>
				<tr>
					<td>&nbsp;</td>
					<td><input type="submit" name="submit" value="Delete" /></td>
				</tr>
			</table>
		</form>
	</sec:authorize>

	<!-- 
	<div>
		Click these links to <input id="kennwortCheck" type="submit"
			value="Show Dialog" /> a popup window.
	</div>

	<div id="loginForm" style="display: none;">
		<p>
			<label>Bitte Kennwort eingeben:</label><input type="text"
				name="kennwortCheck">
		</p>
		<input type="button" id="yes" value="Bestätigen" /> <input
			type="button" id="no" value="Abbrechen" />
	</div>

	<div>
		<li onclick="tryit('Bitte Kennwort eingeben:', {'input':true});">apprise('What's
			your name?', {'input':true});</li>
	</div>
	<p>TODO: Add Informations to Student and his courses.</p> -->
</body>
</html>