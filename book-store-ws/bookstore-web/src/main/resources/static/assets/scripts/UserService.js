BooksStoreApp.service('UserService',
		function($location, Constants, UserSession) {
			this.invalidate = function() {
				UserSession.setUser(false);
				$location.path(Constants.ROUTES.LOGIN);
			}
			this.isAdminRole = function() {
				var user = UserSession.getUser();
				return (user && user.roles) ? (user.roles
						.indexOf(Constants.ROLES.ADMIN) !== -1) : false;
			}
			this.isLoggedIn = function() {
				var user = UserSession.getUser();
				return (user && user.userName);
			} 
		});