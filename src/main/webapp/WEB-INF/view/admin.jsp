<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<link rel="stylesheet" type="text/css" media="screen" href="resources/css/style.css"/>
	<title>Admin</title>
</head>

<body>
	<jsp:include page="menu.jsp" >
	<jsp:param name="username" value= "${admin.name}"/>
	</jsp:include>
	<h1 id="banner">Home of Admin</h1>
	<hr/>
	
	<p>Only admins can see this page</p>
	<p>TODO: Add Informations to Admin and the special functional component for i.e. manage User.</p>
</body>
</html>