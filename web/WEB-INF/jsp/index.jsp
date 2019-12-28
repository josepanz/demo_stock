<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<t:index>
    <jsp:body>
        <button type="button" class="btn btn-primary" data-toggle="modal" data-target=".bd-example-modal-lg">Bienvenido</button>

        <div class="modal fade bd-example-modal-lg" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
            <div class="modal-dialog modal-lg">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">Agregar Departamento</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <div class="container">
                            <h4>
                                Ingrese sus datos 
                                <a href="departament.htm" class="btn btn-success"><span class="glyphicon glyphicon-arrow-left" aria-hidden="true"></span></a>
                            </h4>
                            <div class="row">
                                <form method="post" commandName="departament" >
                                    <form:errors path="*" element="div" cssClass="alert alert-danger"/>
                                    <p>
                                        <label  path="code">Codigo</label>
                                        <textarea   path="code" cssClass="form-control"></textarea>
                                    </p>
                                    <p>
                                    <label path="description">Descripcion</label>
                                    <textarea path="description" cssClass="form-control" ></textarea>
                                    </p> 
                                    <p>
                                        <a href="addCountry.htm" class="btn btn-success" ><span class="glyphicon glyphicon-plus" aria-hidden="true" style="font-size:10pt;"></span></a>
                                    <label path="country_id">Pais</label>
                                    <select path="country_id" cssClass="form-control">
                                        <option value="0">Seleccione un pais</option>
                                        <c:forEach items="${countryList}" var="country">
                                            <option value="${country.id}">${country.description}</option>
                                        </c:forEach>
                                    </select>
                                    </p>
                                    <hr/>
                                    <input type="submit" value="Enviar" class="form-control"/>
                                </form>
                            </div>
                        </div>  
                    </div>
                </div>
            </div>
        </div>
    </jsp:body>
</t:index>