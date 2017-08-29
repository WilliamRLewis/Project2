angular.module("R3App")
.controller("findUsers", function($http, $scope){
		$scope.getUsers = function(){
				alert("About to attempt get!")
			$http.get("user/all").success(function (data) {
		         alert("Winner")
		     })
		     .error(function (error) {
		         alert("Loser");
		     });
	}
	$scope.test = function(){
		alert("Success!");
	}
