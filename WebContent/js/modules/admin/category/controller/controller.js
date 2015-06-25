(function(){
  'use strict';

  angular.module('AdminModule').controller('AdminCategoryCtrl', AdminCategoryCtrl);
  

  function AdminCategoryCtrl ($scope, $mdDialog, AdminCategoryService, $mdToast, $rootScope) {
	  
	  $rootScope.categories = [];
	  
	  AdminCategoryService.list()
	  .success(function(data){
		  $rootScope.categories = data;
	  })
	  .error(function(err){
		  displayToast('success', 'Ocorreu um erro!');
	  });
	  
	  
	  var displayToast = function(type, msg) {
		  $mdToast.show({
			  template: '<md-toast class="md-toast ' + type +'">' + msg + '</md-toast>',
			  hideDelay: 5000,
			  position: 'top right'
		  });
	  };
	  
	  $scope.newCategory = function() {
		  $mdDialog.show({
			  controller: AdminCategoryCtrl,
		      templateUrl: 'view/admin/category/new.html',
		      parent: angular.element(document.body)
		  });
	  };
	  
	  $scope.save = function() {
		  $mdDialog.hide();
		  AdminCategoryService.save($scope.category)
		  .success(function(data){
			  $scope.category = {};
			  $rootScope.categories.push(data);
			  displayToast('success', 'Categoria cadastrada com sucesso!');
		  })
		  .error(function(err){
			  displayToast('success', 'Ocorreu um erro!');
		  });
	  };
	  
	  $scope.close = function() {
		  $mdDialog.hide();
	  };
  }
  
  AdminCategoryCtrl.$inject = ['$scope', '$mdDialog', 'AdminCategoryService', '$mdToast', '$rootScope'];
})();