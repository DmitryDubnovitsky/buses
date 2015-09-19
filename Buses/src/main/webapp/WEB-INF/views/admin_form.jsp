<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <table>
        <tr>
            <td><form:label path="name"><spring:message code="label.name"/></form:label></td>
        <td><form:input  path="name" id="name"/></td>
        </tr>
        <tr>
            <td><form:label path="size"><spring:message code="label.size"/></form:label></td>
        <td><form:input path="size" /></td>
        </tr>
        <tr>
            <td><form:label path="proportion">Proportion</form:label></td>
        <td><form:input path="proportion" /></td>
        </tr>
        <tr>
            <td><form:label path="diameter">Diameter</form:label></td>
        <td><form:input path="diameter" /></td>
        </tr>
        <tr>
            <td><form:label path="season"><spring:message code="label.season"/></form:label></td>
        <td>
        <form:radiobutton path="season" value="winter" /><spring:message code="label.winter"/>
        <form:radiobutton path="season" value="summer" /><spring:message code="label.summer"/>
        </td>
        </tr>
        <tr>
            <td><form:label path="manufacturer"><spring:message code="label.manuf"/></form:label></td>
        <td>
        <form:input path="manufacturer" />
        </td>
        </tr>
        <tr>
            <td><form:label path="price"><spring:message code="label.price"/></form:label></td>
        <td><form:input path="price" /></td>
        </tr> 
        <tr>
            <td colspan="2">
                <input type="submit" value="<spring:message code="label.savebus"/>"/>
            </td>
        </tr>
    </table>
     
           