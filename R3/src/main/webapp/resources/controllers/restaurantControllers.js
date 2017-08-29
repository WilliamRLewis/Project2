angular.module("R3App")
.controller("findAllRestaurantsCtrl", function($http, $scope){
		$scope.getRestaurants = function(){
				alert("About to attempt get!")
			$http.get("restaurant/all").success(function (data) {
		         alert("You Done did it")
		     })
		     .error(function (error) {
		         alert("You Done Goofed!");
		     });
	}
	$scope.test = function(){
		alert("Woo!");
	}
});