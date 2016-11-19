<md-toolbar class="md-theme-indigo">
    <h1 class="md-toolbar-tools">Registrar hogar</h1>
</md-toolbar>
<md-content layout-margin>
    <form name="frmAgregarHogar" action="./hogaresServlet" method="POST">
        <div layout-xs="row" class="layout" style="width: 100%;">
            <md-input-container class="md-block flex-gt-sm" flex-gt-sm="">
                <label>Código hogar</label>
                <input id="txtCodigoHogar" name="txtCodigoHogar" value="" class="ng-pristine ng-valid md-input ng-empty ng-touched" aria-invalid="false" required>
            </md-input-container>
            <md-input-container class="md-block flex-gt-sm" flex-gt-sm="">
                <label>Pago electricidad</label>
                <input id="txtPagoElec" name="txtPagoElec" class="ng-pristine ng-valid md-input ng-empty ng-touched" aria-invalid="false" required>
            </md-input-container>
            <md-input-container class="md-block flex-gt-sm" flex-gt-sm="">
                <label>Pago agua</label>
                <input id="txtPagoAgua" name="txtPagoAgua" class="ng-pristine ng-valid md-input ng-empty ng-touched" aria-invalid="false" required>
            </md-input-container>
            <md-input-container class="md-block flex-gt-sm" flex-gt-sm="">
                <label>Pago gas</label>
                <input id="txtPagoGas" name="txtPagoGas" class="ng-pristine ng-valid md-input ng-empty ng-touched" aria-invalid="false" required>
            </md-input-container>
        </div>
        <button class="md-button md-ink-ripple flex-gt-md-15 flex-30" 
                flex-gt-md="15" flex="30" md-colors="{background: 'indigo'}" md-colors-watch="false" 
                style="background: rgb(63, 81, 181); color: rgba(255, 255, 255, 0.870588);" 
                id="guardarHogar" type="submit" name="action" value="guardarHogar" ng-disabled="frmAgregarHogar.$invalid">
            <span>GUARDAR</span>
        </button>
    </form>
    <md-button ng-click="toggleLeft()" class="md-accent">
        Close this Sidenav
    </md-button>
</md-content>