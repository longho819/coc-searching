angular.module('myApp')
    .controller('HomeCtrl',HomeCtrl);

HomeCtrl.$inject = ['$scope','ClanService','$stateParams'];

function HomeCtrl($scope,ClanService,$stateParams){
    $scope.clanName = $stateParams.keyword;
    $scope.title = 'Welcome To';
    $scope.limit = 10;
    $scope.before = $stateParams.before;
    $scope.after  = $stateParams.after;
    search();

    function searchClan(name,before,after) {
        return getClans(name,$scope.limit,before,after).then(function(data) {
            $scope.clans = data;
            console.log('Activated Clan View');
        });
    }

    function getClans(name,limit,before,after){
        return ClanService.searchClan(name,limit,before,after)
            .then(function(data){
                return data;
            })
    }

    function search(){
        if($scope.clanName != ''){
            searchClan($scope.clanName,$scope.before,$scope.after);
        }
    };

    $scope.paging= function(par){
        if(par == 'next'){
            searchClan($scope.clanName,"",$scope.clans.paging.cursors.after);
        }else if(par == 'previous'){
            searchClan($scope.clanName,$scope.clans.paging.cursors.before,"");
        }

    };
}