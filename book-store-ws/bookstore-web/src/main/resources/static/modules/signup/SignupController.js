BooksStoreApp.controller('SignupController', [
		'$rootScope',
		'UserSession',
		'$location',
		'$http',
		'$routeParams',
		'Constants',
		'$filter',
		function($rootScope, UserSession, $location, $http, $routeParams, Constants,
				$filter) {
			var self = this;
			self.name = Constants.CONTROLLERS.MAIN;
			self.params = $routeParams;
			 
		} ]);
