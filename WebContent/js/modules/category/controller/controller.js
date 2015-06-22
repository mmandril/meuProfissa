(function(){
  'use strict';

  angular.module('CategoryModule').controller('CategoryCtrl', CategoryCtrl);


  function CategoryCtrl ($scope, $filter, CategoriaService, localStorageService) {
	  
	  console.log(localStorageService.get('token'))
	  
	  $scope.showProgress = true;
	  
	  $scope.categorys = [];
	  CategoriaService.get()
	  .success(function(data){
		  $scope.categorys = data;
		  $scope.showProgress = false;
	  })
	  .error(function(err){
		 console.log(err); 
		 $scope.showProgress = false;
	  });
	  
  };    

  CategoryCtrl.$inject = ['$scope', '$filter', 'CategoryService', 'localStorageService']; 
})();