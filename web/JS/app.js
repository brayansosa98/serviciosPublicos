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
            controller: '',
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
        .controller('LeftCtrl', LeftCtrl);
LeftCtrl.$inject = ['$scope', '$timeout', '$mdSidenav', '$log'];
function LeftCtrl($scope, $timeout, $mdSidenav, $log) {
    $scope.close = function() {
        // Component lookup should always be available since we are not using `ng-if`
        $mdSidenav('left').close()
                .then(function() {
                    $log.debug("close LEFT is done");
                });
    };
}
angular.module('serpuApp')
        .controller('RightCtrl', RightCtrl);
RightCtrl.$inject = ['$scope', '$timeout', '$mdSidenav', '$log'];
function RightCtrl($scope, $timeout, $mdSidenav, $log) {
    $scope.close = function() {
        // Component lookup should always be available since we are not using `ng-if`
        $mdSidenav('right').close()
                .then(function() {
                    $log.debug("close RIGHT is done");
                });
    };
}


angular.module('serpuApp')
        .directive('notallowletters', function() {
            return {
                require: 'ngModel',
                link: function(scope, element, attrs, modelCtrl) {
                    modelCtrl.$parsers.push(function(inputValue) {
                        // this next if is necessary for when using ng-required on your input.
                        // In such cases, when a letter is typed first, this parser will be called
                        // again, and the 2nd time, the value will be undefined
                        var transformedInput = (inputValue.replace && inputValue.replace(/[^0-9]/g, ''));
                        if (transformedInput !== inputValue) {
                            modelCtrl.$setViewValue(transformedInput);
                            modelCtrl.$render();
                        }

                        return transformedInput;
                    });
                }
            };
        });