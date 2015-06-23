(function(){
  'use strict';

  angular.module('AdminCategoryModule').service('AdminCategoryService', AdminCategoryService);


  function AdminCategoryService ($http) {
	  this.save = function(category) {
		return $http.post('http://localhost:9090/MeuProfissa/api/category/save', category);  
	  };
	  
	  this.list = function() {
		return $http.get('http://localhost:9090/MeuProfissa/api/category/listAll');  
	  };
  };    

  AdminCategoryService.$inject = ['$http']; 
})();