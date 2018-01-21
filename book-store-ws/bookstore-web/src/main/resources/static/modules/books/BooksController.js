BooksStoreApp.controller('BooksController', function($http, $routeParams,
		Constants, Alerts, Confirmation, UserSession, Books) {
	var self = this;
	self.name = Constants.CONTROLLERS.BOOKS;
	self.params = $routeParams;
	self.model = {};
	self.imagePath = '';
	self.bookList = [];
	self.viewName = 'books';
	
	self.listData = function() {
		Books.listData(function(response) {
			self.bookList = response;
			// console.log(response);
			Alerts.success('List of books available shown below');
		}, function(error) {
			Alerts.error(error);
		});

	}
	self.getData = function(data, canSubmit) {
		self.model = data;
		self.imagePath = 'assets/images/books/' + data.barcode + '.jpg';
		if (canSubmit) {
			Books.getData({
				id : self.model.id
			}, function(response) {
				self.model = response;
			}, function(error) {
				Alerts.error(error);
			});
		}
	}
	self.resetData = function() {
		self.model = {};
	}
	self.addData = function(canSubmit) {
		self.currentEvent = 'Add';
		if (self.model && canSubmit) {
			Books.saveData(self.model, function(response) {
				//self.listData();
				self.bookList.push(self.model);
				Alerts.success('Book details saved successfully!');
			}, function(error) {
				Alerts.error(error);
			});
		} else {
			self.model = {}; 
		}
	}
	self.updateData = function(data, canSubmit) {
		self.currentEvent = 'Edit';
		if (data && data.id && canSubmit) {
			Books.updateData({
				id : data.id
			}, self.model, function(response) {
				self.listData();
				Alerts.success('Book details updated successfully!');
			}, function(error) {
				Alerts.error(error);
			});
		} else {
			self.model = data;
		}
	}
	self.submit = function() {
		if (self.currentEvent === 'Edit') {
			self.updateData(self.model, true);
		}
		if (self.currentEvent === 'Add') {
			self.addData(true);
		}
	}
	self.deleteData = function(data) {
		Confirmation.show('Do you want to delete \'' + data.name + '\'?',
				function() {
					Books.remove({
						id : data.id
					});
				});
	};
});
