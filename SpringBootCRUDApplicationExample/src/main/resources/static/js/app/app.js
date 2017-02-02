var app = angular.module('CrudApp', ['ui.router','ngStorage']);

app.constant('urls', {
    BASE: 'http://localhost:8080/SpringBootCRUDApp',
    USER_SERVICE_API : 'http://localhost:8080/SpringBootCRUDApp/api/user/'
});

app.config(['$stateProvider', '$urlRouterProvider',
    function() {
        $stateProvider
            .state('home', {
                url: '/',
                templateUrl: 'partials/list',
                controller:'UserController',
                controllerAs:'ctrl',
                resolve: {
                    users: function($q, UserService) {
                        console.log('Load all users');
                        
                    }
                }
            });

    }]);