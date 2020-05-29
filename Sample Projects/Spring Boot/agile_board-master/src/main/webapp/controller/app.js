var app = angular.module('VSB', []);

app.controller('SprintCtrl', function($http, $scope) {
  $http.get('document.json').success(function (data) 
  {
     $scope.Sprints = data;
     $scope.SelectedSprint = $scope.Sprints[0];
  });
});