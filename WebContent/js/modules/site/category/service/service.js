(function(){
  'use strict';

  angular.module('SiteModule').service('CategoryService', CategoryService);


  function CategoryService ($http) {
	  this.get = function() {
		return $http.get('http://localhost:9090/MeuProfissa/api/category/listAll');  
	  };
  };    

  CategoryService.$inject = ['$http']; 
})();