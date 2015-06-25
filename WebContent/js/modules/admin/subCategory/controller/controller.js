(function(){
  'use strict';

  angular.module('AdminModule').controller('AdminSubCategoryCtrl', AdminSubCategoryCtrl);
  

  function AdminSubCategoryCtrl ($scope, $mdDialog, AdminCategoryService, $mdToast, $rootScope, $stateParams, AdminSubCategoryService) {
	  var categoryId = $stateParams.categoryId;
	  console.log(categoryId);
	  
	  
	  AdminCategoryService.get(categoryId)
	  .success(function(data){
		  $scope.category = data;
	  })
	  .error(function(err){
		  
	  });
	  
	  AdminSubCategoryService.list(categoryId)
	  .success(function(data){
		  $scope.subCategories = data;
	  })
	  .erro(function(err){
		  
	  });
  }
  
  AdminSubCategoryCtrl.$inject = ['$scope', '$mdDialog', 'AdminCategoryService', '$mdToast', '$rootScope', '$stateParams', 'AdminSubCategoryService'];
})();