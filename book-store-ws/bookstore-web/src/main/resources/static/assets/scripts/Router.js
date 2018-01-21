BooksStoreApp.config(function($routeProvider, Constants) {
	$routeProvider.when(Constants.ROUTES.BOOKS, {
		templateUrl : 'modules/books/views/books.html',
		controller : Constants.CONTROLLERS.BOOKS,
		controllerAs : Constants.CONTROLLERS.ALIAS
	}).when(Constants.ROUTES.CONTACTS, {
		templateUrl : 'modules/contacts/views/contacts.html',
		controller : Constants.CONTROLLERS.CONTACTS,
		controllerAs : Constants.CONTROLLERS.ALIAS
	}).when(Constants.ROUTES.HOME, {
		templateUrl : 'modules/home/views/home.html',
		controller : Constants.CONTROLLERS.HOME,
		controllerAs : Constants.CONTROLLERS.ALIAS
	}).when(Constants.ROUTES.LOGIN, {
		templateUrl : 'modules/login/views/login.html',
		controller : Constants.CONTROLLERS.LOGIN,
		controllerAs : Constants.CONTROLLERS.ALIAS
	}).when(Constants.ROUTES.LOGOUT, {
		templateUrl : 'modules/logout/views/logout.html',
		controller : Constants.CONTROLLERS.LOGOUT,
		controllerAs : Constants.CONTROLLERS.ALIAS
	}).when(Constants.ROUTES.MEMBERS, {
		templateUrl : 'modules/members/views/members.html',
		controller : Constants.CONTROLLERS.MEMBERS,
		controllerAs : Constants.CONTROLLERS.ALIAS
	}).when(Constants.ROUTES.SHOP, {
		templateUrl : 'modules/shop/views/shop.html',
		controller : Constants.CONTROLLERS.SHOP,
		controllerAs : Constants.CONTROLLERS.ALIAS
	}).when(Constants.ROUTES.SIGNUP, {
		templateUrl : 'modules/signup/views/signup.html',
		controller : Constants.CONTROLLERS.SIGNUP,
		controllerAs : Constants.CONTROLLERS.ALIAS
	}).when(Constants.ROUTES.WELCOME, {
		templateUrl : 'modules/welcome/views/welcome.html',
		controller : Constants.CONTROLLERS.WELCOME,
		controllerAs : Constants.CONTROLLERS.ALIAS
	}).otherwise({
		template : "<div class='container'></div>"
	});
});