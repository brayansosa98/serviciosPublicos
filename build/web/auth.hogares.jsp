<%@page import="java.util.List"%>
<%@page import="com.serviciosPubli.Entidades.hogares"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    List<hogares> LHO = (List<hogares>) request.getAttribute("listado");
    String men = (String) request.getAttribute("mensaje") != null ? (String) request.getAttribute("mensaje") : null;
%>
<form name="frmAgregarHogar" action="./hogaresServlet" method="POST">
    <div layout-xs="row" class="layout" style="width: 100%;">
        <md-input-container class="md-block flex-gt-sm" flex-gt-sm="">
            <label>Código hogar</label>
            <input id="txtCodigoHogar" name="txtCodigoHogar" value="" class="ng-pristine ng-valid md-input ng-empty ng-touched" aria-invalid="false">
        </md-input-container>
        <md-input-container class="md-block flex-gt-sm" flex-gt-sm="">
            <label>Pago electricidad</label>
            <input id="txtPagoElec" name="txtPagoElec" class="ng-pristine ng-valid md-input ng-empty ng-touched" aria-invalid="false">
        </md-input-container>
        <md-input-container class="md-block flex-gt-sm" flex-gt-sm="">
            <label>Pago agua</label>
            <input id="txtPagoAgua" name="txtPagoAgua" class="ng-pristine ng-valid md-input ng-empty ng-touched" aria-invalid="false">
        </md-input-container>
        <md-input-container class="md-block flex-gt-sm" flex-gt-sm="">
            <label>Pago gas</label>
            <input id="txtPagoGas" name="txtPagoGas" class="ng-pristine ng-valid md-input ng-empty ng-touched" aria-invalid="false">
        </md-input-container>
    </div>
    <button class="md-button md-ink-ripple flex-gt-md-15 flex-30" 
            flex-gt-md="15" flex="30" md-colors="{background: 'indigo'}" md-colors-watch="false" 
            style="background: rgb(63, 81, 181); color: rgba(255, 255, 255, 0.870588);" 
            id="guardarHogar" type="submit" name="action" value="guardarHogar">
        <span>GUARDAR</span>
    </button>
    <%=men%>
</form>
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
            <td id="<%= ho.getId()%>"><%= ho.getId()%></td>
            <td><%= ho.getValor_elec()%></td>
            <td><%= ho.getValor_agua()%></td>
            <td><%= ho.getValor_gas()%></td>
            <td> {{ <%= ho.getFecha().getTime()%> | date}} </td>
        </tr>
        <%}%>
    </tbody>
</table>
<div class="footer">
    <md-button ng-click="toggleLeft()" class="md-accent">
        Close this Sidenav
    </md-button>
</div>
