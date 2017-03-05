/**
 * Created by leho on 2/25/17.
 */

angular.module('myApp')
    .controller('HeaderCtrl',HeaderCtrl)
    .directive('header', function() {
    return {
        templateUrl: 'resources/js/app/share/navbar/_nav.html',
        replace: 'true',
        restrict: 'E'
    };
});

function HeaderCtrl(){

}