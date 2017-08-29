/**
 * 
 */
angular.module("R3App", ["ngRoute"]);
angular.module("R3App")
	.config(function($locationProvider, $routeProvider) {
		$locationProvider.hashPrefix("");
		$routeProvider.when("/create", {
			templateUrl: "create.html",
			controller: "createController"
		}).when("/login", {
			templateUrl: "reviews.html",
			controller: "loginController"
		}).when("/list", {
			templateUrl: "list.html",
			controller: "listController"
		}).otherwise("/nowhere",{
			templateUrl:"index.html"
		});
	});

