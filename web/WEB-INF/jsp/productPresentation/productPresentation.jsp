<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:index>
    <jsp:body>
        <h1>Presentacion de Productos</h1>        
        <div class="container">
            <div class="row">
                <p>
                    <a href="addProductPresentation.htm" class="btn btn-success"><span class="glyphicon glyphicon-plus" aria-hidden="true"></span></i>Agregar</a>
                </p>
                <table class="table table-bordered table-striped table-hover">
                    <thead>
                    <th>Id</th>
                    <th>Código</th>
                    <th>Nombre</th>
                    <th>Familia</th>
                    <th>Marca</th>
                    <th>Producto</th>
                    <th>Fecha Creacion</th>
                    <th>Disponible</th>
                    <th>Codigo Barra</th>
                    <th>Costo</th>
                    </thead>
                    <tbody>
                        <c:forEach items="${datos}" var="dato">
                            <tr>
                                <td><c:out value="${dato.id}"/></td>
                                <td><c:out value="${dato.presentation_code}"/></td>
                                <td><c:out value="${dato.presentation_name}"/></td>
                                <td><c:out value="${dato.product_family_id}"/></td>
                                <td><c:out value="${dato.product_brand_id}"/></td>
                                <td><c:out value="${dato.product_id}"/></td>
                                <td><c:out value="${dato.creation_date}"/></td>
                                <td><c:out value="${dato.enable}"/></td>
                                <td><c:out value="${dato.barcode}"/></td>
                                <td><c:out value="${dato.cost}"/></td>
                                <td>
                                    <a href="editProductPresentation.htm?id=${dato.id}"><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span></a>
                                    <a href="deleteProductPresentation.htm?id=${dato.id}"><span class="glyphicon glyphicon-trash" aria-hidden="true"></span></a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </jsp:body>
</t:index>
  
  