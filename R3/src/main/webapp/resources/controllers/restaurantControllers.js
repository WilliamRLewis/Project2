angular.module("R3App")
.controller("findRestaurant", function($http, $scope, $location, $route, restaurantService){
		$scope.data = {};
			$http.get("restaurant/all").success(function (data) {
				$scope.data = data;
		     })
		     .error(function (error) {
		         alert("You done Goofed!");
		     });
	
			$scope.loadReviews = function(restaurant){
				
				$http.get("restaurant/reviews" ,{
				    headers: {'restaurantId': restaurant.restaurantId}})
				.success(function(data){
					$scope.data = restaurantService.setRestaurant(data);
					$location.path("/restaurantReviews");
				})
				.error(function (){
					alert("Failed to load reviews");
				});
		}
			$scope.deleteRestaurant = function(restaurant){
				$http({
					url : "restaurant/delete",
					datatype : "json",
					method : "DELETE",
					data : {
					"restaurantId"   :restaurant.restaurantId,
					"restaurantName" :restaurant.restaurantName,
					"type"			 :restaurant.type,
					"address"	  	 :restaurant.address,
					"restaurantHours":restaurant.restaurantHours,
					"phoneNumber"	 :restaurant.phoneNumber,
					//"foundingDate"	 :restaurant.foundingDate,
					"description"	 :restaurant.description,
					"owner"			 :restaurant.owner
					},
					headers :{
						"Content-Type": "application/json"
					}
				}).success(function(response){
					alert("Deleted Restaurant");
					$route.reload();
				}).error(function(error){
					alert("Failed to delete, " + error);
				});
				
			}
		$scope.updateDetails = function(restaurant){
			restaurantService.setRestaurant(restaurant);
			$location.path("/updateRestaurant");
			}
		
})
.controller("restReviewsCtrl", function($http, $scope, $location, restaurantService){
	$scope.data = restaurantService.getRestaurant()
	alert(data + " first " + data[0]);
})
.controller("updateRestaurantCtrl", function($http, $scope, $location, restaurantService){
		$scope.data = restaurantService.getRestaurant();
		alert(restaurantService.getRestaurant().owner.username);
		 $scope.updateRestaurant = function (restaurantName, type, address, hours, phoneNumber, foundingDate, description) {  
			 	alert(foundingDate);
		       $http.put("restaurant/update", {
		    	   	"restaurantId" : restaurantService.getRestaurant().restaurantId,
		    	   	"restaurantName" : restaurantName,
		    	   	"type" : type,
		    	   	"address" : address,
		    	   	"restaurantHours" : hours,
		    	   	"phoneNumber" : phoneNumber,
		    	   	//"foundingDate" : foundingDate,
		    	   	"description"  : description,
		    	  	"owner" : restaurantService.getRestaurant().owner
		        }).success(function (data) {
		        	alert("Great success!");
		            $location.path("/home");
		        }).error(function (error) {
		            alert("Failed to create a new restaurant");
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
	    	  // "foundingDate" : foundingDate,
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