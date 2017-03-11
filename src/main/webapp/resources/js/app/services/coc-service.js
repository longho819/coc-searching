/**
 * Created by leho on 2/26/17.
 */

angular.module('myApp')
.factory('ClanService',clanservice);

function clanservice($http,$location){
    var service = {
        searchClan: searchClan,
        getClanByTag: getClanByTag,
        getPlayerByTag: getPlayerByTag
    };
    return service;
    // var url = $location.protocol() + "://" + $location.host() + ":" + $location.port();
    function searchClan(name, limit, before, after){
        return $http.get('/clan/get?name=' + name
                +'&limit=' + limit
                +'&after=' + after
                +'&before=' + before,
            {'Content-Type': 'application/json'})
            .then(getMembers)
            .catch(getMembersFail);
        function getMembers(response){
            return response.data;
        }

        function getMembersFail(error){
            console.log('XHR Failed for getAllMembersOfClan' + error.data);
        }
    };

    function getClanByTag(tag){
        return $http.get(
            '/clan?tag=' + tag.replace('#','%23'),
            {'Content-Type' : 'application/json'}
            )
            .then(getClan)
            .catch(getClanFail);
        function  getClan(response) {
            return response.data;
        }

        function getClanFail(error) {
            console.log('XHR Failed for getClanByTag' + error.data);
        }
    };

    function getPlayerByTag(tag){
        return $http.get(
            '/players?tag=' + tag.replace('#','%23'),
            {'Content-Type' : 'application/json'}
        ).then(getPlayer).catch(getPlayerFail);
        function getPlayer(response){
            return response.data;
        }
        function getPlayerFail(error){
            console.log('XHR Failed for getPlayerByTag' + error.data);
        }
    }
}