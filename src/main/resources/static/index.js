angular.module('npp', []).controller('indexController', function ($scope, $http) {
    $scope.fillTable = function () {
        $http.get('http://localhost:8080/npp/departments')
            .then(function (response) {
                $scope.departments = response.data;
            });
    };

    $scope.deleteDepartment = function (id) {
        $http.delete('http://localhost:8080/npp/departments/' + id)
            .then(function (response) {
                $scope.fillTable();
            });
    }

    $scope.addDepartment = function () {
        $http.post('http://localhost:8080/npp/departments', $scope.newDepartment)
            .then(function (response) {
                $scope.newDepartment = null;
                $scope.fillTable();
            });
    }
    $scope.fillTable();
});