BooksStoreApp.controller('LoginController', function(UserSession, $location,
		$http, $routeParams, Constants, Alerts, Token, $resource) {
	var self = this;
	self.name = Constants.CONTROLLERS.MAIN;
	self.params = $routeParams;
	self.model = {};
	self.master = {};
	self.initialize = function() {
		UserSession.setUser(false);
		self.model = self.master;
	}
	self.login = function() {
		Alerts.info('Login in progress. Please wait..');
		UserSession.setUser(self.model);
		var successHandler = function(response) {
			UserSession.setUser(response);
			$location.path(Constants.ROUTES.WELCOME);
			Alerts.info("Welcome " + response.userName);
		}
		var errorHandler = function(error) {
			UserSession.setUser(false);
			Alerts.error(error);
		}
		var newToken = new Token(self.model);
		newToken.$saveData(successHandler, errorHandler);
	};
});
