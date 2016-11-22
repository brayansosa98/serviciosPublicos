<%@page import="com.serviciosPubli.Entidades.tipoServicio"%>
<%@page import="com.serviciosPubli.Entidades.pago_servicio"%>
<%@page import="java.util.LinkedHashMap"%>
<%@page import="com.serviciosPubli.Entidades.listaHogaresSub"%>
<%@page import="java.util.List"%>
<%@page import="com.serviciosPubli.Entidades.hogares"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    List<hogares> LHO = (List<hogares>) request.getAttribute("listado");
    List<listaHogaresSub> LHOSub = (List<listaHogaresSub>) request.getAttribute("listadoFiltro1");
    LinkedHashMap<String, List<pago_servicio>> LHOValorP = (LinkedHashMap<String, List<pago_servicio>>) request.getAttribute("listadoFiltro2");

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
                <% if (LHO != null) {%>
                <div style="height: 75vh; overflow: auto" >
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
                </div>
                <%}%>

                <% if (LHOSub != null) {%>
                <div style="height: 75vh; overflow: auto" >
                    <table>
                        <thead>
                            <tr>
                                <th><span>Código</span></th>
                                <th><span>Pago de electricidad</span></th>
                                <th>Subsidio aplicado</th>
                                <th><span>Pago de agua</span></th>
                                <th>Subsidio aplicado</th>
                                <th><span>Pago de gas</span></th>
                                <th>Subsidio aplicado</th>
                                <th>Fecha</th>
                            </tr>
                        </thead>
                        <tbody>

                            <% for (listaHogaresSub ho : LHOSub) {%>
                            <tr>
                                <td id="cod_<%= ho.getId_hogar()%>"><%=ho.getId_hogar()%></td>
                                <td id="<%= ho.getPagoElec()%>_<%= ho.getPagoElec()%>"><%= ho.getPagoElec()%></td>
                                <td id="<%= ho.getSubElec()%>_<%= ho.getSubElec()%>"><%= ho.getSubElec()%></td>
                                <td id="<%= ho.getPagoAgua()%>_<%= ho.getPagoAgua()%>"><%= ho.getPagoAgua()%></td>
                                <td id="<%= ho.getSubAgua()%>_<%= ho.getSubAgua()%>"><%= ho.getSubAgua()%></td>
                                <td id="<%= ho.getPagoGas()%>_<%= ho.getPagoGas()%>"><%= ho.getPagoGas()%></td>
                                <td id="<%= ho.getSubGas()%>_<%= ho.getSubGas()%>"><%= ho.getSubGas()%></td>
                                <td> {{ <%= ho.getFecha().getTime()%> | date}} </td>
                            </tr>
                            <%}%>
                        </tbody>
                    </table>
                </div>
                <%}%>

                <%if (LHOValorP != null) {%>
                <div style="height: 75vh; overflow: auto" >
                    <div class="tabsdemoDynamicHeight">
                        <md-content>
                            <md-tabs md-dynamic-height md-border-bottom>
                                <% for (int i = 1; i < 4; i++) {
                                        List<pago_servicio> listaPago = LHOValorP.get(i + "");
                                        if (i == 1) {%>
                                <md-tab label="Electricidad" id="label_Electricidad">
                                    <%}%>

                                    <%if (i == 2) {%>
                                    <md-tab label="Agua" id="label_Agua">
                                        <%}%>
                                        <%if (i == 3) {%>
                                        <md-tab label="Gas" id="label_Gas">
                                            <%}%>
                                            <table>
                                                <thead>
                                                    <tr>
                                                        <th>Código hogar</th>
                                                        <th>Servicio</th>
                                                        <th>Pago</th>
                                                        <th>Fecha</th>
                                                    </tr>
                                                </thead>
                                                <tbody>
                                                    <%for (int j = 0; j < listaPago.size(); j++) {%>
                                                    <tr>
                                                        <td> <%= listaPago.get(j).getId_hogar()%> </td>
                                                        <td> <%= listaPago.get(j).getId_tiposervicio()%> </td>
                                                        <td> <%= listaPago.get(j).getValor()%> </td>
                                                        <td> {{ <%= listaPago.get(j).getFecha().getTime()%> | date }} </td>
                                                    </tr>
                                                    <%}%>
                                                </tbody>
                                            </table>
                                        </md-tab>
                                        <%}%>
                                        </md-tabs>
                                        </md-content>
                                        </div>
                                        <%}%>

                                        <div class="footer">
                                            <form name="listar" action="./hogaresServlet" method="POST">
                                                <md-button id="filtros" ng-click="showAdvanced($event)" class="md-fab md-primary" aria-label="Search home">
                                                    <md-icon md-svg-src="icons/search.svg"></md-icon>
                                                </md-button>
                                                <md-button id="agregarHogar" ng-click="toggleLeft()" class="md-fab md-primary" aria-label="Add home">
                                                    <md-icon md-svg-src="icons/add.svg"></md-icon>
                                                </md-button>
                                                <md-button id="aplicarSubsidio" class="md-fab md-primary" aria-label="Aplicar subsidio" 
                                                           type="submit" name="action" value="aplicarSubsidio"> 
                                                    <md-icon md-svg-src="icons/check.svg"></md-icon>
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

