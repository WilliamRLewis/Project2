angular.module("R3App")
.controller("createReviewCtrl", function($http, $scope, $location){

	$scope.createReview = function(rating, description){
	$http.post("review/create", {
		"rating" : rating,
		"description" : description
	})
	.success(function(data){
		alert("Successfully submitted form data!")
		$location.path("/userReviews")
	})
	.error(function(error){
		alert(error + " failed to create a new review.")
	});
	
	}
	
})
.controller("allReviewsCtrl", function($http, $scope, $location, $route){
	
	$scope.data = {};
	$http.get("review/all")
	.success(function(data){
		$scope.data = data;
	})
	.error(function(error){
		alert("Failure " + error);
	});
	
	$scope.destroyRev = function(review){
	$http({
		url : "review/delete",
		dataType : 'json',
		method: "DELETE",
		data: {
			"id" : review.id,
			"rating" : review.rating,
			"description" : review.description
		},
		headers: {
			"Content-Type": "application/json"
		}
	}).success(function(response){
		alert("Deleted object");
		$route.reload();
	}).error(function(error){
		alert("Failed to delete, " + error);
	});
	}
	
});