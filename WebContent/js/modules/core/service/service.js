(function(){
  'use strict';

  angular.module('CoreModule').service('CoreService', CoreService);


  function CoreService ($http) {
	  this.signup = function(user) {
		return $http.post('http://localhost:9090/PTO/api/user/signup', user);  
	  };
  };    

  CoreService.$inject = ['$http']; 
})();