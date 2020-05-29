
/************ Function body ***********/
var init = function($scope,$window){
	MyApp.controller("controller",FetchDataFromJSON);
	MyApp.directive('randomColoredText', randomColoredText);
}
var FetchDataFromJSON = function($scope,$http){
	$scope.listItems = [];
	$scope.sprintlistItems = [];
	$scope.mainpageitems = [];
	$scope.ScrumList = [];
	var currUser ='';
	$scope.Users = [];
	$scope.scrumarray = [];
	$scope.currUser = sessionStorage.getItem("emp-key");
	$scope.USstatus = ["Blocked","In Progress"];
	// below code will redirect user ALWAYS to the login page if user has logged out and then tries to go back to the page
	//if(sessionStorage.getItem("emp-key") == null){
		//	location.href="login.html";
	//}
	//alert(sessionStorage.getItem("emp-key"));
	//console.log(sessionStorage.getItem("emp-key"));
	
    //$http.get('./../controller/scrumdata1.json').success(function(data) {
		//$scope.listItems = angular.fromJson(data);
	 
	 $http.get('http://localhost:8080/get/scrum').success(function (data) 
			  {
			     $scope.listItems = angular.fromJson(data);
			     $scope.listItems.sort();
			     //angular.forEach($scope.listItems,function(value,key) {
			    	 //$scope.scrumarray.push({key: key, value : value})
			     //})
			     //$scope.SelectedScrum = $scope.listItems[0];
			    
			  });
	 console.log($scope.scrumarray);
	 $http.get('http://localhost:8080/get/users').success(function (data) 
			  {
			     $scope.Users = angular.fromJson(data);
			     //$scope.Users.sort();
			     //$scope.SelectedScrum = $scope.listItems[0];
			  });
	 
	//$scope.listItems1 = '';
	//});
	
	$scope.LogoutUser = function()
	{	 
		//alert(sessionStorage.getItem("emp-key"));
		//sessionStorage.removeItem("emp-key"); 
		//alert(sessionStorage.getItem("emp-key"));
		//if(sessionStorage.getItem("emp-key") == null){
			//location.href="login.html";
			//location.href="index.html";
		//}
		  // var logoutuser = '';
		  // logoutuser = $scope.$sessionStorage.clear();
		 
		  // alert('Logging out : ' + logoutuser);
		  // console.log('storage is empty',logoutuser);
		  // $location.path('/');
	};
	
	//$scope.AddScrum = function(){
		//$scope.listItems.push($scope.NewScrum);
		//console.log($scope.listItems);
	//};
	
	$scope.parJson = function (json) {
        return JSON.parse(json);
    }
	
	$scope.userStoryBlocked = function(value,BlockUS){
		//alert(BlockUS);
		$http({
				method: 'PUT',
				url: 'http://localhost:8080/update/userstory?userstoryid='+value.Id+'&userstoryname='+value.title+'&status='+BlockUS
			})
			.success(function(data, status, headers, config) {
				console.log(data);
				//if (status == 200 && data != "") {
					if (status == 200) {
					$scope.NewScrum = '';
					$scope.NewSprint = '';
					$scope.AddStory = ''; 
					$scope.sprintChanged();
					if(BlockUS == 'Blocked'){
					//alert("User Story moved to Blocking State");
					}
					if(BlockUS == 'In Progress'){
						//alert("User Story moved to In Progress State");
					}
					
				} else {
					$scope.NewScrum = '';
					$scope.NewSprint = '';
					$scope.AddStory = '';
					$scope.BlockUS = '';
					alert("Failed to Block User Story");
				}
			})
			.error(function(data, status, headers, config) {
				$scope.NewScrum = '';
				$scope.NewSprint = '';
				$scope.AddStory = ''; 
				$scope.BlockUS = '';
				alert("Server Error. Failed to Block UserStory");
		});
	};
	
	
	$scope.scrumChanged = function(){
		$scope.NewScrum = '';
		$scope.NewSprint = '';
		$scope.selectedSprint = '';
		$scope.sprintstories = '';
		$scope.sprintlistItems = '';
		$http({
			method: 'GET',
			url: 'http://localhost:8080/get/sprints?scrum='+$scope.SelectedScrum
		})
		.success(function(data, status, headers, config) {
			//console.log(data);
			//if (status == 200 && data != "") {
				if (status == 200) {
					$scope.sprintlistItems = angular.fromJson(data);
					//$scope.selectedSprint = '';
			} else {
				alert("Server Error getting the sprints for the Scrum");
			}
		})
		.error(function(data, status, headers, config) {
				alert("Bad Request");
		});
	  };
	  
	  $scope.sprintChanged = function(){
		    //$scope.sprintstories = '';
		    $scope.NewScrum = '';
			$scope.NewSprint = '';
			$http({
				method: 'GET',
				url: 'http://localhost:8080/get/userstory?scrum='+$scope.SelectedScrum+'&sprint='+$scope.SelectedSprint
			})
			.success(function(data, status, headers, config) {
				console.log(data);
				if (status == 200 && data.ScrumStories != "") {
					//if (status == 200) {
						$scope.mainpageitems = data;
						//console.log($scope.mainpageitems);
						//$scope.ScrumList = $scope.mainpageitems[0];
						//console.log($scope.mainpageitems[0]);
						//var length = data.length;
						//console.log(length);
						console.log($scope.mainpageitems.ScrumStories);
						var count = $scope.mainpageitems.ScrumStories.length;
						//console.log(count);
						
						for (i = 0; i < count; i += 1) {
					        if ($scope.mainpageitems.ScrumStories[i].sprint == $scope.SelectedSprint) {
					        	//console.log("inside here");
					        	//console.log($scope.mainpageitems.ScrumStories[i].sprint);
					        	$scope.sprintstories = $scope.mainpageitems.ScrumStories[i].SprintStories;
					        }
						}
					}
					else {
						alert("Server Error");
					}
			})
			.error(function(data, status, headers, config) {
					alert("Bad Request");
			});
		  };
	
	
	$scope.AddScrum = function($window){
		
		$http({
				method: 'POST',
				url: 'http://localhost:8080/create/team?team='+$scope.NewScrum
			})
			.success(function(data, status, headers, config) {
				console.log(data);
				//if (status == 200 && data != "") {
					if (status == 200) {
					$scope.listItems.push($scope.NewScrum);
					$scope.listItems.sort();
					$scope.NewScrum = '';
					$scope.NewSprint = '';
					$scope.SelectedScrum = '';
					$scope.SelectedSprint = '';
					$scope.sprintstories = '';
					$scope.sprintlistItems = '';
					$scope.Showme = false;
					//$('#ScrumReload').load(document.URL + ' #ScrumReload');
					//alert("Scrum Created");
				} else {
					$scope.NewScrum = '';
					$scope.NewSprint = '';
					$scope.SelectedScrum = '';
					$scope.SelectedSprint = '';
					$scope.sprintstories = '';
					$scope.sprintlistItems = '';
					$scope.Showme = false;
					alert("Scrum already exists");
				}
					//$window.location.reload();
			})
			.error(function(data, status, headers, config) {
				if(status == 208){
					$scope.NewScrum = '';
					$scope.NewSprint = '';
					$scope.SelectedScrum = '';
					$scope.SelectedSprint = '';
					$scope.sprintstories = '';
					$scope.sprintlistItems = '';
					$scope.Showme = false;
					alert("Scrum already exists");
				}
				if(status == 400){
					$scope.NewScrum = '';
					$scope.NewSprint = '';
					$scope.SelectedScrum = '';
					$scope.SelectedSprint = '';
					$scope.sprintstories = '';
					$scope.sprintlistItems = '';
					$scope.Showme = false;
					alert("Bad Request");
				}
				//$window.location.reload();
		});
	};
	
	$scope.AddSprint = function($window){
		if($scope.SelectedScrum == '' || $scope.SelectedScrum == null || $scope.SelectedScrum == "Select Scrum"){
			
			alert("Select a Scrum to create Sprint");
		}
		else{
			$http({
				method: 'POST',
				url: 'http://localhost:8080/sprintteam/create?team='+$scope.SelectedScrum+'&sprint='+$scope.NewSprint
			})
			.success(function(data, status, headers, config) {
				//console.log(data);
				//if (status == 200 && data != "") {
					if (status == 200) {
						//alert("Sprint Created");
						$scope.sprintlistItems.push($scope.NewSprint);
						$scope.sprintlistItems.sort();
						$scope.NewSprint = '';
						$scope.NewScrum = '';
				} else {
						alert("Sprint already Exists");
						$scope.NewSprint = '';
						$scope.NewScrum = '';
				}
					//$window.location.reload();
			})
			.error(function(data, status, headers, config) {
				$scope.NewSprint = '';
				$scope.NewScrum = '';
				alert("Bad request");
				//$window.location.reload();
		});
		}
		//console.log($scope.listItems);
	};
	
	
	$scope.AddScrumStory = function(){
		if($scope.AddStory == '')
		{
			alert("UserStory contains no information. Make a valid UserStory ");
			$scope.NewScrum = '';
			$scope.NewSprint = '';
		}
		else{
		$http({
				method: 'POST',
				url: 'http://localhost:8080/create/userstory?userstoryname='+$scope.AddStory+'&scrum='+$scope.SelectedScrum+'&sprint='+$scope.SelectedSprint
			})
			.success(function(data, status, headers, config) {
				console.log(data);
				//if (status == 200 && data != "") {
					if (status == 200) {
					$scope.NewScrum = '';
					$scope.NewSprint = '';
					$scope.AddStory = ''; 
					$scope.sprintChanged();
					//alert("User Story Created");
					
				} else {
					$scope.NewScrum = '';
					$scope.NewSprint = '';
					$scope.AddStory = ''; 
					alert("User Story already exists");
				}
			})
			.error(function(data, status, headers, config) {
				$scope.NewScrum = '';
				$scope.NewSprint = '';
				$scope.AddStory = ''; 
				alert("Failed to create UserStory");
		});
	}
};

$scope.cancel = function () {
	//alert("Inside cancel function");
    $scope.NewScrum = '';
    $scope.NewSprint = '';
    $scope.AddStory = '';
	$scope.sprintChanged();
};
	
	$scope.DeleteTasks = function(value){
		//console.log(value.story);
		//alert(value.story);
		if (confirm("Do you want to delete the task?") == true) {
		
		$http({
			method: 'DELETE',
			url: 'http://localhost:8080/delete/task?taskid='+value.story
		})
		.success(function(data, status, headers, config) {
			//console.log(data);
			//if (status == 200 && data != "") {
				if (status == 200) {
				$scope.NewScrum = '';
				$scope.NewSprint = '';
				$scope.AddStory = ''; 
				$scope.sprintChanged();
				//alert("Task Deleted");
				$('#USModal').modal('hide');
			} else {
				$scope.NewScrum = '';
				$scope.NewSprint = '';
				$scope.AddStory = ''; 
				//$scope.sprintChanged();
				alert("Failed to delete task");
				$('#USModal').modal('hide');
			}
		})
		.error(function(data, status, headers, config) {
			$scope.NewScrum = '';
			$scope.NewSprint = '';
			$scope.AddStory = ''; 
			//$scope.sprintChanged();
			alert("Bad Request");
			$('#USModal').modal('hide');
	});	
	}	
};
	
	$scope.DeleteScrumStory = function(value){
		//console.log(value.Id);
		$scope.NewScrum = '';
		$scope.NewSprint = '';
		$scope.AddStory = '';
		
		if (confirm("Deleting UserStory will delete all tasks with it. Do you want to Continue?") == true) {
		
		$http({
			method: 'DELETE',
			url: 'http://localhost:8080/delete/userstory?userstoryid='+value.Id
		})
		.success(function(data, status, headers, config) {
			console.log(data);
			//if (status == 200 && data != "") {
				if (status == 200) {
				//alert("User Story Deleted");
				$scope.AddStory = ''; 
				$scope.sprintChanged();
			} else {
				alert("User Story Deletion failed");
			}
		})
		.error(function(data, status, headers, config) {
			alert("Bad Request");
	});
	}
	};
	
	$scope.AssignTo = '';
	
	$scope.saveTask = function(value)
	 {	
		var flag = 0;
		console.log("here");
		//console.log("here");
		//console.log($scope.value.Id);
		console.log(value);
		console.log("inside savetask");
		console.log($scope.Tasks.task1);
		console.log($scope.Tasks.date);
		console.log("user:");
		console.log($scope.Tasks.UserList); 
		console.log($scope.selectedSprintStory);
		
		
		var taskname = $scope.Tasks.task1;
		var taskdate = $scope.Tasks.actdate;
		//var date 	 = convert(taskdate);
		if(taskdate == 'undefined'){
			alert("Select a valid ETA date");
		}
		else{
			var date 	 = convert(taskdate);
		}
		
		var user 	 = $scope.Tasks.UserList;	
		//var uid 	 = document.getElementById("UID").value;
		
		var currDate = new Date();
		console.log(currDate);
		console.log("UID");
		console.log($scope.UID);
		console.log(date);
		
		if(taskdate < currDate){
			
			alert("Please select current or future date!");
			flag = 0;
		}	else 
			{
				flag = 1;
			}	
		
		if( flag == 1 )
		{
			//$scope.EditTaskObj = '';
			//$scope.previousdate = date;
			
			//$scope.EditTaskObj.taskdesc = taskname;
		
			//$scope.EditTaskObj.date = date;
			//$scope.EditTaskObj.owner = user;
			//alert('Task : ' + taskname + ', Date : ' + taskdate + ', Assigned To :' + user );
			$('#USModal').modal('hide');
			$(".modal").on("hidden.bs.modal", function() {
	                $(this).find('select#AssignToNew').val("");
	                $(this).find('textarea#task1New').val("");
	                $(this).find('input#dateNew').val("");
	                //$(this).find('input#task1New#required').val("true");
	                //$(this).find('span#newSpan').val("");
			  });
			if(taskdate == 'undefined' || owner == 'undefined' || taskname == 'undefined')
			{
				alert("All the fields are required");
			}else
			{
				var encodedString = 'taskname=' + taskname + '&taskdate=' + date + '&owner=' + user + '&userstoryid=' + $scope.UID;
				$http({
					method: 'POST',
					url: 'http://localhost:8080/create/task?'+encodedString
				}).success(function(data, status, headers, config) {
					console.log(data);
					if (status == 200 && data != "") {
					//$scope.NewScrum = '';
					//$scope.NewSprint = '';
						$scope.AddStory = ''; 
						$scope.sprintChanged();
					///alert("Task Created");
					//window.location.href = 'index.html?Id='+1;
					} else {
						$scope.NewScrum = '';
						$scope.NewSprint = '';
						$scope.AddStory = ''; 
					//$scope.sprintChanged();
						alert("Task cannot be created. Consider filling all fields or task is already existing");
						$scope.errorMsg = "Unable to save data. Please try again.";
					}
				})
				.error(function(data, status, headers, config) {
				$scope.errorMsg = 'Unable to submit data';
			});
		}
		}
		
	 };
	 
	 $scope.openTask = function(value){
		 console.log("inside OpenTask");
		 console.log(value);
		 $scope.UID = value;
		 console.log($scope.UID);
	 };
	 
	$scope.editTask = function(getvalue,$http)
			{
				console.log("inside editTask");
				var gettask = $scope.getvalue;
				// gets the value 'story5'
				console.log("getvalue = ",getvalue);

				$scope.edittaskList = '';
					 $scope.edittaskList = $scope.getvalue; 
					//console.log('edittasklist array:-',$scope.edittaskList);
					
					console.log('task title : ',getvalue.story);
					console.log('task description',getvalue.description);
					console.log('task date', getvalue.Date);
					console.log('task owner', getvalue.Owner);
					
					$scope.EditTaskObj = this;
					$scope.previousdate = getvalue.Date;
					
					$scope.EditTaskObj.title = getvalue.story;
					$scope.EditTaskObj.taskdesc = getvalue.description;
				
					$scope.EditTaskObj.date = getvalue.Date;
					$scope.EditTaskObj.actdate = new Date(getvalue.Date); 
					$scope.EditTaskObj.owner = getvalue.Owner;
					$scope.EditTaskObj.status = getvalue.Status;
			}; 
			
	$scope.saveEditedTask = function(value)
	 {	
		var flag = 0;
		
		console.log($scope.EditTaskObj.taskdesc);
		console.log($scope.EditTaskObj.date2);
		console.log("user:");
		console.log($scope.EditTaskObj.owner2); 
		console.log($scope.listItemslistItems);
		
		var taskname = $scope.EditTaskObj.taskdesc;
		var taskdate = $scope.EditTaskObj.actdate;
		taskdate = convert(taskdate);
		var user 	 = $scope.EditTaskObj.owner;
		var status = $scope.EditTaskObj.status;
		if(status == '')
		{
			status = 'Opened';
			}
		
		var currDate = new Date();
		console.log(currDate);
		
		if(taskdate < currDate){
			
			alert("Please select current or future date!");
			flag = 0;
		}	else 
			{
				flag = 1;
			}	
		
		if( flag == 1 )
		{
			//alert('Task : ' + taskname + ', Date : ' + taskdate + ', Assigned To :' + user );
			$('#EditTaskModal').modal('hide');
			$(".modal").on("hidden.bs.modal", function() {
			    //$(".modal-body").html("");
			    //$(".modal-footer").html("");
			  });
			if(taskdate == 'undefined' || owner == 'undefined' || taskname == 'undefined')
			{
				alert("All the fields are required");
			}
			else{
				var encodedString = 'description=' + taskname + '&taskdate=' + taskdate + '&owner=' + user + '&taskid=' + value + '&status=' + status ;
				$http({
					method: 'PUT',
					url: 'http://localhost:8080/update/task?'+encodedString
				}).success(function(data, status, headers, config) {
					console.log(data);
					if (status == 200) {
					$scope.NewScrum = '';
					$scope.NewSprint = '';
					$scope.AddStory = ''; 
					$scope.sprintChanged();
					 //alert("Task Updated Successfully!!");
					} else {
						$scope.errorMsg = "Unable to save data. Please try again.";
						alert("Failed to save Task");
					}
				})
				.error(function(data, status, headers, config) {
				$scope.errorMsg = 'Unable to submit data';
				});
		}
		
		}
	 };
	 
	Editable($scope);
} 
	var Editable = function($scope){
	$scope.editTodo = function(todo){
		todo.editing=true;
    };
    
	
	
    $scope.doneEditing = function (elem) {
        if (! angular.element(elem.target).hasClass('editable')) {
           angular.forEach($scope.sprintstories, function (key, value) {
			    angular.forEach(key.ScrumStories, function (key1, value1) {
					angular.forEach(key1.SprintStories, function (key2, value2) {
						key2.editing = false;
					});
				});
            });
        }
    };
}

var randomColoredText = function(){
	function getRandomColor() {
    	var letters = '0123456789ABCDEF'.split('');
    	var color = '#';
    	for (var i = 0; i < 6; i++ ) {
        	color += letters[Math.floor(Math.random() * 16)];
    	}
    	return color;
	}
	return {
    	link: function(scope, element, attributes){
            element.css('backgroundColor', getRandomColor());
        }
    }
}

function convert(str) {
	var month = (str.getMonth() + 1).toString();
    month = month.length > 1 ? month : '0' + month;
    var day = str.getDate().toString();
    day = day.length > 1 ? day : '0' + day;
    return str.getFullYear() + '-' + month + '-' + day;
	}

/*** Fetch Data from JSON ****/
init();
