'use strict';

angular.module('serpuApp')
        .config(['$stateProvider', '$urlRouterProvider',
            function($stateProvider, $urlRouterProvider) {

                $urlRouterProvider
                        .when('/home', '/')
                        .when('', '/')
                        .otherwise('/404');

                $stateProvider
                        .state('notFound', {
                            url: '/404',
                            templateUrl: '404.html'
                        })
                        .state('signin', {
                            url: '/signin',
                            templateUrl: 'signin.html',
                            controller: ''
                        })

                        .state('auth', {
                            abstract: true,
                            url: '',
                            templateUrl: 'auth.html',
                            controller: ''
                        })

                        .state('auth.inicio', {
                            url: '/',
                            templateUrl: 'auth.home.html',
                            controller: '',
                            ncyBreadcrumb: {
                                label: 'Inicio'
                            }
                        })

                        .state('auth.parametrizacion', {
                            url: '/parametrization',
                            templateUrl: 'auth.parametrizacion.jsp',
                            controller: '',
                            ncyBreadcrumb: {
                                label: 'Parametrización'
                            }
                        })

                        .state('auth.hogares', {
                            url: '/homes',
                            templateUrl: 'auth.hogares.jsp',
                            controller: 'ejemplo',
                            ncyBreadcrumb: {
                                label: 'Hogares'
                            }
                        });
            }]);
        
        
        angular.module('serpuApp')
        .controller('DemoCtrl', function() {
                        this.topDirections = ['left', 'up'];
                                this.bottomDirections = ['down', 'right'];
                                this.isOpen = false;
                                this.availableModes = ['md-fling', 'md-scale'];
                                this.selectedMode = 'md-fling';
                                this.availableDirections = ['up', 'down', 'left', 'right'];
                                this.selectedDirection = 'up';
                        });