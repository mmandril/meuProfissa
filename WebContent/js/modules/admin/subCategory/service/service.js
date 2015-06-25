(function(){
  'use strict';

  angular.module('AdminModule').service('AdminSubCategoryService', AdminSubCategoryService);


  function AdminCategoryService ($http) {
	  this.save = function(subCategory) {
		return $http.post('http://localhost:9090/MeuProfissa/api/subCategory/save', subCategoryId);  
	  };
	  
	  this.list = function(categoryId) {
		return $http.get('http://localhost:9090/MeuProfissa/api/subCategory/listAll/'+categoryId);  
	  };
	  
	  this.get = function(subCategoryId) {
		return $http.get('http://localhost:9090/MeuProfissa/api/subCategory/'+subCategoryId);  
	  };
  };    

  AdminSubCategoryService.$inject = ['$http']; 
})();