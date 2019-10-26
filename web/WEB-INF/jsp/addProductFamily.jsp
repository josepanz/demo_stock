<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib  prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:index>
    <jsp:body>
        <c:if test="${not empty mensaje}">
            <div class="alert alert-success" role="alert">
                <p>${mensaje}</p>
            </div>
        </c:if>
        <div class="container">
            <h1>
                Ingrese sus datos 
                <a href="productFamily.htm" class="btn btn-success"><span class="glyphicon glyphicon-arrow-left" aria-hidden="true"></span></a>
            </h1>
            <div class="row">
                <form:form method="post" commandName="productFamily" style="width:80%;height: 80%">
                    <form:errors path="*" element="div" cssClass="alert alert-danger"/>
                    <p>
                        <form:label path="code">Codigo</form:label>
                        <form:input  path="code" cssClass="form-control" />
                    </p>
                    <p>
                        <form:label path="description">Descripcion</form:label>
                        <form:input path="description" cssClass="form-control" />
                    </p> 
                    <hr/>
                    <input type="submit" value="Enviar" class="form-control"/>
                </form:form>
            </div>
        </div>
    </jsp:body>
</t:index>

