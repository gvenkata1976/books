BooksStoreApp.factory('Alerts', function($timeout, $rootScope, Constants) {
	var alerts = {};
	alerts.info = function(msg) {
		alerts.show('info', msg);
	}
	alerts.success = function(msg) {
		alerts.show('success', msg);
	}
	alerts.warn = function(msg) {
		alerts.show('warning', msg);
	}
	alerts.error = function(msg, rejection) {
		$rootScope.statusMessage = {
			'status' : 'danger',
			'message' : msg,
			'rejection' : rejection
		};
		//alerts.clear();
	}
	alerts.show = function(s, m, r) {
		$rootScope.statusMessage = {
			'status' : s,
			'message' : m
		};
		//alerts.clear();
	}
	alerts.clear = function() {
		$timeout(function() {
			$rootScope.statusMessage = {
				'status' : '',
				'message' : ''
			};
		}, 5000);
	}
	return alerts;
});
