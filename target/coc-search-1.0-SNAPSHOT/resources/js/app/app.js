/**
 * Created by leho on 2/24/17.
 */


angular
    .module('myApp',[
        'ui.router',
        'ui.bootstrap'
    ])
    .constant('urls',{
        BASE: 'https://safe-meadow-37614.herokuapp.com',
        config: {
            header: {
                'Content-Type' : 'application/json'
            }
        }
    })
    .config(
        function ($stateProvider,$urlRouterProvider) {
            $urlRouterProvider.otherwise('/home///');
            $stateProvider
                .state('home',{
                    url:'/home/:keyword/:after/:before',
                    templateUrl: 'resources/js/app/home/_home.html',
                    controller: 'HomeCtrl'
                }).state('aboutus',{
                    url:'/aboutus',
                    templateUrl: 'resources/js/app/aboutus/_aboutus.html'
                })
                .state('clandetails',{
                    url:'/clan/:tag',
                    templateUrl: 'resources/js/app/clan/_clandetails.html',
                    controller: function($scope,$stateParams,ClanService){
                        $scope.clanid = $stateParams.tag;
                        getClan($stateParams.tag).then(function (data) {
                            $scope.clan = data;
                        })
                        function getClan(tag){
                            return ClanService.getClanByTag(tag)
                                .then(function(data){
                                    return data;
                                })
                        }
                    }
                });
    });