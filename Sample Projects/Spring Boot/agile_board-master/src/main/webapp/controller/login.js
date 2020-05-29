LoginApp.controller("LoginValidation",function($scope,$http)
{
	$scope.submit_success=false;
	$scope.currUser = '';
	
	$scope.Login = function() {
			
			var encodedString = 'email=' + this.user.email+ '&pass=' + this.user.pass;
			$scope.currUser = this.user.email;
			console.log("login user"+ $scope.currUser);
			//alert($scope.currUser);
			$http({
				method: 'GET',
				url: 'http://localhost:8080/login?'+encodedString
			})
			.success(function(data, status, headers, config) {
				console.log(data);
				//if (status == 200 && data != "") {
					if (status == 200) {
					window.location.href = '../view/index.html?Id='+1;
				} else {
					$scope.errorMsg = "Some unexpected error occured.";
				}
			})
			.error(function(data, status, headers, config) {
				$scope.errorMsg = 'Email or Password is not correct.';
			});
		}
}); 	
