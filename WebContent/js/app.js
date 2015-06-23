(function(){
	angular.module('CoreModule', []);
	angular.module('CategoryModule', []);
	angular.module('AdminModule', []);
	angular.module('AdminCategoryModule', []);
	

    var app = angular.module('pto', ['CoreModule', 'CategoryModule', 'AdminModule', 'AdminCategoryModule', 'ui.router', 'ngMaterial', 'LocalStorageModule', 'pascalprecht.translate', 'ngMdIcons', 'highcharts-ng', 'ngAnimate', 'md.data.table']);
    
    app.run(function($rootScope, localStorageService){
    	$rootScope.menu = localStorageService.get('menu');
    });
    
    app.config(function($stateProvider, $urlRouterProvider, localStorageServiceProvider, $mdThemingProvider, $translateProvider){
    	
    	//Themes
    	$mdThemingProvider.theme('default')
        .primaryPalette('teal')
        .accentPalette('brown');
    	
    	localStorageServiceProvider
        .setPrefix('meuProfissa')
        .setStorageType('sessionStorage')
        .setNotify(true, true);
    	
    	$urlRouterProvider.otherwise('/');
    	//Routes Liberado
    	$stateProvider
    	.state('app', {
    		url: '/',
            templateUrl: 'view/core/index.html',
            controller: 'CoreCtrl'
    	})
        .state('category', {
    		url: '/category',
    		templateUrl: 'view/category/index.html',
    		controller: 'CategoryCtrl'
        })
        .state('enter', {
        	url: '/enter',
        	templateUrl: 'view/core/enter.html',
        	controller: 'CoreCtrl'
        })
        
        //Routes Admin
        .state('admin', {
        	url: '/admin',
        	templateUrl: 'view/admin/index.html',
        	controller: 'AdminCtrl',
        	requireLogin: true
        })
        .state('adminCategory', {
        	url: '/admin/category',
        	templateUrl: 'view/admin/category/index.html',
        	controller: 'AdminCategoryCtrl',
        	requireLogin: true
        });
    	
    	
    	
    	//Translate
    	$translateProvider.translations('pt-BR', {
    		'btnLogin': 'Entrar',
    		'btnCadastrar': 'Cadastrar',
    		'btnSearch' : 'Buscar',
    		'btnCancel' : 'Cancelar',
    		'btnSave' : 'Salvar',
    		'homeMenu': 'Início',
    		'categoryMenu': 'Categoria',
    		'partnerMenu': 'Parceiro',
    		'categoriaMenu': 'Categoria',
    		'login': 'Entrar',
    		'cadastro': 'Cadastro',
    		'temCadastro': 'Já possuo um conta!',
    		'nTemCadastro': 'Não possuo um conta!',
    		'searchForm': 'Formulário de busca',
    		'name': 'Nome',
    		'newTitle': 'Nova'
    	});
    	
    	$translateProvider.preferredLanguage('pt-BR');
    	$translateProvider.useSanitizeValueStrategy('escaped');
    });
})();