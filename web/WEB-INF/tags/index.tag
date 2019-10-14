<%@tag description="Index " pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">

    <head>

        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">

        <title >Inicio</title>

        <!-- Bootstrap core CSS -->
        <!--link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"  /-->   
        <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <link href="css/glyphicon.css" rel="stylesheet">
        <!-- Custom styles for this template -->
        <link href="css/simple-sidebar.css" rel="stylesheet">

    </head>

    <body>

        <div class="d-flex" id="wrapper">

            <!-- Sidebar -->
            <div class="bg-light border-right" id="sidebar-wrapper">
                <div class="sidebar-heading text-primary">Menu </div>
                <div class="list-group list-group-flush">
                    <!-- Maestro de Informacion-->
                    <p>
                        <a class="list-group-item list-group-item-action bg-light text-primary" data-toggle="collapse" href="#collapseMaster" role="button" aria-expanded="false" aria-controls="collapseMaster">
                            Maestro
                        </a></p>
                    <div class="collapse" id="collapseMaster">
                        <div class="card card-body bg-light">
                            <p>
                                <a class="list-group-item list-group-item-action bg-light text-primary" data-toggle="collapse" href="#collapsePerson" role="button" aria-expanded="false" aria-controls="collapsePerson">
                                    Personas
                                </a></p>
                            <div class="collapse" id="collapsePerson">
                                <div class="card card-body bg-light">
                                    <a id="currencyId" href="#" class="list-group-item-action bg-light" >Clientes</a>
                                    <a id="currencyExchangeId" href="#" class="list-group-item-action bg-light" >Empleados</a>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="collapse" id="collapseMaster">
                        <div class="card card-body bg-light">
                            <p>
                                <a class="list-group-item list-group-item-action bg-light text-primary" data-toggle="collapse" href="#collapseLocation" role="button" aria-expanded="false" aria-controls="collapseLocation">
                                    Localidades
                                </a></p>
                            <div class="collapse" id="collapseLocation">
                                <div class="card card-body bg-light">
                                    <a id="cityId" href="city.htm" class="list-group-item-action bg-light" >Ciudades</a>
                                    <a id="departamentId" href="departament.htm" class="list-group-item-action bg-light" >Departamentos</a>
                                    <a id="countryId" href="country.htm" class=" list-group-item-action bg-light">Paises</a>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="collapse" id="collapseMaster">
                        <div class="card card-body bg-light">
                            <p>
                                <a class="list-group-item list-group-item-action bg-light text-primary" data-toggle="collapse" href="#collapseCurrency" role="button" aria-expanded="false" aria-controls="collapseCurrency">
                                    Monedas
                                </a></p>
                            <div class="collapse" id="collapseCurrency">
                                <div class="card card-body bg-light">
                                    <a id="currencyId" href="#" class="list-group-item-action bg-light" >Monedas</a>
                                    <a id="currencyExchangeId" href="#" class="list-group-item-action bg-light" >Cambio Moneda</a>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- Configuraciones -->
                    <p>
                        <a class="list-group-item list-group-item-action bg-light text-primary" data-toggle="collapse" href="#collapseOrganization" role="button" aria-expanded="false" aria-controls="collapseOrganization">
                            Organizacion
                        </a></p>
                    <div class="collapse" id="collapseOrganization">
                        <div class="card card-body bg-light">
                            <a id="" href="#" class="list-group-item list-group-item-action bg-light text-primary">Usuario</a>
                            <a id="" href="#" class="list-group-item list-group-item-action bg-light text-primary">Grupo</a>
                            <a id="" href="#" class="list-group-item list-group-item-action bg-light text-primary">Cargos</a>
                        </div>
                    </div>
                </div>
            </div>

            <!-- /#sidebar-wrapper -->

            <!-- Page Content -->
            <div id="page-content-wrapper">

                <nav class="navbar navbar-expand-lg navbar-light bg-light border-bottom">
                    <button class="btn btn-primary" id="menu-toggle"><span id="toggleButton" class="glyphicon glyphicon-th-list" aria-hidden="true">Ocultar</span></button>

                    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                    </button>

                    <div class="collapse navbar-collapse" id="navbarSupportedContent">
                        <ul class="navbar-nav ml-auto mt-2 mt-lg-0">
                            <li class="nav-item active">
                                <a class="nav-link text-primary" href="index.htm">Inicio <span class="sr-only">(current)</span></a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link text-primary glyphicon glyphicon-user" href="#"></a>
                            </li>
                            <li class="nav-item dropdown">
                                <a class="nav-link dropdown-toggle text-primary glyphicon glyphicon-wrench" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                    
                                </a>
                                <div class="dropdown-menu dropdown-menu-right text-primary" aria-labelledby="navbarDropdown">
                                    <a class="dropdown-item" href="#">Action</a>
                                    <a class="dropdown-item" href="#">Another action</a>
                                    <div class="dropdown-divider"></div>
                                    <a class="dropdown-item" href="salir">Salir</a>
                                </div>
                            </li>
                        </ul>
                    </div>
                </nav>

                <div class="container-fluid">
                    <jsp:doBody/>                   
                </div>
            </div>
            <!-- /#page-content-wrapper -->

        </div>
        <!-- /#wrapper -->

        <!-- Bootstrap core JavaScript -->
        <script src="vendor/jquery/jquery.min.js"></script>
        <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
        <!-- Menu Toggle Script -->
        <script>
            $("#menu-toggle").click(function (e) {
                e.preventDefault();
                //se realiza el cambio de texto del boton
                var buttonValue = document.getElementById("toggleButton").value;
                if (buttonValue == undefined || buttonValue == "Ocultar") {
                    document.getElementById("toggleButton").innerHTML = "Mostrar";
                    document.getElementById("toggleButton").value = "Mostrar";
                } else if (buttonValue == "Mostrar") {
                    document.getElementById("toggleButton").innerHTML = "Ocultar";
                    document.getElementById("toggleButton").value = "Ocultar";
                }
                $("#wrapper").toggleClass("toggled");

            });
        </script>
    </body>

</html>
