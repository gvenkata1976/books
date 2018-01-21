BooksStoreApp.service('SessionWatch', function($rootScope, $interval,
		$document, Alerts,UserService) {
	this.start = function(startTime) {
		const TIME_UNIT_DISPLAY = ' minutes';
		const TIMEOUT_MINUTES = 3;
		const MINUTE = 60 * 1000;
		var docElement = angular.element($document);
		var uiEvents = [ "keydown", "keyup", "click", "mousemove",
				"DOMMouseScroll", "mousewheel", "mousedown", "touchstart",
				"touchmove", "scroll", "focus" ];
		
		var intervals = [];
		var listen = function() {
			angular.forEach(uiEvents, function(value, index) {
				docElement.on(value, reset);
			});
		}
		var ignore = function() {
			angular.forEach(uiEvents, function(value, index) {
				docElement.off(value, reset);
			}); 
			angular.forEach(intervals, function(interval) {
				$interval.cancel(interval);
			});
		}
		var monitor = function() {
			$rootScope.timeLeft = TIMEOUT_MINUTES + TIME_UNIT_DISPLAY; 
			intervals.push($interval(monitor, TIMEOUT_MINUTES * MINUTE));
			intervals.push($interval(notify, MINUTE));
			listen();
			console.log('monitor');
		};
		var notify = function() {
			console.log('notify');
			var vTimeIdle = Math.round((Date.now() - startTime) / MINUTE);
			var vTimeLeft = TIMEOUT_MINUTES - vTimeIdle;
			$rootScope.timeLeft = vTimeLeft + TIME_UNIT_DISPLAY;
			if (vTimeLeft <= 0) {
				idleLogout();
			}
		};
		var idleLogout = function() {
			reset();
			UserService.invalidate(window.event, true); 
			ignore(); 
		}
		var reset = function() {
			console.log('reset');
			$rootScope.timeLeft = TIMEOUT_MINUTES + TIME_UNIT_DISPLAY;
			startTime = Date.now();
		};
		monitor();
		notify(); 
	}
});