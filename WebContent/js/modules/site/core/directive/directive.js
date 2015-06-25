(function(){
	'use strict';

	angular.module('SiteModule')
	.directive('header', function(){
		return {
			restrict: 'E',
			templateUrl: 'view/core/menu.html'
		}
	});

})();