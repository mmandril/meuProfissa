(function(){
	'use strict';

	angular.module('CoreModule')
	.directive('header', function(){
		return {
			restrict: 'E',
			templateUrl: 'view/core/menu.html'
		}
	});

})();