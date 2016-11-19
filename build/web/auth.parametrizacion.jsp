<%@page import="com.serviciosPubli.Entidades.tipoServicio"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%
    List<tipoServicio> LTS = (List<tipoServicio>) request.getAttribute("listado");
    String men = (String) request.getAttribute("mensaje") != null ? (String) request.getAttribute("mensaje") : null;
%>
<div class="tabsdemoDynamicHeight">
    <md-content>
        <md-tabs md-dynamic-height md-border-bottom>
            <% for (tipoServicio ts : LTS) {%>
            <md-tab label="<%= ts.getNombre()%>" id="label_<%= ts.getNombre()%>">
                <md-content class="md-padding">
                    <form name="frm<%= ts.getNombre()%>" action="./parametrizacionServlet" method="POST">
                        <div layout-xs="row" class="layout" style="width: 30%;">
                            <md-input-container class="md-block flex-gt-sm" flex-gt-sm="">
                                <label for="input_61">Valor subsidio</label>
                                <input id="txtvalor_subsidio_<%= ts.getNombre()%>" name="txtvalor_subsidio_<%= ts.getNombre()%>" value="<%=ts.getValor_subsidio()%>" 
                                       class="ng-pristine ng-valid md-input ng-empty ng-touched" aria-invalid="false" required>
                            </md-input-container>
                        </div>
                        <div layout-xs="row" class="layout" style="width: 30%;">
                            <md-input-container class="md-block flex-gt-sm" flex-gt-sm="">
                                <label for="input_61">Limite pago</label>
                                <input id="txtlimite_pago_<%= ts.getNombre()%>" name="txtlimite_pago_<%= ts.getNombre()%>" value="<%=ts.getLimite_pago()%>"   class="ng-pristine ng-valid md-input ng-empty ng-touched" aria-invalid="false" required>
                            </md-input-container>
                        </div>
                        <button class="md-button md-ink-ripple flex-gt-md-15 flex-30" 
                                flex-gt-md="15" flex="30" md-colors="{background: 'indigo'}" md-colors-watch="false" style="background: rgb(63, 81, 181); color: rgba(255, 255, 255, 0.870588);" 
                                id="actualizar<%= ts.getNombre()%>" type="submit" name="action" value="actualizar<%= ts.getNombre()%>" ng-disabled="frm<%= ts.getNombre()%>.$invalid">
                            <span>GUARDAR</span>
                        </button>
                        <%=men%>
                    </form>                          
                </md-content>
            </md-tab>
            <%}%>
        </md-tabs>
    </md-content>
</div>
