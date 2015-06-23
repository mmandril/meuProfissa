(function(){
  'use strict';

  angular.module('AdminCategoryModule').controller('AdminCategoryCtrl', AdminCategoryCtrl);
  

  function AdminCategoryCtrl ($scope, $mdDialog) {
	  $scope.newCategory = function() {
		  $mdDialog.show({
			  controller: AdminCategoryCtrl,
		      templateUrl: 'view/admin/category/new.html',
		      parent: angular.element(document.body)
		  });
	  };
	  
	  $scope.close = function() {
		  $mdDialog.hide();
	  };
  }
  
  AdminCategoryCtrl.$inject = ['$scope', '$mdDialog'];
})();