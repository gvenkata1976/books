BooksStoreApp.controller('ShopController', function($http, $routeParams,
		Constants, $rootScope) {
	var self = this;
	self.name = Constants.CONTROLLERS.SHOP;
	self.params = $routeParams;
	self.bookList = [];
	self.event = 'view';
	$rootScope.statusMessage = {};
	self.listBooks = function() {
		$http.get(Constants.API.BOOKS).then(function(response) {
			var data = response.data;
			var status = response.status;
			var statusText = response.statusText;
			var headers = response.headers;
			var config = response.config;
			self.bookList = data;
			$rootScope.statusMessage = {
				'status' : 'info',
				'message' : '  List of books available '
			};
		}, function(error) {
			$rootScope.statusMessage = {
				'status' : 'danger',
				'message' : 'Failed to fetch list of books !'
			};
		});
	};
});
