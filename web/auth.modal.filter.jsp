<md-dialog style="opacity: 1; width: 35%;">
    <md-toolbar>
        <div class="md-toolbar-tools">
            <h2>Filtro</h2>
            <span flex></span>
            <md-button class="md-icon-button" ng-click="cancel()">
                <md-icon md-svg-src="icons/close.svg" aria-label="Close dialog"></md-icon>
            </md-button>
        </div>
    </md-toolbar>

    <md-dialog-content>
        <div class="md-dialog-content">
            <form name="frmFiltro" action="./hogaresServlet" method="POST">
                <div layout="row" layout-align="space-between center">
                    <span>Seleccione el tipo de filtro: </span>
                    <md-select ng-model="tipoFiltro" name="tipoFiltro" placeholder="...Seleccione..." class="md-no-underline">
                        <md-option id="filtro1" value="filtro1">Rango de fechas</md-option>
                        <md-option id="filtro2" value="filtro2">Rango de valores</md-option>
                        <md-option id="filtro3" value="filtro3">Hogar con menos consumo</md-option>
                    </md-select>
                </div>

                <md-content ng-if="tipoFiltro === 'filtro1'">
                    <md-input-container>
                        <label>Desde</label>
                        <input input-date type="text"
                               name="txtDesde"
                               id="inputDesde"
                               ng-model="desde"
                               container=""
                               format="yyyy-mm-dd"
                               months-full="['Enero', 'Febrero', 'Marzo', 'Abril', 'Mayo', 'Junio', 'Julio', 'Agosto', 'Septiembre', 'Octubre', 'Noviembre', 'Diciembre']"
                               months-short="['Ene', 'Feb', 'Mar', 'Abr', 'May', 'Jun', 'Jul', 'Ago', 'Sep', 'Oct', 'Nov', 'Dic']"
                               weekdays-full="['Domingo', 'Lunes', 'Martes', 'Míercoles', 'Jueves', 'Viernes', 'Sábado']"
                               weekdays-short="['Do', 'Lu', 'Ma', 'Mí', 'Ju', 'Vi', 'Sá']"
                               weekdays-letter="['D', 'L', 'M', 'M', 'J', 'V', 'S']"
                               disable="disable"
                               today="'Hoy'"
                               first-day="1"
                               clear="'Limpiar'"
                               close="'Cerrar'"
                               select-years="15"
                               on-start="onStart()"
                               on-render="onRender()"
                               on-open="onOpen()"
                               on-close="onClose()"
                               on-set="onSet()"
                               on-stop="onStop()"/>
                    </md-input-container>
                    <md-input-container>
                        <label>Hasta</label>
                        <input input-date type="text"
                               name="txtHasta"
                               id="inputHasta"
                               ng-model="hasta"
                               container=""
                               format="yyyy-mm-dd"
                               months-full="['Enero', 'Febrero', 'Marzo', 'Abril', 'Mayo', 'Junio', 'Julio', 'Agosto', 'Septiembre', 'Octubre', 'Noviembre', 'Diciembre']"
                               months-short="['Ene', 'Feb', 'Mar', 'Abr', 'May', 'Jun', 'Jul', 'Ago', 'Sep', 'Oct', 'Nov', 'Dic']"
                               weekdays-full="['Domingo', 'Lunes', 'Martes', 'Míercoles', 'Jueves', 'Viernes', 'Sábado']"
                               weekdays-short="['Do', 'Lu', 'Ma', 'Mí', 'Ju', 'Vi', 'Sá']"
                               weekdays-letter="['D', 'L', 'M', 'M', 'J', 'V', 'S']"
                               disable="disable"
                               today="'Hoy'"
                               first-day="1"
                               clear="'Limpiar'"
                               close="'Cerrar'"
                               select-years="15"
                               on-start="onStart()"
                               on-render="onRender()"
                               on-open="onOpen()"
                               on-close="onClose()"
                               on-set="onSet()"
                               on-stop="onStop()"/>
                    </md-input-container>
                </md-content>

                <md-content ng-if="tipoFiltro === 'filtro2'">
                    <md-input-container class="md-block flex-gt-sm" flex-gt-sm="">
                        <label>Valor inicial</label>
                        <input id="txtValorInicial" name="txtValorInicial" class="ng-pristine ng-valid md-input ng-empty ng-touched" aria-invalid="false" required>
                    </md-input-container>
                    <md-input-container class="md-block flex-gt-sm" flex-gt-sm="">
                        <label>Valor final</label>
                        <input id="txtValorFinal" name="txtValorFinal" class="ng-pristine ng-valid md-input ng-empty ng-touched" aria-invalid="false" required>
                    </md-input-container>
                </md-content>

                <md-button ng-if="tipoFiltro" class="md-primary md-raised" id="filtrar" type="submit" 
                           name="action" value="filtroHogar_{{tipoFiltro}}" ng-disabled="frmFiltro.$invalid">
                    buscar
                </md-button>
            </form>
        </div>
    </md-dialog-content>
</md-dialog>