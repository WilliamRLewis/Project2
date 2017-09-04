var app = angular.module("R3App")
app.service('userService', function() {
	this.userData = {
		"userId" : 0,
		"username" : "NoOne",
		"password" : "Invalid",
		"role" : "Invalid",
		"review" : []
	};

	this.getUser = function() {
		return this.userData;
	},

	this.setUser = function(user) {
		this.userData = user;
	}, this.setUserId = function(id) {
		this.userData.userId = id;
	}, this.setUserName = function(name) {
		this.userData.username = name;
	}, this.setUserPassword = function(pass) {
		this.userData.password = pass;
	}, this.setRole = function(role) {
		this.userData.role = role;
	}, this.getUserId = function(id) {
		return this.userData.userId;
	}, this.getUserName = function(name) {
		return this.userData.username;
	}, this.getUserPassword = function(pass) {
		return this.userData.password;
	}, this.getRole = function(role) {
		return this.userData.role;
	}, this.addReview = function(review) {
		this.userData.review.push(review);
	}, this.removeReview = function(review) {
		this.userData.review = this.userData.review.filter(function(item) {
			return item !== review
		});

	}, this.clearReviews = function() {
		this.userData.review = [];
	}, this.getReviews = function() {
		return this.userData.review;
	}

});
app.service('reviewListService', function() {
	this.reviewData = [];

	this.getReviews = function() {
		return this.reviewData;
	}, this.setReviews = function(reviews) {
		this.reviewData = reviews;
	}, this.addReview = function(review) {
		this.reviewData.push(review)
	}
});
app.service('idHolderService', function(){
	this.id = 0;
	
	this.getId = function(){
		return this.id
	},
	this.setId = function(id){
		this.id = id;
	}
});

// app.service('restaurantService', function() {
// this.userData = {
// "restaurantName" : restaurantName,
// "type" : type,
// "address" : address,
// "restaurantHours" : hours,
// "phoneNumber" : phoneNumber,
// // "foundingDate" : foundingDate,//SweetbabyJesushow?
// "description" : description,
// "owner" : {
// "userId": 72,
// "username": "Bob",
// "password": "Pass",
// "role": "Winner",
// "review": [
// {
// "id": 85,
// "rating": 3,
// "description": "TestReview"
// }
// ]
//	  		
// }
// }
//
// this.getUser = function() {
// return this.userData;
// },
//
// this.setUser = function (user){
// this.userData = user;
// },
// this.setUserId = function(id) {
// this.userData.userId = id;
// },
// this.setUserName = function(name){
// this.userData.username = name;
// },
// this.setUserPassword = function(pass){
// this.userData.password = pass;
// },
// this.setRole = function(role){
// this.userData.role = role;
// },
// this.addReview = function(review){
// review.push(review);
// },
// this.removeReview = function(review){
// //Todo
// }
// this.clearReviews = function(){
// this.userData.review = [];
// }
//	  
//	  
// });
