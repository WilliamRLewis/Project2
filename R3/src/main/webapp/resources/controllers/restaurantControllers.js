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
.controller("createUserCtrl", function ($scope, $http, $location, createUrl) { //test controller to route user create info to usercontroller.create

    $scope.authenticate = function (user, pass) {
       $http.post(createUrl, {
            id		:id,
    	   	username: user,
            password: pass,
            role	:id
        }).success(function (data) {
            $location.path("/home");
        }).error(function (error) {
            $scope.authenticationError = error;
        });
    }
});