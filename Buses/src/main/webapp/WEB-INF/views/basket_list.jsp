<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
</head>
<body>
	<jsp:include flush="false" page="menu.jsp" />
		<spring:message code="label.buses" />
	<c:if test="${!empty basketList}">
		<table class="data">
			<tr>
				<th><spring:message code="label.name" /></th>
				<th><spring:message code="label.size" /></th>
				<th><spring:message code="label.season" /></th>
				<th><spring:message code="label.manuf" /></th>
				<th><spring:message code="label.price" /></th>
				<th>&nbsp;</th>
			</tr>
			<c:forEach items="${basketList}" var="bus">
				<tr>
					<td>${bus.name}</td>
					<td>${bus.size}/${bus.proportion}R${bus.diameter}</td>
					<td>${bus.season}</td>
					<td>${bus.manufacturer}</td>
					<td>${bus.price}</td>
					<td><a
						href="${pageContext.request.contextPath}/basket/payment/${bus.id}">Buy</a></td>
					<td><a
						href="${pageContext.request.contextPath}/basket/delete/${bus.id}"><spring:message
								code="label.delete" /></a></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>	
	
</body>
</html>