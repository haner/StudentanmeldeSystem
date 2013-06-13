<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page
	import="org.springframework.security.core.context.SecurityContextHolder"%>
<%@ page isELIgnored="false"%>

<!-- Using C:URL Tag in JSTL is to store a URL into variable
 -->
<c:url value="/" var="homeUrl" />
<c:url value="faculty" var="facultyUrl" />
<c:url value="studentHome" var="studentHome" />
<c:url value="professorHome" var="professorHome" />
<c:url value="user" var="userUrl" />
<c:url value="studentInfo" var="studentInfo" />
<c:url value="professorInfo" var="professorInfo" />
<c:url value="admin" var="adminUrl" />
<c:url value="courses" var="courseUrl" />
<c:url value="logout" var="logoutUrl" />

<div id="page-header">
	<div class="headermenu"></div>
	<div id="headerlogo">
		<img
			src="https://moodle.w-hs.de/theme/image.php/westfaelische_hs/theme/1370517111/westfaelische_hs/logo"
			alt="header image" border="0">
	</div>
</div>
<div class="menu">
	<ul>
		<%-- 	<sec:authorize access="hasRole('ROLE_STUDENT')">
			<li><a href="${studentHome}">Home</a></li>
			<li><a href="${studentInfo}">Student</a></li>
		</sec:authorize> --%>

		<sec:authorize ifAnyGranted="ROLE_ANONYMOUS">
			<li><a href="${homeUrl}">Home</a></li>
			<%-- 			<li><a href="${facultyUrl}">Fachbereich</a></li>
 --%>
		</sec:authorize>

		<sec:authorize access="hasRole('ROLE_STUDENT')">
			<li><a href="${studentHome}">Home</a></li>
			<li><a href="${studentInfo}">Student</a></li>
			<li><a href="${courseUrl}">Courses</a></li>
		</sec:authorize>

		<sec:authorize access="hasRole('ROLE_PROFESSOR')">
			<li><a href="${professorHome}">Home</a></li>
			<li><a href="${professorInfo}">Professor</a></li>
			<li><a href="${courseUrl}">Courses</a></li>
		</sec:authorize>

		<sec:authorize access="hasRole('ROLE_ADMIN')">
			<li><a href="${adminUrl}">Admin</a></li>
		</sec:authorize>

		<li><a href="${logoutUrl}">Logout</a></li>
	</ul>
	<span id="menu-username"><%=request.getParameter("username")%></span> <br
		style="clear: left" />
</div>