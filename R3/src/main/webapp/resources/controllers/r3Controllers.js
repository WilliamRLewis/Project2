angular.module("R3App", [ "ngRoute"]).config(
		function($routeProvider) {
			$routeProvider.when("/login", {
				templateUrl : "views/login.html"
			}).when("/test", {
				templateUrl : "views/test.html"
			}).when("/restaurantList", {
				templateUrl : "views/restaurant.html"
			}).when("/userList", {
				templateUrl : "views/userList.html",
				controller  : 'findUsers',
			    controllerAs: 'controller'
			}).when("/userReviews", {
				templateUrl : "views/userReviews.html",
				controller  :  "myReviews",
				controllerAs: 'controller'
			}).when("/createRestaurant",{
				templateUrl : "views/createRestaurant.html",
				controller  : "createRestaurantCtrl",
				controllerAs: 'controller'
			}).when("/createUser", {
				templateUrl : "views/createNewUser.html",
				controller  : "createUserCtrl",
				controllerAs: 'controller'
			}).when("/createReview",{
				templateUrl : "views/createReview.html",
				controller  : "createReviewCtrl",
				controllerAs: 'controller'
			}).when("/updateReview",{
				templateUrl : "views/createReview.html",
				controller  : "updateReviewCtrl",
				controllerAs: 'controller'
			}).when("/allReviews",{
				templateUrl : "views/reviews.html",
				controller  : "allReviewsCtrl",
				controllerAs: "controller"
			}).otherwise({
				redirectTo : "/login"
			});
		})
.controller("HeaderController", function HeaderController($scope, $location) 
{ 
    $scope.isActive = function (viewLocation) { 
        return viewLocation === $location.path();
    };
});

