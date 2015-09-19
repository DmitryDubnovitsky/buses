<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
     "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
    <div align="left">       
            <table border="0">
                <tr>
                    <td>Image:<input type="file" name="fileUpload" size="50"/></td>
                </tr>
                 <tr>
                    <td colspan="2" align="center"><input type="submit" value="Upload" /></td>
                </tr>
             </table>
    </div>
</body>
</html>