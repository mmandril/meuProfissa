(function(){
  'use strict';

  angular.module('AdminModule').service('AdminCategoryService', AdminCategoryService);


  function AdminCategoryService ($http) {
	  this.save = function(category) {
		return $http.post('http://localhost:9090/MeuProfissa/api/category/save', category);  
	  };
	  
	  this.list = function() {
		return $http.get('http://localhost:9090/MeuProfissa/api/category/listAll');  
	  };
	  
	  this.get = function(categoryId) {
		return $http.get('http://localhost:9090/MeuProfissa/api/category/'+categoryId);  
	  };
  };    

  AdminCategoryService.$inject = ['$http']; 
})();