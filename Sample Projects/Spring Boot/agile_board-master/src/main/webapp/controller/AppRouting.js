LoginApp.config(["$routeProvider",function($routeProvider){
	$routeProvider.when('/LoginSubmit',{
		templateUrl : "index.html"
	}).when('/ForgotPassword',{
		templateUrl : "forgotPassword.html"
	}).otherwise({redirectTo: '/'});
}]);