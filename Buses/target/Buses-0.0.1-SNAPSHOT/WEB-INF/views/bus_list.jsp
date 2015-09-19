<%@page import="org.springframework.web.filter.OncePerRequestFilter"%>
<%@page import="java.awt.Event"%>
<%@ page import="java.io.*,java.util.*" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
</head>
<body>
	<jsp:include flush="false"  page="menu.jsp"  />
  <form:form  name="act1" id="1" method="post"
		action="${pageContext.request.contextPath}/bus/find"
		commandName="findManuf">
    <table>
        <tr>
            <td><form:label path="manufacturer"><spring:message code="label.manufacturer"/></form:label></td>
        	<td><form:input path="manufacturer" rows="6" cols="30" /></td>
        </tr>
    </table>
      <input  name="form1"  type="submit" value="<spring:message code="label.go"/>"/>
  </form:form>
  
  <form:form  name="act2" id="2" method="post"
		action="${pageContext.request.contextPath}/bus/price"
		commandName="findPrice">
    <table>
        <tr>
            <td><form:label path="price"><spring:message code="label.price"/></form:label></td>
        	<td><form:input path="price" rows="6" cols="30" /></td>
        </tr>
    </table>
       <input name="form2" type="submit" value="<spring:message code="label.go"/> "/>   
   </form:form>
   
   <form:form  name="act3" id="3" method="post"
		action="${pageContext.request.contextPath}/bus/season"
		commandName="findSeason">
     <table>
         <tr>
            <td><form:label path="season"><spring:message code="label.season"/></form:label></td>
            <td>
              <form:select path="season">
            	<form:option value="0" label="Select" />
            	<form:options items="${season}" />
              </form:select>
            </td>
         </tr>
      </table>
   <input name="form3" type="submit" value="<spring:message code="label.go"/> "/>
     </form:form>

     <form:form  name="act4" id="4" method="post"
		action="${pageContext.request.contextPath}/bus/size"
		commandName="findSize">
    <table>
        <tr>
            <form:select path="size">
            	<form:option value="0" label="Select" />
            	<form:options items="${busList}" itemValue="size" itemLabel="size" />
            </form:select>
        </tr>
        <tr>
        /
         <form:select path="proportion">
            	<form:option value="0" label="Select" />
            	<form:options items="${busList}" itemValue="proportion" itemLabel="proportion" />
            </form:select>
        </tr>
        <tr>
        R
         <form:select path="diameter">
            	<form:option value="0" label="Select" />
            	<form:options items="${busList}" itemValue="diameter" itemLabel="diameter" />
            </form:select>
        </tr>
    </table>
     <input  name="form4"  type="submit" value="<spring:message code="label.go"/>"/>
     </form:form>
    <jsp:include page="list.jsp"></jsp:include>
</body>
</html>