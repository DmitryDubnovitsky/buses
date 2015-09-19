<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
<title>Admin</title>
<script class="jsbin" src="http://ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
<meta charset=utf-8 />
<style type="text/css">
	img {width:200px;height: 150px; }
   .lefttab {padding-bottom: 15px; }
   .space{ padding-top: 20px;}
   
</style>
</head>
<body>
	<jsp:include flush="false" page="menu.jsp" />
	<h2>Admin</h2>
	<form:form method="post"
		action="${pageContext.request.contextPath}/admin/add"
		commandName="bus">
		<jsp:include flush="true" page="admin_form.jsp">
			<jsp:param name="addbus" value="true" />
		</jsp:include>
		<jsp:useBean id="date" class="java.util.Date" />
<fmt:formatDate pattern="MM/dd/yyyy" value="${date}" var="currDate"/>
	</form:form>
	<form:form method="post"
		action="${pageContext.request.contextPath}/doUpload" enctype="multipart/form-data">
		<jsp:include flush="true" page="Upload.jsp">
			<jsp:param name="addbus" value="true" />
		</jsp:include>
	</form:form>
	<form:form method="post"
		action="${pageContext.request.contextPath}/admin" enctype="multipart/form-data">
		<jsp:include flush="true" page="Upload.jsp">
			<jsp:param name="addbus" value="true" />
		</jsp:include>
	</form:form>
	<form:form method="post"
		action="${pageContext.request.contextPath}/admin/addfact"
		commandName="factory">
		<jsp:include flush="true" page="factory_form.jsp">
			<jsp:param name="addfactory" value="true" />
		</jsp:include>
	</form:form>
	
	<table>
	 <tr>
<c:if test="${!empty busList}">
<td align="left" class="lefttab">
		<table class="data" >
			<tr>
				<th><spring:message code="label.name" /></th>
				<th><spring:message code="label.size" /></th>
				<th><spring:message code="label.season" /></th>
				<th><spring:message code="label.manuf" /></th>
				<th><spring:message code="label.price" /></th>
				<th><spring:message code="label.date" /></th>
				<th>&nbsp;</th>
			</tr>
			<c:forEach items="${busList}" var="bus">
				<tr style="line-height: 150px;">
					<td>${bus.name}</td>
					<td>${bus.size}</td>
					<td>${bus.size}/${bus.proportion}R${bus.diameter}</td>
					<td>${bus.manufacturer}</td>
					<td>${bus.price}</td>
					<td>${currDate}</td>
					<td><a
						href="${pageContext.request.contextPath}/admin/edit/${bus.id}"><spring:message
								code="label.edit" /></a></td>
					<td><a
						href="${pageContext.request.contextPath}/admin/delete/${bus.id}"><spring:message
								code="label.delete" /></a></td>
				</tr>
				
<tr>
			</c:forEach>
		</table>
		</td>
	</c:if>
     <c:if test="${!empty imageList}">
      <td  align="center" class="righttab">
		<table class="data">
			<tr>
				
				<th><spring:message code="label.image" /></th>
				<th>&nbsp;</th>
			</tr>
			<c:forEach items="${imageList}" var="image">
				<tr>					
					<td><img src="<c:url value="/resources/images/${image.imageName}" />" width="200" height="200"/> </td>														
<tr>	
			</c:forEach>
		</table>
	  </td>
	 </c:if>
   </tr>
	</table>
<c:if test="${!empty factoryList}">
<table>	
			<tr>
				<th><spring:message code="label.name" /></th>
				<th><spring:message code="label.manager" /></th>
				<th>&nbsp;</th>
			</tr>
			<c:forEach items="${factoryList}" var="factory">
				<tr style="line-height: 150px;">
					<td>${factory.name}</td>
					<td>${factory.manager}</td>
					<td><a
						href="${pageContext.request.contextPath}/factory/delete/${factory.id}"><spring:message
								code="label.delete" /></a></td>
				</tr>				
			</c:forEach>
</table>
		</c:if>
</body>
</html>