<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Resultado de formulario</h1>
        <ul>
            <li>Nombre:<c:out value="${nombre}"/></li>
            <li>E-Mail:<c:out value="${correo}"/></li>
            <li>Pais:<c:out value="${pais}"/></li>
        </ul>
            
    </body>
</html>
