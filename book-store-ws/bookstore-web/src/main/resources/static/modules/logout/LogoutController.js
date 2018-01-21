BooksStoreApp.controller('LogoutController', function($routeParams, Constants,
		Alerts, UserService, $timeout) {
	var self = this;
	self.name = Constants.CONTROLLERS.LOGOUT;
	self.params = $routeParams;
	self.logout = function() {
		Alerts.info(' Logged out. Redirect to login .. ');
		$timeout(function() {
			UserService.invalidate(event, true);
		}, 1000);
	};
});
