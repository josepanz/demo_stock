<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:index>
    <jsp:body>
        <h1>Pais</h1>        
        <div class="container">
            <div class="row">
                <p>
                    <a href="addProductFamily.htm" class="btn btn-success"><span class="glyphicon glyphicon-plus" aria-hidden="true"></span></i>Agregar</a>
                </p>
                <table class="table table-bordered table-striped table-hover">
                    <thead>
                    <th>Id</th>
                    <th>Código</th>
                    <th>Descripción</th>
                    <th>Fecha Agregada</th>
                    <th>Acciones</th>
                    </thead>
                    <tbody>
                        <c:forEach items="${datos}" var="dato">
                            <tr>
                                <td><c:out value="${dato.id}"/></td>
                                <td><c:out value="${dato.code}"/></td>
                                <td><c:out value="${dato.description}"/></td>
                                <td><c:out value="${dato.creation_date}"/></td>
                                <td>
                                    <a href="editProductFamily.htm?id=${dato.id}"><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span></a>
                                    <a href="deleteProductFamily.htm?id=${dato.id}"><span class="glyphicon glyphicon-trash" aria-hidden="true"></span></a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </jsp:body>
</t:index>
  
  