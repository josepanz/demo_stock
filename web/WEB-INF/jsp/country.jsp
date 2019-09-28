<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:index>
    <jsp:body>
        <h1>Pais</h1>        
        <div class="container">
            <div class="row">
                <p>
                    <a href="addCountry.htm" class="btn btn-success"><span class="glyphicon glyphicon-plus" aria-hidden="true"></span></i>Agregar</a>
                </p>
                <table class="table table-bordered table-striped table-hover">
                    <thead>
                    <th>id</th>
                    <th>codigo</th>
                    <th>Descripcion</th>
                    <th>Fecha Agregada</th>
                    </thead>
                    <tbody>
                        <c:forEach items="${datos}" var="dato">
                            <tr>
                                <td><c:out value="${dato.id}"/></td>
                                <td><c:out value="${dato.code}"/></td>
                                <td><c:out value="${dato.description}"/></td>
                                <td><c:out value="${dato.creation_date}"/></td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </jsp:body>
</t:index>
  
  