BooksStoreApp.config([ '$resourceProvider', function($resourceProvider) {
	// Don't strip trailing slashes from calculated URLs
	$resourceProvider.defaults.stripTrailingSlashes = false;
} ]);
BooksStoreApp.config(function($httpProvider) {
	var commonHeaders = {
		'Content-Type' : 'application/json'
	};
	$httpProvider.defaults.headers.common = commonHeaders;
	$httpProvider.defaults.headers.post = commonHeaders;
	$httpProvider.defaults.headers.put = commonHeaders;
	$httpProvider.defaults.headers.patch = commonHeaders;
});
BooksStoreApp.factory('RestMethods', function() {
	var methods = {
		'listData' : {
			method : 'GET',
			isArray : true
		},
		'getData' : {
			method : 'GET',
			isArray : false
		},
		'saveData' : {
			method : 'POST',
			transformRequest : function(data){
				return angular.toJson(data);
			}
		},
		'updateData' : {
			method : 'PUT'
		}
	}
	return methods;
});
BooksStoreApp.factory('Token', function($resource, Constants, RestMethods) {
	return $resource(Constants.API.TOKEN, {}, RestMethods);
});
BooksStoreApp.factory('Books', function($resource, Constants, RestMethods) {
	return $resource(Constants.API.BOOKS, {}, RestMethods);
});
BooksStoreApp.factory('Members', function($resource, Constants, RestMethods) {
	return $resource(Constants.API.MEMBERS, {}, RestMethods);
});
