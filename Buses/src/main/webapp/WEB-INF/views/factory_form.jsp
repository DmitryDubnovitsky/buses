<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <table>
        <tr>
            <td><form:label path="name"><spring:message code="label.factory"/></form:label></td>
        <td><form:input  path="name" id="name"/></td>
        </tr>
        <tr>
            <td><form:label path="manager"><spring:message code="label.manager"/></form:label></td>
        <td><form:input path="manager" /></td>
        </tr>
   <tr>
            <td colspan="2">
                <input type="submit" value="<spring:message code="label.savefactory"/>"/>
            </td>
        </tr>
    </table>     