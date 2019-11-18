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
                    <a href="productPresentation.htm" class="btn btn-success"><span class="glyphicon glyphicon-arrow-left" aria-hidden="true"></span></a>
                </h1>
            <div class="row" >
                <form:form method="post" commandName="productPresentation" style="width:80%;height: 80%" >
                    <form:errors path="*" element="div" cssClass="alert alert-danger"/>
                    <p>
                        <form:label path="presentation_code">Codigo</form:label>
                        <form:input  path="presentation_code" cssClass="form-control" />
                    </p>
                     <p>
                        <form:label path="presentation_name">Nombre de presentacion</form:label>
                        <form:input path="presentation_name" cssClass="form-control" />
                    </p> 
                    <p>                     
                        <form:label path="product_family_id">Familia de Producto</form:label>
                        <a href="addProductFamily.htm" class="btn btn-success" ><span class="glyphicon glyphicon-plus" aria-hidden="true" style="font-size:10pt;"></span></a>
                        <form:select path="product_family_id" cssClass="form-control">
                            <form:option value="0">Seleccione una Familia de productos</form:option>
                            <c:forEach items="${familyList}" var="family">
                                <form:option value="${family.id}">${family.name}</form:option>
                            </c:forEach>
                        </form:select>
                    </p>
                       <p>                     
                        <form:label path="product_brand_id">Marca de Producto</form:label>
                        <a href="addProductBrand.htm" class="btn btn-success" ><span class="glyphicon glyphicon-plus" aria-hidden="true" style="font-size:10pt;"></span></a>
                        <form:select path="product_brand_id" cssClass="form-control">
                            <form:option value="0">Seleccione una Marca de Producto</form:option>
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