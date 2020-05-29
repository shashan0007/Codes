
/************ Function body ***********/
var init = function($scope){
	MyApp.controller("controller",FetchDataFromJSON);
	MyApp.directive('randomColoredText', randomColoredText);
}
var FetchDataFromJSON = function($scope,$http){
	$scope.listItems = '';
    $http.get('./../controller/scrumdata1.json').success(function(data) {
		$scope.listItems = angular.fromJson(data);
	});
	//MyApp.controller("controller",Editable);
	Editable($scope);
} 
var Editable = function($scope){
	$scope.editTodo = function(todo){
		todo.editing=true;
    };
        
    $scope.doneEditing = function (elem) {
        if (! angular.element(elem.target).hasClass('editable')) {
           angular.forEach($scope.listItems, function (key, value) {
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

/*** Fetch Data from JSON ****/
init();
