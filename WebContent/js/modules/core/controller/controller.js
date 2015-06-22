(function(){
  'use strict';

  angular.module('CoreModule').controller('CoreCtrl', CoreCtrl);
  angular.module('CoreModule').controller('LoginCtrl', LoginCtrl);
  

  function CoreCtrl ($scope, $translate) {
	  $scope.pageClass = 'animated fadeIn';
	  $scope.title = 'MeuProfissa!';
	  
	  
	  
	  
	  $scope.changeTranslate = function(language) {
		  $translate.use(language);
	  };
  }
  
  
  function LoginCtrl ($scope, CoreService, $mdToast, $animate, localStorageService) {
	  
	  var displayToast = function(type, msg) {
		  $mdToast.show({
			  template: '<md-toast class="md-toast ' + type +'">' + msg + '</md-toast>',
			  hideDelay: 5000,
			  position: 'top right'
		  });
	  };
	  
	  $scope.pageClass = 'animated fadeIn';	  
	  
	  $scope.signup = function() {
		  $scope.showProgress = true;
		  CoreService.signup($scope.user)
		  .success(function(){
			  displayToast('success', 'Usuário cadastrado com sucesso!');
			  $scope.user = {};
			  $scope.showProgress = false;
		  })
		  .error(function(err){
			  displayToast('.error', 'Ocorreu um erro!');
			  $scope.showProgress = false;
		  });
	  };
	  
	  $scope.login = function() {
		  $scope.showProgress = true;
		  CoreService.login($scope.userLogin)
		  .success(function(token) {
			  console.log(token);
			  localStorageService.set('token', token);
			  
			  CoreService.getMenu(token)
			  .success(function(menu){
				 localStorageService.set('menu', menu);
				 console.log(menu);
				 $scope.menu = menu;
			  })
			  .error(function(err){
				  //tratar erro
			  });
		  })
		  .error(function(err){
			  displayToast('.error', 'Ocorreu um erro!');
			  $scope.showProgress = false;
		  });
	  };	  
  }

  CoreCtrl.$inject = ['$scope', '$translate'];
  LoginCtrl.$inject = ['$scope', 'CoreService', '$mdToast', '$animate', 'localStorageService']; 
})();