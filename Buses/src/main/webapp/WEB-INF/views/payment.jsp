<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
<script type="text/javascript">
function message(){
	alert("Thank you for your purchase!");
}
</script>
</head>
 <body>
	<jsp:include flush="false" page="menu.jsp" />
	<p>Buy</p>
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
				<tr>
					<td>${basket.name}</td>
					<td>${basket.size}/${basket.proportion}R${basket.diameter}</td>
					<td>${basket.season}</td>
					<td>${basket.manufacturer}</td>
					<td>${basket.price}</td>
				</tr>
		</table>
	</c:if>
	  <c:if test="${!empty imageList}">
        <td>
		 <table>
			<tr>				
				<th><spring:message code="label.image" /></th>
				<th>&nbsp;</th>
				<p>cool</p>
			</tr>
				<c:forEach items="${imageList}" var="image">
				<tr>					
					<td><img src="<c:url value="/resources/images/${image.imageName}" />" width="200" height="200"/> </td>														
                </tr>	
			</c:forEach>	
			
		 </table>
		</td>
	  </c:if>
	<form:form action="pdf" modelAttribute="factory">
	<c:if test="${!empty factoryList}">
    <table>
        <tr>
            <form:select path="name" >
            	<form:option value="0" label="Select" />
            	<form:options items="${factoryList}" itemValue="name" itemLabel="name" />
            </form:select>
        </tr>
        <tr>
         <form:select path="manager">
            	<form:option value="0" label="Select" />
            	<form:options items="${factoryList}" itemValue="manager" itemLabel="manager" />
            </form:select>
        </tr>
        <tr>
    </table>
     <input  type="submit" value="<spring:message code="label.buy"/>"/>
     </c:if>
     </form:form>
 </body>
</html>