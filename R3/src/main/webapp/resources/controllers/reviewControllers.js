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
	
});