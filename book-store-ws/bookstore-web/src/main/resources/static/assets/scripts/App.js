var BooksStoreApp = angular.module('BooksStoreApp', [ 'ngRoute', 'ngResource',
		'ngCookies', 'ui.bootstrap', 'base64' ]);
BooksStoreApp.config(function($qProvider, $locationProvider) {
	$qProvider.errorOnUnhandledRejections(false);
	$locationProvider.hashPrefix(''); 
});

BooksStoreApp.run(function($rootScope, $location, $http, UserService,
		Constants, Alerts, SessionWatch, $httpParamSerializerJQLike) {
	$http.defaults.transformRequest.unshift($httpParamSerializerJQLike);
	$rootScope.$on('$routeChangeStart',
			function(event, next, current) {
				var restrictedPage = $.inArray($location.path(),
						Constants.OPEN_ROUTES) === -1;
				if (restrictedPage && !UserService.isLoggedIn()) {
					Alerts.info('Please signin to continue..');
					UserService.invalidate();
				} else if (UserService.isLoggedIn()) {
					// SessionWatch.start(Date.now());
					Alerts.info('Please wait..');
					$rootScope.UserService = UserService;
				} else {
					// do nothing.. continue..
				}
			});
	$rootScope.$on('$routeChangeSuccess', function(event, next, current) {
		if (next && next.$$route) {
			var path = next.$$route.originalPath;
			$rootScope.currentView = path.substr(1);
		}
	});
});
