angular.module("R3App",["ngRoute"]);
angular.module("R3App")
.config(function($locationProvider, $routeProvider) {
	$locationProvider.hashPrefix("");
	$routeProvider.when("/login", {
		templateUrl: "reviews.html",
		controller: "loginController"
	});
});