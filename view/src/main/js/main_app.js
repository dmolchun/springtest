var model = {
    users: [
        { login: "Login1", secondName: "secondName1", name: "name1" },
        { login: "Login2", secondName: "secondName2", name: "name2" },
        { login: "Login3", secondName: "secondName3", name: "name3" }
    ]
};
var mainApp = angular.module("mainApp", []);
mainApp.controller("mainController", function ($scope, $http) {
    $http({method: 'GET', url: '/user/users'}).
    then(function success(response) {
        $scope.users=response.data;
    });
});