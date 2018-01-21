BooksStoreApp.factory('UserSession', function(Constants, $base64) {
	var user = {
		userName : '',
		password : ''
	};
	return {
		setUser : function(aUser) {
			user = aUser;
		},
		getUser : function() {
			return user;
		},
		getAuthorization : function() {
			var auth = $base64.encode(user.userName + ":" + user.password);
			var config = {
				'Authorization' : 'Basic ' + auth
			}
			return config;
		}
	}
});
