BooksStoreApp.controller('WelcomeController', [ '$routeParams', 'UserSession',
		'Constants', function($routeParams, UserSession, Constants) {
			var self = this;
			self.name = Constants.CONTROLLERS.WELCOME;
			self.params = $routeParams;

		} ]);
