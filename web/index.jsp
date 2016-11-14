<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html ng-app="serpuApp" ng-strict-di>
    <head>
        <title>Servicios p�blicos</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <!--CSS-->
        <link rel="stylesheet" href="JS/complementos/angular-material/angular-material.min.css">
        <link rel="stylesheet" href="JS/complementos/angular-material/docs.css">
        <link rel="stylesheet" src="JS/complementos/am-table/md-data-table.min.css">
    </head>
    <body>  
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
        <script src="JS/complementos/angular.min.js"></script>
        <script src="JS/complementos/angular-ui-router.min.js"></script>
        <script src="JS/complementos/angular-animate.min.js"></script>
        <script src="JS/complementos/angular-aria.min.js"></script>
        <script src="JS/complementos/angular-ui-router.min.js"></script>
        <script src="JS/complementos/angular-material/angular-material.min.js"></script>
        <script src="JS/complementos/angular-messages.min.js"></script>
        <script src="JS/complementos/am-table/md-data-table.min.js"></script>
        <script src="JS/app.js"></script>
        <script src="JS/state.js"></script>
    </body>
</html>
