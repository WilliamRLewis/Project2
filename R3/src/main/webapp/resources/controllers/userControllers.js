angular.module("R3App")
.controller("findUsers", function($http, $scope){
		$scope.getUsers = function(){
			$http.get("/user/all").then(function(value){
				window.alert("Found new Users!")
		});
	}
	$scope.test = function(){
		alert("Success!");
	}
});