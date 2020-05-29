Registration.controller("Registration",function($scope,$http)
{
	$scope.submit_success=false;
	
	$scope.call = function() {
		    //alert("hhg");
			var encodedString = 'email=' + this.user.email+ '&password=' + this.user.pass+ '&firstname=' + this.user.firstname+ '&phone=' + this.user.message+'&lastname=' + this.user.lastname+'&confirmpassword=' + this.user.confirmpass;
			$http({
				method: 'POST',
				url: 'http://localhost:8080/register?'+encodedString
			})
			.success(function(data, status, headers, config) {
				console.log(data);
				if (status == 200) {
					alert("Successful Registration. Please Login");
					window.location.href = '../view/login.html';
				}
				else{
					alert("Email Id already exists");
				}
			})
			.error(function(data, status, headers, config) {
				
				if (status == 412) {
					alert("Please keep both passwords same");
				}
				else{
						window.location.href = '../view/registration.html';
				}
				//$scope.errorMsg = 'Unable to submit form';
			})
		}
}); 	
