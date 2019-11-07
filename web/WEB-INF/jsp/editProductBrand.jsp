<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  prefix="form" uri="http://www.springframework.org/tags/form" %>
<t:index>
    <jsp:body>
        <div class="container">
            <h1>
                Ingrese sus datos 
                <a href="productBrand.htm" class="btn btn-success"><span class="glyphicon glyphicon-arrow-left" aria-hidden="true"></span></i></a>
            </h1>
            <div class="row">
                <form:form method="post" commandName="productBrand" style="width:80%;height: 80%">
                    <form:errors path="*" element="div" cssClass="alert alert-danger"/>
                    <p>
                        <form:label path="code">Codigo</form:label>
                        <form:input  path="code" cssClass="form-control" />
                    </p>
                    <p>
                        <form:label path="name">Nombre</form:label>
                        <form:input path="name" cssClass="form-control" />
                    </p> 
                    <hr/>
                    <input type="submit" value="Enviar" class="form-control"/>
                </form:form>
            </div>
        </div>
    </jsp:body>
</t:index>