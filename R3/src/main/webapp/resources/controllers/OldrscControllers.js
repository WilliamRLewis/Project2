angular.modlue("R3App")
.constant("authUrl", "login.do")
.constant("dataUrl", "EmployeeForms.do")
.constant("submitUrl", "submitForm.do")
.constant("approveUrl", "approveForm.do")
.constant("denyUrl", "denyForm.do")
.constant("resetUrl", "resetForms.do")
.controller("formCtrl", function ($scope, $http, $location, $route, dataUrl, approveUrl, denyUrl, resetUrl){
	
	$scope.data = {};
	 $http.get(dataUrl)
     .success(function (data) {
         $scope.data = data;
     })
     .error(function (error) {
         $scope.data.error = error;
     });
	 $scope.filterBy = function(x) {
	        $scope.myFilter = {status : x} ;
	    }
	$scope.approve = function(formid){
		$http.post(approveUrl, {
			formid
		}).success(function(data){
			alert("Successfuly Approved Form!")
			$location.path("/home");
			$route.reload();
		}).error(function(error){
			alert("I'm sorry, you may not approve this form.");
		});
	}
	$scope.deny = function(formid){
		$http.post(denyUrl, {
			formid
		}).success(function(data){
			alert("Successfuly Denied Form!")
			$location.path("/home");
			$route.reload();
		}).error(function(error){
			alert("I'm sorry, you may not deny this form.");

		});
	}
	$scope.reset = function(){
		$http.post(resetUrl, {
		}).success(function(data){
			alert("Successfully reset Forms!")
			$location.path("/home");
			$route.reload();
		}).error(function(error){
			alert("Failed to reset forms");
	
		});
	}
})
.controller("authCtrl", function ($scope, $http, $location, authUrl) {

    $scope.authenticate = function (user, pass) {
       $http.post(authUrl, {
            username: user,
            password: pass           
        }).success(function (data) {
            $location.path("/home");
        }).error(function (error) {
            $scope.authenticationError = error;
        });
    }
})
.controller("submitCtrl", function ($scope, $http, $location, submitUrl){
	
	$scope.submit = function (cost, descript, reimbtype){
		$http.post(submitUrl, {
            amount: cost,
            description: descript,
            type : reimbtype
        }).success(function (data) {
            $location.path("/home");
        }).error(function (error) {
            alert("No can do");
        });
	}
	
});