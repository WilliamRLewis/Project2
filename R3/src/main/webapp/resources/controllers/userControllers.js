angular.module("R3App")
.controller("findUsers", function($http, $scope, $location, $route){
		$scope.data = {};
			$http.get("user/all")
			.success(function (data) {
				$scope.data = data;
		     })
		     .error(function (error) {
		         alert("Failed to load Users");
		     });
	
		$scope.loadReviews = function(){
			$location.path("/userReviews");
			$http.get("user/reviews" ,{
			    headers: {'userId': userId}})
			.success(function(data){
				$scope.data = data;
				$route.reload();
			})
			.error(function (){
				alert("Failed to load reviews");
			});
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
