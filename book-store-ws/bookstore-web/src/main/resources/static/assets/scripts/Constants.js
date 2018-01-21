BooksStoreApp.constant('Constants',
		(function() {
			 var resource  = '/bookstore-web/';
			var api  = {
				TOKEN : resource + 'token',
				BOOKS : resource + 'books/:id',
				MEMBERS : resource + 'members/:id'
			}; 
 
			var routes = {
				BOOKS : '/books',
				CONTACTS : '/contacts',
				HOME : '/home',
				LOGIN : '/login',
				LOGOUT : '/logout',
				MEMBERS : '/members',
				SHOP : '/shop',
				SIGNUP : '/signup',
				WELCOME : '/welcome'
			};
			var forms = {
				BOOK : 'modules/books/forms/form.json',
				LOGIN : 'modules/main/forms/form.json',
				MEMBER : 'modules/members/forms/form.json'
			}
			var controllers = {
				BOOKS : 'BooksController',
				CONTACTS : 'ContactsController',
				HOME : 'HomeController',
				LOGIN : 'LoginController',
				LOGOUT : 'LogoutController',
				MEMBERS : 'MembersController',
				SHOP : 'ShopController',
				SIGNUP : 'SignupController',
				WELCOME : 'WelcomeController',
				ALIAS : 'ctrl'
			}
			var openRoutes = [ routes.HOME, routes.LOGIN, routes.SIGNUP,
					routes.LOGOUT ];
			var roles = {
				ADMIN : 'ROLE_ADMIN',
				USER : 'ROLE_USER'  
			}
			// Use the variable in your constants
			return {
				API : api,
				ROUTES : routes,
				OPEN_ROUTES : openRoutes,
				CONTROLLERS : controllers,
				ROLES : roles,
				FORMS : forms
			}
		})());
