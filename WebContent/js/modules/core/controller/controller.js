(function(){
  'use strict';

  angular.module('CoreModule').controller('CoreCtrl', CoreCtrl);
  angular.module('CoreModule').controller('LoginCtrl', LoginCtrl);


  function CoreCtrl ($scope, $translate) {
	  $scope.pageClass = 'animated fadeIn';
	  $scope.title = 'PTO!';
	  
	  
	  
	  
	  $scope.changeTranslate = function(language) {
		  $translate.use(language);
	  };
  }
  
  
  function LoginCtrl ($scope, CoreService, $mdToast, $animate) {
	  $scope.pageClass = 'animated fadeIn';
	  $scope.toastPosition = {
	    bottom: false,
	    top: true,
	    left: false,
	    right: true
	  };
	  $scope.getToastPosition = function() {
	    return Object.keys($scope.toastPosition)
	      .filter(function(pos) { return $scope.toastPosition[pos]; })
	      .join(' ');
	  };
	  
	  
	  
	  $scope.signup = function() {
		  console.log($scope.user);
		  CoreService.signup($scope.user)
		  .success(function(){
			  $mdToast.show(
			      $mdToast.simple()
			        .content('Usuário cadastrado com sucesso!')
			        .position($scope.getToastPosition())
			        .hideDelay(3000)
			    );
			  
			  $scope.user = {};
		  })
		  .error(function(err){
			  console.log(err);
		  });
	  };
  }

  CoreCtrl.$inject = ['$scope', '$translate'];
  LoginCtrl.$inject = ['$scope', 'CoreService', '$mdToast', '$animate']; 
})();