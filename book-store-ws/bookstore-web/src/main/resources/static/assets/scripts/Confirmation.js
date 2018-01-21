BooksStoreApp.factory('Confirmation', function() {
	var confirmModal = {};
	confirmModal.show = function(message, callbackOk) { 
		var modal = $("#confirmModal");
		$("#confirmMessage").empty().append(message);
		$("#confirmOk").one('click', callbackOk); 
		var close = function() {
			modal.modal("hide");
		};
		$("#confirmOk").one('click', close);
		$("#confirmCancel").one("click", close);
	}
	return confirmModal;
});
