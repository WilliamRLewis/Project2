angular.module("R3App")
	.controller("createRestaurant", function($http, $scope){
		$scope.createRestaurant= function(){
			$http.post("/create/",$scope.restaurant).then(function(value){
				window.alert("New Restaurant!")
		});
	}		
});