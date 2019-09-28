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
            <div class="row">
                <h1>
                    Ingrese sus datos 
                    <a href="departament.htm" class="btn btn-success"><span class="glyphicon glyphicon-arrow-left" aria-hidden="true"></span></a>
                </h1>                   
                <form:form method="post" commandName="departament" >
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
                        <a href="addCountry.htm" class="btn btn-success" ><span class="glyphicon glyphicon-plus" aria-hidden="true" style="font-size:10pt;"></span></a>
                        <form:label path="country_id">Pais</form:label>
                        <form:select path="country_id" cssClass="form-control">
                            <form:option value="0">Seleccione un pais</form:option>
                            <c:forEach items="${countryList}" var="country">
                                <form:option value="${country.id}">${country.description}</form:option>
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
 
      
 