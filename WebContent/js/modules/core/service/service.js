(function(){
  'use strict';

  angular.module('CoreModule').service('CoreService', CoreService);


  function CoreService ($http) {
	  this.signup = function(user) {
		  return $http.post('http://localhost:9090/MeuProfissa/api/user/signup', user);  
	  };
	  
	  this.login = function(user) {
		  console.log(user);
		  return $http.post('http://localhost:9090/MeuProfissa/api/user/login', user);
	  };
  };    

  CoreService.$inject = ['$http']; 
})();