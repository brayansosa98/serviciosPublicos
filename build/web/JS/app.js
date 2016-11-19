'use strict';
//Declaración del modulo
angular
        .module('serpuApp', [
            'ngAnimate',
            'ngAria',
            'ui.router',
            'ngMaterial',
            'md.data.table'
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

}

angular.module('serpuApp')
        .controller('DialogController', DialogController);
DialogController.$inject = ['$scope', '$mdDialog'];
function DialogController($scope, $mdDialog) {
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
