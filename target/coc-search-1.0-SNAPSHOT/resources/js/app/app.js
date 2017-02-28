/**
 * Created by leho on 2/24/17.
 */


angular
    .module('myApp',[
        'ui.router',
        'ui.bootstrap'
    ])
    .constant('urls',{
        BASE: 'http://localhost:8080',
        config: {
            header: {
                'Content-Type' : 'application/json'
            }
        }
    })
    .config(
        function ($stateProvider,$urlRouterProvider) {
            $urlRouterProvider.otherwise('/home');
            $stateProvider
                .state('home',{
                    url:'/home',
                    templateUrl: 'resources/js/app/home/_home.html',
                    controller: 'HomeCtrl'
                })
                .state('aboutus',{
                    url:'/aboutus',
                    templateUrl: 'resources/js/app/aboutus/_aboutus.html'
                });
    });