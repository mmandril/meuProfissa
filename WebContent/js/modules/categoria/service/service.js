(function(){
  'use strict';

  angular.module('CategoryModule').service('CategoryService', CategoryService);


  function CategoryService ($http) {
	  this.get = function() {
		return $http.get('http://localhost:9090/PTO/api/category/listAll');  
	  };
  };    

  CategoryService.$inject = ['$http']; 
})();