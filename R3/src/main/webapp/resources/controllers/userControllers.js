angular.module("R3App")
.controller("findUsers", function($http, $scope, $location, $route, reviewListService, userService){
		$scope.data = {};
		
		$http.get("user/all")
			.success(function (data) {
				$scope.data = data;
		     })
		     .error(function (error) {
		         alert("Failed to load Users");
		     });
	
		$scope.loadReviews = function(user){
			userService.setUser(user);
			$location.path("/userReviews");
	}
		$scope.deleteUser = function(user){
			$http({
				url : "user/delete",
				datatype : "json",
				method : "DELETE",
				data : {
				"userId"   : user.userId,
				"username" :user.username,
				"password" :user.password,
				"role"	   : user.role
				},
				headers :{
					"Content-Type": "application/json"
				}
			}).success(function(response){
				alert("Deleted object");
				$route.reload();
			}).error(function(error){
				alert("Failed to delete, " + error);
			});
			
		}
})
.controller("myReviews", function($http, $scope, $location, userService){
//	$scope.data = userService.getReviews();
//	$scope.user = userService.getUser();
	
	
	$scope.updateRev = function(review){
		$http({
			url : "review/update",
			dataype : "json",
			method : "PUT",
			data : {
				"id" : review.id,
				"rating" : review.rating,
				"description" : review.description
			},
			headers: {
				"Content-Type": "application/json"
			}
		}).success(function(response){
			alert("Updated Review");
			$location.path("/userList");
		}).error(function(error){
			alert("Failed to update Review: " + error);
		});
	}
	$scope.createReview = function(rating, descript){
		
			$http.put("user/addReview", {
				"rating" : rating,
				"description" : descript
				
			})
			.success(function(data){
				alert("Form created and tied to default user");
				
			})
			.error(function(error){
				alert(error + " failed to create a new review.")
			});
			
		
		alert(" reviews" + userService.getReviews()[0] + " next " + userService.getUser().review);
//		$http({	url : "user/update",
//				dataype : "json",
//				method : "PUT",
//				data : { 
//					"userId" : userService.getUserId(),
//					"review" :	userService.getReviews(),
//					"username" : userService.getUserName(),
//					"password" :  userService.getUserPassword(),
//					"role" : userService.getRole()
//				},
//				headers: {
//					"Content-Type": "application/json"
//				}
//			}).success(function(response){
//				alert("Created a review for: " + userService.getUserName());
//				$location.path("/userList");
//			}).error(function(error){
//				alert("Failed to create a review Review: " + error);
//			});
	}
	
	
})
.controller("createUserCtrl", function ($scope, $http, $location) {
    $scope.createUser = function (user1, pass1, role1) {
       $http.post("user/create", {
    	   	"username" : user1,
            "password" : pass1,
            "role"	: role1
        }).success(function (data) {
        	alert("Great success!");
            $location.path("/home");
        }).error(function (error) {
            alert("Failed to create a new user");
        });
    }
}).controller("loginCtrl",function($scope, $http, $location){//not connected to anything
	$scope.loginUser = function(username, password){
		$http.post("login2", {
			"username" : username,
			"password" : password
		}).success(function (data) {
        	alert("Welcome!"); 
        	$scope.data2 = data2;
        	alert(data2);
            $location.path("/home");
        }).error(function (error) {
            alert("NO login for you!");
        });
    }
});