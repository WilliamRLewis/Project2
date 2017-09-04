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
.controller("createRestaurantCtrl", function($http, $scope, $location){
	 $scope.createRestaurant = function (restaurantName, type, address, hours, phoneNumber, foundingDate, description) {  
		 	alert(foundingDate);
	       $http.post("restaurant/create", {
	    	   	"restaurantName" : restaurantName,
	    	   	"type" : type,
	    	   	"address" : address,
	    	   	"restaurantHours" : hours,
	    	   	"phoneNumber" : phoneNumber,
	    	  // 	"foundingDate" : foundingDate,//SweetbabyJesushow?
	    	   	"description"  : description,
	    	  	"owner" : {
	                "userId": 72,
	                "username": "Bob",
	                "password": "Pass",
	                "role": "Winner",
	                "review": [
	                    {
	                        "id": 85,
	                        "rating": 3,
	                        "description": "TestReview"
	                    }
	                    ]
	    	  		
	    	  	} 
	        }).success(function (data) {
	        	alert("Great success!");
	            $location.path("/home");
	        }).error(function (error) {
	            alert("Failed to create a new restaurant");
	        });
	    }
	});