<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Edit</title>
</head>
<body>
	<jsp:include flush="false" page="menu.jsp" />
	<h2>Edit '${bus.price}' </h2>
	<form:form method="post"
		action="${pageContext.request.contextPath}/admin/save"
		commandName="bus">
		<form:hidden path="id" />
		<jsp:include flush="true" page="admin_form.jsp" />
	</form:form>
	<a href="${pageContext.request.contextPath}/admin/index"
		title="Bus List">Bus List</a>
</body>
</html>