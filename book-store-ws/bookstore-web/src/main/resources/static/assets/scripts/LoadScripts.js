(function() {
	var incrementScriptVer = function(scriptName) {
		var version = parseInt(localStorage.getItem(scriptName));
		if (version > 0) {
			version += 1;
		} else {
			version = 1;
		}
		localStorage.setItem(scriptName, version);
		return version;
	};

	// Set your scripts that you want to be versioned here
	var scripts = [ "bower_components/jquery/dist/jquery.min.js",
			"bower_components/bootstrap/dist/js/bootstrap.min.js",
			"bower_components/angular/angular.min.js",
			"bower_components/angular-bootstrap/ui-bootstrap-tpls.js",
			"bower_components/angular-base64/angular-base64.js",
			"bower_components/angular-cookies/angular-cookies.min.js",
			"bower_components/angular-route/angular-route.js",
			"bower_components/angular-resource/angular-resource.min.js",
			"bower_components/angular-sanitize/angular-sanitize.min.js",
			"bower_components/angular-mocks/angular-mocks.js",
			"bower_components/angular-cookies/angular-cookies.min.js",
			"bower_components/angular-animate/angular-animate.min.js",
			"assets/scripts/App.js", "assets/scripts/Alerts.js",
			"assets/scripts/Confirmation.js", "assets/scripts/Constants.js",
			"assets/scripts/Directives.js", "assets/scripts/Filters.js",
			"assets/scripts/Interceptors.js", "assets/scripts/RestDataFactory.js",
			"assets/scripts/Router.js", "assets/scripts/UserService.js",
			"assets/scripts/UserSession.js", "assets/scripts/SessionWatch.js",
			"modules/books/BooksController.js",
			"modules/contacts/ContactsController.js",
			"modules/home/HomeController.js",
			"modules/login/LoginController.js",
			"modules/logout/LogoutController.js",
			"modules/members/MembersController.js",
			"modules/shop/ShopController.js",
			"modules/signup/SignupController.js",
			"modules/welcome/WelcomeController.js" ];
	scripts.map(function(script) {
		var currentScriptVer = incrementScriptVer(script);
		document.write("<script  src='" + script + "?version="
				+ currentScriptVer + " '><\/script>");
	});
})();