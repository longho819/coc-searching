angular.module('myApp')
    .controller('HomeCtrl',HomeCtrl);

HomeCtrl.$inject = ['$scope','ClanService'];

function HomeCtrl($scope,ClanService){
    $scope.title = 'Welcome To';
    $scope.clanName = '';
    $scope.limit = 10;
    function searchClan(name,before,after) {
        return getClan(name,$scope.limit,before,after).then(function() {
            console.log('Activated Clan View');
        });
    }

    function getClan(name,limit,before,after){
        return ClanService.getClan(name,limit,before,after)
            .then(function(data){
                $scope.clans = data;
                return $scope.clans;
            })
    }

    $scope.search = function(){
        if($scope.clanName != ''){
            searchClan($scope.clanName,"","");
        }

    };

    $scope.paging= function(par){
        if(par == 'next'){
            searchClan($scope.clanName,"",$scope.clans.paging.cursors.after);
        }else if(par == 'previous'){
            searchClan($scope.clanName,$scope.clans.paging.cursors.before,"");
        }

    }


}