/**
 * Created by leho on 2/26/17.
 */

angular.module('myApp')
.factory('ClanService',clanservice);

function clanservice($http,urls){
    var service = {
        searchClan: searchClan,
        getClanByTag: getClanByTag
    };
    return service;

    function searchClan(name, limit, before, after){
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
    };

    function getClanByTag(tag){
        return $http.get(
            urls.BASE + '/clan?tag=' + tag.replace('#','%23'),
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
}