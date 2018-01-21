BooksStoreApp.controller('MembersController', function($http, $routeParams,
		Constants, Alerts, Confirmation) {
	var self = this;
	self.name = Constants.CONTROLLERS.MEMBERS;
	self.params = $routeParams;
	self.model = {};
	self.imagePath = '';
	self.memberList = [];
	self.event = 'view'; 
	self.listMembers = function() {
		$http.get(Constants.API.MEMBERS).then(function(response) { 
			self.memberList = response.data;
			Alerts.success(' List of members available ');
		}, function(error) {
			Alerts.error('Failed to fetch list of members !', error);
		});
	};
	self.submit = function(name) {
		if (angular.isFunction(self[name])) {
			self[name]();
			Alerts.success(' Event ' + name + '  success!');
		}
	}

	self.addMember = function() {
		$http.post(Constants.API.MEMBERS, self.model).then(function(response) {
			self.listMembers();
		}, function(error) {
			Alerts.success('Failed to add member !');
		});
	};
	self.editMember = function() {
		$http.put(Constants.API.MEMBERS + '/' + self.model.id, self.model)
				.then(function(response) {
					Alerts.success(' List of members available ');
				}, function(error) {
					Alerts.error('Failed to add member !', error);
				});
	};
	self.deleteMember = function(member) {

	};

	self.setModelAndEvent = function(member, evnt) {
		self.model = member;
		self.event = evnt;
		if ('view' === evnt) {
			self.imagePath = 'assets/images/members/' + member.memberId
					+ '.jpg';
		}
		if ('delete' === evnt) {
			Confirmation.show('Do you want to delete member \'' + member.name
					+ '\'?', function() {
				return self.deleteMember(member);
			});
		}
	}; 
});