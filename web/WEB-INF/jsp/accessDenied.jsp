<%-- 
    Document   : accessDenied
    Created on : 22/11/2019, 04:48:55 PM
    Author     : NITRO 5
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <script>
            if(confirm('NO POSEE LOS PERMISOS PARA INGRESAR A ESTE APARTADO'))
                alert('Favor regrese a la pagina anterior o contacte con el administrador');
                //window.history.back();
                //window.history.go(-2);
            else
                alert('Accion Detenida');
        </script>
    </body>
</html>
