ForgotPassword.controller("ForgotValidation",function($scope,$http)
{
	ForgotValidations($scope,$http);
});

ForgotPassword.controller("ResetValidation",function($scope,$http)
{
	ResetValidation($scope,$http);
});

var ForgotValidations = function($scope,$http){
	$scope.submit_success=false;
	
	$scope.Forgot = function()
	{
			
		/*$scope.UsersList = '["shipra@gmail.com","Deepika@gmail.com"]';
		var jsonparse = JSON.parse($scope.UsersList);
		var a = jsonparse.indexOf($scope.ForgotUser.forgotemail);
		
		if(a==-1)
		{
			$scope.submit_success= false;
			alert(a);
		}
		else
		{
			$scope.submit_success= true;	
			c
		}*/
		var encodedString = 'forgotemail=' + $scope.ForgotUser.forgotemail;
			$http({
				method: 'GET',
				url: 'http://localhost:8080/forgotPassword?'+encodedString
			})
			.success(function(data, status, headers, config) {
				if (status == 200) {
					window.location.href = '../view/resetPassword.html?email='+$scope.ForgotUser.forgotemail;
				} else {
					alert("Unable to submit form");
					window.location.href = '../view/forgotPassword.html';
				}
			})
			.error(function(data, status, headers, config) {
				alert('Email ID entered is not valid');
				window.location.href = '../view/forgotPassword.html';
			});
		
	};
}

var ResetValidation = function($scope,$http){
	$scope.submit_success=false;
	
	$scope.reset = function()
	{
		$scope.submit_success= true;
		
		/*$scope.UsersList = '[{"email":"shipra@gmail.com","password":"12345",},{"email":"Deepika@gmail.com","password":"12345"}]';
		
		console.log($scope.UsersList);
			
		
		
		if($scope.submit_success == true)
		{
			console.log("OUTPUT xresetpass:");	
			var xresetpass = $scope.ResetUser.resetpass;
			// console.log($scope.ResetUser.resetpass);
			console.log(xresetpass);
			console.log("OUTPUT x:");
			var x = $scope.ForgotUser.forgotemail;
			// console.log($scope.ForgotUser.forgotemail);
			console.log(x);
		}*/
		
		hu = window.location.search.substring(1);
    	gy = hu.split("=");

        if (gy[0] == "email") {
           var email = gy[1];
        }

		//alert(email);
		//alert("Hi there");
		var encodedString = 'email=' + email+'&pass='+$scope.ResetUser.resetpass;
			$http({
				method: 'PUT',
				url: 'http://localhost:8080/reset?'+encodedString
			})
			.success(function(data, status, headers, config) {
				console.log(data);
				if (status == 200) {
					alert("Password has been successfully modified.Login with new Credentials");
					window.location.href = '/view/login.html';
				} else {
					alert("Password modification failed");
					$scope.errorMsg = "Error in updating password.";
				}
			})
			.error(function(data, status, headers, config) {
				$scope.errorMsg = 'Unable to submit form.';
			})
		
	};
}


