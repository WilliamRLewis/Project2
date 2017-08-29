angular.module("R3App")
.controller("findUsers", function($http, $scope, $location){
		$scope.data = {};
		$scope.getUsers = function(){
				alert("About to attempt get!")
			$http.get("user/all").success(function (data) {
				$scope.data = data;
		     })
		     .error(function (error) {
		         alert("Loser");
		     });
	}
		$scope.loadReviews = function(){
			$location.path("/userReviews");
	}
});
