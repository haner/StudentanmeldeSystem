<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page
	import="org.springframework.security.core.context.SecurityContextHolder"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<html>
<head>
<link rel="stylesheet" type="text/css" media="screen"
	href="resources/css/style.css" />
<title>Home</title>
</head>
<body>
	<div>
		<jsp:include page="../menu.jsp">
			<jsp:param name="username" value="${student.name}" />
			<jsp:param name="userId" value="${student.id}" />
		</jsp:include>
	</div>
	<div id="container">
		<div id="login">
			<form class="login-form" action="j_spring_security_check"
				method="post">
				<fieldset>
					<legend>Login Here</legend>

					<p>
						<label for="j_username">Username</label>: <input id="j_username"
							name="j_username" size="20" maxlength="50" type="text" />
					</p>

					<p>
						<label for="j_password">Password</label>: <input id="j_password"
							name="j_password" size="20" maxlength="50" type="password" />
					</p>

					<p>
						<input type="submit" value="Login" />
					</p>
				</fieldset>
			</form>
			<p class="message">${message}</p>
		</div>

		<div id="content">

			<p>
				Welcome to .....</span>
			</p>

			<table cellpadding="1">
				<colgroup>
					<col width="200" />
				</colgroup>
				<tr>
					<th align=left width="5%">No.</th>
					<th align=left width="20%">Fachbereich</th>
					<th align=left width="15%"></th>
				</tr>
				<c:choose>
					<c:when test="${fachbereich != null}">
						<c:forEach var="fach" items="${fachbereich}" varStatus="counter">
							<tr>
								<td align=left>${counter.index + 1}</td>
								<td align=left><a
							href="<c:url value="/singleFB?fbId=${fach.fachId}"/>">${fach.fachName}</a></td>
								<td align=left>${fach.dekan}</td>
							</tr>
						</c:forEach>
					</c:when>
				</c:choose>
			</table>
		</div>
	</div>
</body>
</html>