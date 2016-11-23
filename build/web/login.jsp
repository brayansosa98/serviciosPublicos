<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    String mensajeError = (String) request.getAttribute("mensajeError");
%>
<html ng-app="serpuApp" ng-strict-di>
    <head>
        <title>Inicio de sesión - servicios públicos</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <!--CSS-->
        <link rel="stylesheet" href="JS/complementos/angular-material/angular-material.min.css">
        <link rel="stylesheet" href="JS/complementos/angular-material/docs.css">
        <link rel="stylesheet" href="JS/complementos/angular-material/icon.css">
        <link rel="stylesheet" href="JS/complementos/am-table/md-data-table.min.css">        
        <link rel="stylesheet" href="JS/complementos/materialize/materialize.min.css">
    </head>
    <body id="body" >  
        <form method="POST" action="." name="login">
            <md-grid-tile class="red" md-rowspan="2" md-colspan="2" md-colspan-sm="1" md-colspan-xs="1">
                <md-card md-theme="dark-grey" md-theme-watch>
                    <md-card-title>
                        <md-card-title-text>
                            <span class="md-headline">Iniciar sesión</span>
                        </md-card-title-text>
                        <md-card-title-media>
                            <md-input-container class="md-block flex-gt-sm" flex-gt-sm="">
                                <label>Usuario</label>
                                <input id="txtUser" name="txtUser" class="ng-pristine ng-valid md-input ng-empty ng-touched" aria-invalid="false" required>
                            </md-input-container>
                            <md-input-container class="md-block flex-gt-sm" flex-gt-sm="">
                                <label>Contraseña</label>
                                <input type="password" id="txtPass" name="txtPass" class="ng-pristine ng-valid md-input ng-empty ng-touched" aria-invalid="false" required>
                            </md-input-container>
                        </md-card-title-media>
                    </md-card-title>
                    <md-card-actions layout="row" layout-align="end center">
                        <md-button id="btnBuscarHogar" class="md-primary md-raised"
                                   type="submit" name="action" value="ingresar" ng-disabled="login.$invalid">
                            Ingresar
                        </md-button>
                    </md-card-actions>
                </md-card>
                <%=mensajeError%>
            </md-grid-tile>
        </div>
    </form>
    <!--javaScripts-->
    <script src="JS/complementos/materialize/jquery-3.0.0.min.js"></script>
    <script src="JS/complementos/angular.min.js"></script>
    <script src="JS/complementos/angular-ui-router.min.js"></script>
    <script src="JS/complementos/angular-animate.min.js"></script>
    <script src="JS/complementos/angular-aria.min.js"></script>
    <script src="JS/complementos/angular-ui-router.min.js"></script>
    <script src="JS/complementos/angular-material/angular-material.min.js"></script>
    <script src="JS/complementos/angular-messages.min.js"></script>
    <script src="JS/complementos/angular-strap/angular-strap.min.js"></script>
    <script src="JS/complementos/angular-strap/angular-strap.tpl.min.js"></script>
    <script src="JS/complementos/am-table/md-data-table.min.js"></script>
    <script src="JS/complementos/materialize/materialize.min.js"></script>
    <script src="JS/complementos/materialize/angular-materialize.min.js"></script>            
    <!-- Latest compiled and minified JavaScript -->
    <script src="JS/app.js"></script>
    <script src="JS/state.js"></script>
</body>
</html>
