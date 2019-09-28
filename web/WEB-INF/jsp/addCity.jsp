<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib  prefix = "form" uri = "http://www.springframework.org/tags/form"  %>  
<t:index>
    <jsp:body>
        <c:if test="${not empty mensaje}">
            <div class="alert alert-success" role="alert">
                <p>${mensaje}</p>
            </div>
        </c:if>
        <div class="container">
            <div class="row" >
                <h1>
                    Ingrese sus datos 
                    <a href="city.htm" class="btn btn-success"><span class="glyphicon glyphicon-arrow-left" aria-hidden="true"></span></a>
                </h1>             
                <form:form method="post" commandName="city" >
                    <form:errors path="*" element="div" cssClass="alert alert-danger"/>
                    <p>
                        <form:label path="code">Codigo</form:label>
                        <form:input  path="code" cssClass="form-control" />
                    </p>
                     <p>
                        <form:label path="description">Descripcion</form:label>
                        <form:input path="description" cssClass="form-control" />
                    </p> 
                    <p>
                        
                        <form:label path="departament_id">Departamento</form:label>
                        <a href="addDepartament.htm" class="btn btn-success" ><span class="glyphicon glyphicon-plus" aria-hidden="true" style="font-size:10pt;"></span></a>
                        <form:select path="departament_id" cssClass="form-control">
                            <form:option value="0">Seleccione un departamento</form:option>
                            <c:forEach items="${departamentList}" var="departament">
                                <form:option value="${departament.id}">${departament.description}</form:option>
                            </c:forEach>
                        </form:select>
                    </p>
                    <hr/>
                    <input type="submit" value="Enviar" class="form-control"/>
                </form:form>              
            </div>
        </div>
    </jsp:body>
</t:index>
       
  