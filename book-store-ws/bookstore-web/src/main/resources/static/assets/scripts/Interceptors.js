BooksStoreApp.config([
		'$httpProvider',
		function($httpProvider) {
			$httpProvider.interceptors.push([
					'$q',
					'$location',
					function($q, $location) {
						return { 
							'responseError' : function(rejection) {
								if (rejection.status >= 300) {
									console.log('responseError:'
											+ rejection.status);
									window.location.href = "#login";
								}
								return $q.reject(rejection);
							}
						};
					} ]);
		} ]);
