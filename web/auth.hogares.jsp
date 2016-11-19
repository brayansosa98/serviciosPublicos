<%@page import="java.util.List"%>
<%@page import="com.serviciosPubli.Entidades.hogares"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    List<hogares> LHO = (List<hogares>) request.getAttribute("listado");
    String men = (String) request.getAttribute("mensaje") != null ? (String) request.getAttribute("mensaje") : null;
    String filtro = (String) request.getAttribute("filtro") != null ? (String) request.getAttribute("filtro") : null;
%>
<div ng-controller="AppCtrl" layout="column" style="height: 100vh" ng-cloak>
    <section layout="row" flex>
        <md-sidenav class="md-sidenav-left" md-component-id="left" md-disable-backdrop md-whiteframe="4">
            <div ng-include="'auth.aside.agregarHogar.jsp'"></div>
        </md-sidenav>

        <md-content flex layout-padding>
            <div layout="column" layout-align="top center">
                <form name="frmConsultarHogar" action="./hogaresServlet" method="POST">
                    <div layout-xs="row" class="layout" style="width: 100%;">
                        <md-input-container class="md-block flex-gt-sm" flex-gt-sm="" style="width: 80%" >
                            <label>Buscar por código hogar</label>
                            <input id="txtSearch" name="txtSearch" class="ng-pristine ng-valid md-input ng-empty ng-touched" aria-invalid="false" required>
                        </md-input-container>
                        <md-button id="btnBuscarHogar" class="md-primary md-raised" style="position: absolute; margin-top: -6%; margin-left: 80%;"
                                   type="submit" name="action" value="consultarHogar" ng-disabled="frmConsultarHogar.$invalid">
                            buscar
                        </md-button>
                    </div> 
                </form>

                <br>
                <center><%=men%></center>
                <br>
                <table>
                    <thead>
                        <tr>
                            <th><span>Código</span></th>
                            <th><span>Pago de electricidad</span></th>
                            <th>Pago de agua</th>
                            <th>Pago de gas</th>
                            <th>Fecha</th>
                        </tr>
                    </thead>
                    <tbody>

                        <% for (hogares ho : LHO) {%>
                        <tr>
                            <td id="cod_<%= ho.getId()%>"><%=ho.getId()%></td>
                            <td id="<%= ho.getId()%>_<%= ho.getValor_elec()%>"><%= ho.getValor_elec()%></td>
                            <td id="<%= ho.getId()%>_<%= ho.getValor_agua()%>"><%= ho.getValor_agua()%></td>
                            <td id="<%= ho.getId()%>_<%= ho.getValor_gas()%>"><%= ho.getValor_gas()%></td>
                            <td> {{ <%= ho.getFecha().getTime()%> | date}} </td>
                        </tr>
                        <%}%>
                    </tbody>
                </table>
                <div class="footer">
                    <form name="listar" action="./hogaresServlet" method="POST">
                        <md-button id="filtros" ng-click="showAdvanced($event)" class="md-fab md-primary" aria-label="Search home">
                            <md-icon md-svg-src="icons/search.svg"></md-icon>
                        </md-button>
                        <md-button id="agregarHogar" ng-click="toggleLeft()" class="md-fab md-primary" aria-label="Add home">
                            <md-icon md-svg-src="icons/add.svg"></md-icon>
                        </md-button>
                        <% if (filtro == "true") {%>
                        <md-button id="listar" class="md-fab md-primary" aria-label="Listar hogares" 
                                   type="submit" name="action" value="listar"> 
                            <md-icon md-svg-src="icons/close.svg"></md-icon>
                        </md-button>
                        <%}%>
                    </form>
                </div>
            </div>
        </md-content>
    </section>
</div>
