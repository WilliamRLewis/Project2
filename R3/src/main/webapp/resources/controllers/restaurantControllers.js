angular.module("R3App")
.controller("findRestaurant", function($http, $scope, $location){
		$scope.data = {};
			$http.get("restaurant/all").success(function (data) {
				$scope.data = data;
		     })
		     .error(function (error) {
		         alert("You done Goofed!");
		     });
	
			$scope.loadReviews = function(restaurantId){
				$location.path("/restaurantReviews");
				$http.get("restaurant/reviews" ,{
				    headers: {'restaurantId': restaurantId}})
				.success(function(data){
					$scope.data = data;
					$route.reload();
				})
				.error(function (){
					alert("Failed to load reviews");
				});
		}
	});
/*$scope.getRestaurants = function(){
alert("About to try findAll!")*/