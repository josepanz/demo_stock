<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<t:index>
    <jsp:body>
          <h1>Producto</h1>        
        <div class="container">
            <div class="row">
                <p>
                    <a href="addProduct.htm" class="btn btn-success"><span class="glyphicon glyphicon-plus" aria-hidden="true"></span>Agregar</a>
                </p>
                <table class="table table-bordered table-striped table-hover">
                    <thead>
                    <th>Id</th>
                    <th>Descripción</th>
                    <th>Unidad de Medida</th>
                    <th>Fecha de Creacion</th>
                    <th>Acciones</th>
                    </thead>
                    <tbody>
                        <c:forEach items="${datos}" var="dato">
                            <tr>
                                <td><c:out value="${dato.id}"/></td>
                                <td><c:out value="${dato.description}"/></td>
                                <td><c:out value="${dato.measured_unit_id}"/></td>
                                <td><c:out value="${dato.creation_date}"/></td>
                                <td>
                                    <a href="editProduct.htm?id=${dato.id}"><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span></a>
                                    <a href="deleteProduct.htm?id=${dato.id}"><span class="glyphicon glyphicon-trash" aria-hidden="true"></span></a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>     
    </jsp:body>
</t:index>
  
      
