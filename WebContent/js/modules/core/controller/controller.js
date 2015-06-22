(function(){
  'use strict';

  angular.module('CoreModule').controller('CoreCtrl', CoreCtrl);
  

  function CoreCtrl ($scope, $translate, CoreService, $mdToast, $animate, localStorageService, $state, $rootScope) {
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
		  .success(function(user) {
			  localStorageService.set('user', user.loginToken);
			  
			  CoreService.getMenu(user.loginToken)
			  .success(function(menu){
				 localStorageService.set('menu', menu);
				 console.log(menu);
				 $rootScope.menu = menu;
				 $scope.showProgress = false;
				 
				 console.log(user);
				 if(user.profile.id == 1) {
					 $state.go('admin');
				 }
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
  
  CoreCtrl.$inject = ['$scope', '$translate', 'CoreService', '$mdToast', '$animate', 'localStorageService', '$state', '$rootScope'];
})();