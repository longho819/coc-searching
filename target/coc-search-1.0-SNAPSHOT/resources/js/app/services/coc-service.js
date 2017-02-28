/**
 * Created by leho on 2/26/17.
 */

angular.module('myApp')
.factory('ClanService',clanservice);

function clanservice($http,urls){
    var service = {
        getClan: getClan
    };
    return service;

    function getClan(name, limit, before, after){
        return $http.get(urls.BASE + '/clan/get?name=' + name
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
    }
}