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
angular.module('serpuApp')
.controller('ejemplo', ['$scope', function($scope) {
        'use strict';

        $scope.selected = [];

        $scope.query = {
            order: 'id',
            limit: 5,
            page: 1
        };

        function success(desserts) {
            $scope.desserts = desserts;
        }
        
        $scope.promise = [
                {id: 1},  
                {id: 2},  
                {id: 3},  
                {id: 4},  
                {id: 5},  
                {id: 6},  
                {id: 7},  
                {id: 8},  
                {id: 9},  
                {id: 10},  
                {id: 11},  
                {id: 12},  
                {id: 13},  
                {id: 14},  
                {id: 15},  
                {id: 16},  
                {id: 17},  
                {id: 18}  
            ];
        

    }]);
        