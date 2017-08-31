angular.module("R3App")
.controller("findUsers", function($http, $scope, $location, $route){
		$scope.data = {};
			$http.get("user/all").success(function (data) {
				$scope.data = data;
		     })
		     .error(function (error) {
		         alert("Failed to load Users");
		     });
	
		$scope.loadReviews = function(userId){
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
});
