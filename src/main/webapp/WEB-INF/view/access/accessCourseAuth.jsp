<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<html>
<head>
<link rel="stylesheet" type="text/css" media="screen"
	href="resources/css/style.css" />
<title>Login</title>
</head>

<body>
	<h2>Bitte geben das Kennwort für den Kurs ein.</h2>

	<form:form method="POST" commandName="accessCourse"
		action="/accessCourse?courseId=${kursId}">
		<form:errors path="*" cssClass="errorblock" element="div" />
		<table>
			<tr>
				<td>Kennwort :</td>
				<td><form:password path="password" /></td>
				<td><form:errors path="password" cssClass="error" /></td>
			</tr>
			<tr>
				<td colspan="3"><input type="submit" /></td>
			</tr>
		</table>
	</form:form>
</body>
</html>