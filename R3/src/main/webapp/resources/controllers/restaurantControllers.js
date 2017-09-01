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
})
.controller("createRestaurant", function($http, $scope){
	 $scope.createRestaurant = function (user1, pass1, role1) {
	       $http.post("restaurant/create", {
	    	   	"restaurantName" : name,
	    	   	"type" : type,
	    	   	"address" : address,
	    	   	"restaurantHours" : hours,
	    	   	"phoneNumber" : phone,
	    	   	"foundingDate" : founding,//SweetbabyJesushow?
	    	   	"owner" : owner //maybe do it server side?
	        }).success(function (data) {
	        	alert("Great success!");
	            $location.path("/home");
	        }).error(function (error) {
	            alert("Failed to create a new user");
	        });
	    }
	});