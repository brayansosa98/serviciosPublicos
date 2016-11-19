<md-dialog style="opacity: 1; width: 70%;">
    <form ng-cloak>
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
                        <md-select ng-model="tipoFiltro" placeholder="...Seleccione..." class="md-no-underline">
                            <md-option id="filtro1" value="filtro1">Rango de fechas</md-option>
                            <md-option id="filtro2" value="filtro2">Rango de valores</md-option>
                            <md-option id="filtro3" value="filtro3">Hogar con menos consumo</md-option>
                        </md-select>
                    </div>

                    <md-content ng-if="tipoFiltro === 'filtro1'">
                        <md-input-container>
                            <label>Desde</label>
                            <md-datepicker ng-model="desde" name="txtDesde" id="txtDesde"></md-datepicker>
                        </md-input-container>
                        <md-input-container>
                            <label>Hasta</label>
                            <md-datepicker ng-model="hasta" name="txtHasta" id="txtHasta"></md-datepicker>
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
                    
                    <md-button ng-if="tipoFiltro" class="md-primary md-raised" id="filtrar" type="submit" name="action" value="filtroHogar_{{tipoFiltro}}" ng-disabled="frmFiltro.$invalid">
                        buscar
                    </md-button>
                </form>
            </div>
        </md-dialog-content>
    </form>
</md-dialog>