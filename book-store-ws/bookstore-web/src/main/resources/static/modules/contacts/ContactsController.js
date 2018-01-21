BooksStoreApp.controller('ContactsController',
		function($routeParams, Constants, Alerts) {
			var self = this;
			self.name = Constants.CONTROLLERS.WELCOME;
			self.params = $routeParams;
			self.model = {};
			self.send = function(){ 
				Alerts.success('Send success'+JSON.stringify(self.model))
			}
		});
