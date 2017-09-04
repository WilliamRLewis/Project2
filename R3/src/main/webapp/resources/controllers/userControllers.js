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
			//Set reviews and user service
			reviewListService.setReviews(user.review);
			//Might not need this later or need it only for admin functions as ideally a user would only update their own reviews.
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
.controller("myReviews", function($http, $scope){
	$scope.data ={};
		$http.get("user/reviews")
		.success(function(data){
			$scope.data = data;
		})
		.error(function(){
			alert("Failed to load reviews");
		});
	
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
});
