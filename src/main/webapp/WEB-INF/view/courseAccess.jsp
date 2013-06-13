<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<html>
<head>
<link rel="stylesheet" type="text/css" media="screen"
	href="resources/css/style.css" />
<title>Course Access</title>
</head>

<body>
	<form class="login-form" action="courseAccess?courseId=${kursId}"
		method="post">
		<fieldset>
			<legend>Kennwort für den ausgewählten Kurs</legend>
			<p>
				<label for="course_password">Kennwort</label>: <input
					id="course_password" name="course_password" size="20"
					maxlength="50" type="password" />
			</p>

			<p>
				<input type="submit" value="Eingeben" />
			</p>
		</fieldset>
		<p class="message">${message}</p>
		<p>
			<a href="<c:url value="/courses"/>">Back to courses page.</a>
		</p>
	</form>
</body>
</html>