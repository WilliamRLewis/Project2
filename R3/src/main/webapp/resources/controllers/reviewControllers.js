angular.module("R3App")
.controller("createReviewCtrl", function($http, $scope, $location){

	$scope.createReview = function(id, rating, description){
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
.controller("allReviewsCtrl", function($http, $scope, $location, $route, idHolderService){
	
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
	$scope.updateRev = function(review){
		idHolderService.setId(review.id)
		$location.path("/updateReview");
	}
	
})
.controller("updateReviewCtrl", function($http, $scope, $location, idHolderService){
	
	$scope.createReview = function(rating, description){
	$http.put("review/update", {
		"id" : idHolderService.getId(),
		"rating" : rating,
		"description" : description
		
	})
	.success(function(data){
		alert("Successfully updated form data!");
		$location.path("/allReviews");
	})
	.error(function(error){
		alert(error + " failed to create a new review.");
	});
	
	}
	
});