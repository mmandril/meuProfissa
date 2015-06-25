(function(){
  'use strict';

  angular.module('SiteModule').service('CoreService', CoreService);


  function CoreService ($http) {
	  this.signup = function(user) {
		  return $http.post('http://localhost:9090/MeuProfissa/api/user/signup', user);  
	  };
	  
	  this.login = function(user) {
		  return $http.post('http://localhost:9090/MeuProfissa/api/user/login', user);
	  };
	  
	  this.getMenu = function(token) {
		  return $http.get('http://localhost:9090/MeuProfissa/api/user/getMenu/'+ token);
	  };
  };    

  CoreService.$inject = ['$http']; 
})();