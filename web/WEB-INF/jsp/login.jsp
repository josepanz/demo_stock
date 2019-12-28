<%-- 
    Document   : login
    Created on : 13/08/2019, 07:25:19 PM
    Author     : Panza
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="true"%>

<!DOCTYPE html> 
<html> 
 
<head> 
 
    <meta charset="utf-8"> 
    <meta http-equiv="X-UA-Compatible" content="IE=edge"> 
    <meta name="viewport" content="width=device-width, initial-scale=1"> 
    <meta name="description" content=""> 
    <meta name="author" content=""> 
 
    <title>Ingresa al Sistema</title> 
 
    <!-- Bootstrap Core CSS --> 
    <link href="css/bootstrap.min.css" rel="stylesheet"> 
 
    <!-- MetisMenu CSS --> 
    <link href="css/metisMenu.min.css" rel="stylesheet"> 
 
    <!-- Custom CSS --> 
    <link href="css/sb-admin-2.css" rel="stylesheet"> 
 
    <!-- Custom Fonts --> 
    <link href="vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css"> 
 
    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries --> 
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// --> 
    <!--[if lt IE 9]> 
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script> 
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script> 
    <![endif]--> 
 
</head> 
 
<body> 
 
<div class="container"> 
    <div class="row"> 
        <div class="col-md-4 col-md-offset-4"> 
            <div class="login-panel panel panel-default"> 
                <div class="panel-heading"> 
                    <h3 class="panel-title">INGRESE SUS CREDENCIALES</h3> 
                </div> 
                <div class="panel-body"> 
                    <form name='loginForm' action="<c:url value='j_spring_security_check'/>" method='POST'> 
                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/> 
                        <fieldset> 
                            <div class="form-group"> 
                                <input class="form-control" placeholder="Usuario" name="username" type="text" autofocus id="username" > 
                            </div> 
                            <div class="form-group"> 
                                <input class="form-control" placeholder="Password" name="password" type="password" value="" id="pass"> 
                            </div> 
                            <!--<div class="checkbox"> 
                                <label> 
                                    <input name="remember" type="checkbox" value="Recordarme">Recuerdame 
                                </label> 
                            </div> -->
                            <button type="submit" class="btn btn-lg btn-success btn-block" id="submit">Ingresar</button> 
                        </fieldset> 
                    </form> 
                </div> 
            </div> 
        </div> 
 
        <span id="feedbackPanel"></span> 
    </div> 
</div> 
 
<!-- jQuery --> 
<script src="js/jquery.min.js"></script> 
 
<!-- Bootstrap Core JavaScript --> 
<script src="js/bootstrap.min.js"></script> 
 
<!-- Metis Menu Plugin JavaScript --> 
<script src="js/metisMenu.min.js"></script> 
 
<!-- Custom Theme JavaScript --> 
<script src="js/sb-admin-2.js"></script> 
 
</body> 
 
</html> 