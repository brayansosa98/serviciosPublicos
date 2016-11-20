<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html ng-app="serpuApp" ng-strict-di>
    <head>
        <title>Servicios públicos</title>
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
        <%
            String targetModulo = request.getAttribute("targetModulo") == null ? "auth.home.html" : (String) request.getAttribute("targetModulo");
        %>         
        <div class="docs-body layout-row" layout="row">
            <div ng-include src="'sidebar.html'"></div>
            <div layout="column" tabindex="-1" role="main" flex="" class="layout-column flex" style="margin-left: 273px">
                <jsp:include page="<%=targetModulo%>" flush="true"/>
                <div autoscroll="true" ui-view></div>
            </div>
        </div>

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
