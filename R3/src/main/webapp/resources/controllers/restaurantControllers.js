angular.module("R3App")
.controller("findRestaurant", function($http, $scope, $location){
		$scope.data = {};
		$scope.getRestaurants = function(){
				alert("About to try findAll!")
			$http.get("user/all").success(function (data) {
				$scope.data = data;
		     })
		     .error(function (error) {
		         alert("You done Goofed!");
		     });
	}
		$scope.loadReviews = function(){
			$location.path("/userReviews");
	}
});
