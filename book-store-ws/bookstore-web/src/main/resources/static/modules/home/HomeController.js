BooksStoreApp.controller('HomeController', function(Auth, $routeParams,
		Constants) {
	var self = this;
	self.name = Constants.CONTROLLERS.HOME;
	self.params = $routeParams; 
});
