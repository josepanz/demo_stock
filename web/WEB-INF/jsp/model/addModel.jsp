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
        <div class="container" >
            <h1>
                    Ingrese sus datos 
                    <a href="model.htm" class="btn btn-success"><span class="glyphicon glyphicon-arrow-left" aria-hidden="true"></span></a>
                </h1>
            <div class="row" >
                <form:form method="post" commandName="model" style="width:80%;height: 80%" >
                    <form:errors path="*" element="div" cssClass="alert alert-danger"/>
                    <p>
                        <form:label path="description">Codigo</form:label>
                        <form:input path="descripcion" cssClass="form-control" />
                    </p>
                    <p>
                        
                        <form:label path="brand_id">Marca</form:label>
                        <a href="addProductBrand.htm" class="btn btn-success" ><span class="glyphicon glyphicon-plus" aria-hidden="true" style="font-size:10pt;"></span></a>
                        <form:select path="brand_id" cssClass="form-control">
                            <form:option value="0">Seleccione una marca</form:option>
                            <c:forEach items="${brandList}" var="brand">
                                <form:option value="${brand.id}">${brand.name}</form:option>
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
       
  