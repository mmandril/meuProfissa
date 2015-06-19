(function(){
	'use strict';

	angular.module('CoreModule')
	.directive('menu', function(){
		return {
			restrict: 'E',
			templateUrl: 'view/core/menu.html'
		}
	});

})();