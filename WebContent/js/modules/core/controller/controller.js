(function(){
  'use strict';

  angular.module('CoreModule').controller('CoreCtrl', CoreCtrl);
  

  function CoreCtrl ($scope, $translate, CoreService, $mdToast, $animate, localStorageService) {
	  $scope.pageClass = 'animated fadeIn';
	  $scope.title = 'MeuProfissa!';
	  
	  $scope.changeTranslate = function(language) {
		  $translate.use(language);
	  };
	  
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
				 $scope.showProgress = false;
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
  
  CoreCtrl.$inject = ['$scope', '$translate', 'CoreService', '$mdToast', '$animate', 'localStorageService'];
})();