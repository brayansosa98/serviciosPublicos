'use strict';
//Declaración del modulo
angular
        .module('serpuApp', [
            'ngAnimate',
            'ngAria',
            'ui.router',
            'ngMaterial',
            'md.data.table',
            'ngMessages',
            'ui.materialize'
        ]);


angular
        .module('serpuApp')
        .controller('AppCtrl', AppCtrl);
AppCtrl.$inject = ['$scope', '$timeout', '$mdSidenav', '$mdDialog'];
function AppCtrl($scope, $timeout, $mdSidenav, $mdDialog) {
    $scope.toggleLeft = buildToggler('left');
    $scope.toggleRight = buildToggler('right');

    function buildToggler(componentId) {
        return function() {
            $mdSidenav(componentId).toggle();
        };
    }
    $scope.select = {
        value: "Option1",
        choices: ["Option1", "I'm an option", "This is materialize", "No, this is Patrick."]
    };
    $scope.showAdvanced = function(ev) {
        $mdDialog.show({
            controller: 'DialogController',
            templateUrl: 'auth.modal.filter.jsp',
            parent: angular.element(document.body),
            targetEvent: ev,
            clickOutsideToClose: true,
            fullscreen: $scope.customFullscreen // Only for -xs, -sm breakpoints.
        })
                .then(function(answer) {
                    $scope.status = 'You said the information was "' + answer + '".';
                }, function() {
                    $scope.status = 'You cancelled the dialog.';
                });
    };


    var currentTime = new Date();
    $scope.currentTime = currentTime;
    
    $scope.disable = [false, 1, 7];
    var days = 15;
    $scope.minDate = (new Date($scope.currentTime.getTime() - (1000 * 60 * 60 * 24 * days))).toISOString();
    $scope.maxDate = (new Date($scope.currentTime.getTime() + (1000 * 60 * 60 * 24 * days))).toISOString();
    $scope.onStart = function() {
        console.log('onStart');
    };
    $scope.onRender = function() {
        console.log('onRender');
    };
    $scope.onOpen = function() {
        console.log('onOpen');
    };
    $scope.onClose = function() {
        console.log('onClose');
    };
    $scope.onSet = function() {
        console.log('onSet');
    };
    $scope.onStop = function() {
        console.log('onStop');
    };
}

angular.module('serpuApp')
        .controller('DialogController', DialogController);
DialogController.$inject = ['$scope', '$mdDialog'];
function DialogController($scope, $mdDialog) {
    
    $scope.monthShort = ['Ene', 'Feb', 'Mar', 'Abr', 'May', 'Jun', 'Jul', 'Ago', 'Sep', 'Oct', 'Nov', 'Dic'];
    $scope.weekdaysFull = ['Domingo', 'Lunes', 'Martes', 'Míercoles', 'Jueves', 'Viernes', 'Sábado'];
    $scope.weekdaysLetter = ['D', 'L', 'M', 'M', 'J', 'V', 'S'];

    $scope.today = 'Hoy';
    $scope.clear = 'Limpiar';
    $scope.close = 'Cerrar';
    
    $scope.hide = function() {
        $mdDialog.hide();
    };

    $scope.cancel = function() {
        $mdDialog.cancel();
    };

    $scope.answer = function(answer) {
        $mdDialog.hide(answer);
    };
}
