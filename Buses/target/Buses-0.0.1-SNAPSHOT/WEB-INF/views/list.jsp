<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
 <html>
 <head>
 <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script>
$(document).ready(function() {
	$(".superbutton").click(function() {
		var id = $(this).attr('id');
		if("addButton" == id) {
			var str = $("#basket").attr('value');
			if(str.length == 6) {
				$("#basket").attr('value', str + "(1)");
			} else {
				var number = parseInt(str.substr(7, str.length - 8), 10);
				++number;
				$("#basket").attr('value', "Basket(" + number.toString() + ")");
			}
		}
	});
		
	$("#removeButton").click(function() {
		var str = $("#basket").text();
		if(str.length > 6) {
			var number = parseInt(str.substr(7, str.length - 8), 10);
			--number;
			if(number == 0) $("#basket").text("Basket");
			else $("#basket").text("Basket(" + number.toString() + ")");
		}
	});
	
	$("#basket").click(function(event) {
		$("#basket").attr('value', "Basket");
	});
});
</script>
 <style type="text/css">
 input.superbutton {
  font-weight: 700;
  color: white;
  text-decoration: none;
  padding: .8em 1em calc(.8em + 3px);
  border-radius: 3px;
  background: rgb(64,199,129);
  box-shadow: 0 -3px rgb(53,167,110) inset;
  transition: 0.2s;
  cursor: default;
  -webkit-user-select: none;
  -moz-user-select: none;
  -ms-user-select: none;
} 
input.superbutton:hover { background: rgb(53, 167, 110); }
input.superbutton:active {
  background: rgb(33,147,90);
  box-shadow: 0 3px rgb(33,147,90) inset;
}
img {width:200px;height: 150px; }
   .lefttab {padding-bottom: 12px; }
   .space{ padding-top: 40px;}
}
 </style>
 </head>
 <body>
 <table>
 <tr>
 <td align="left" class="lefttab">
   <c:if test="${!empty busList}">
		<table class="data">
			<tr>
				<th><spring:message code="label.name" /></th>
				<th><spring:message code="label.size" /></th>
				<th><spring:message code="label.season" /></th>
				<th><spring:message code="label.manuf" /></th>
				<th><spring:message code="label.price" /></th>
				<th>&nbsp;</th>
			</tr>
			<c:forEach items="${busList}" var="bus">
				<tr style="line-height: 150px;">
					<td>${bus.name}</td>
					<td>${bus.size}/${bus.proportion}R${bus.diameter}</td>
					<td>${bus.season}</td>
					<td>${bus.manufacturer}</td>
					<td>${bus.price}</td>
				
					<form:form method="post"
		action="${pageContext.request.contextPath}/basket/add/${bus.id}"
		commandName="basket">
				<td><input type="submit" id="addButton" class="superbutton" value="Add basket"></td>
					</form:form>
				</tr>
			</c:forEach>
			<form:form method="post"
		     action="${pageContext.request.contextPath}/basket/index"
		     commandName="basket">
		     <input type="submit" name="submit" value="Basket" id="basket" class="superbutton" />
           </form:form>
		 </table>
	 </c:if>
	</td>
	  <c:if test="${!empty imageList}">
        <td  align="center" class="space">
		 <table class="data">
			<tr>				
				<th><spring:message code="label.image" /></th>
				<th>&nbsp;</th>
			</tr>
			<c:forEach items="${imageList}" var="image">
				<tr>					
					<td><img src="<c:url value="/resources/images/${image.imageName}" />" width="200" height="200"/> </td>														
                </tr>	
			</c:forEach>
		 </table>
		</td>
	  </c:if>
	</tr>
</table>
</body>
</body>
</html>